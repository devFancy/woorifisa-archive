'use strict';

var gulp = require('gulp');
var tslint = require('gulp-tslint');
var jasmine = require('gulp-jasmine');
var del = require('del');

var sources = ['./src/**/*.ts'];

function compileTypescript(done) {
  require('child_process').exec('tsc -p ' + process.cwd(), function (err, stdout, stderr) {
    var outString = stdout.toString();
    if (outString) console.log('\n', outString);
    done(err);
  });
}

function watch() {
  gulp.watch([sources], {interval: 2000, ignoreInitial: false }, gulp.series('kill'));
}

function clean(done) {
  del(['./dist', './node_modules'], done);
}

var app;
function start() {
  return launchApp(['dist/app.js']);
}

function debug() {
  return launchApp(['--debug', 'dist/app.js']);
}

function launchApp(params, exitWithCode) {
  var spawn = require('child_process').spawn;
  app = spawn('node', params);
  app.stdout.on('data', function (data) {
    process.stdout.write(data.toString());
  });
  app.stderr.on('data', function (data) {
    process.stderr.write(data.toString());
  });
  app.on('close', function (code) {
    console.log('child process exited with code', code);
    process.exit(exitWithCode && code || 0);
  });
}

function kill() {
  if (app) {
    app.kill('SIGTERM');
  }
  setTimeout(function () {
    process.exit();
  }, 500);
}

function local() {
  compileTypescript(function (err) {
    if (err) {
      console.error('\tfailed to compile. waiting for fix...');
      return;
    }
    debug();
  });
}

function test(fileName = '*[Ss]pec', specPath = './dist/spec/') {
  return function testJasmine() {
    const jasmine = require('gulp-jasmine');
    const SpecReporter = require('jasmine-spec-reporter').SpecReporter;
    const glob = require('glob');

    // for (const key in options.envContents) {
    //   if (process.env[key] !== undefined) continue;
    //   const value = options.envContents[key];
    //   process.env[key] = value;
    // }

    const pattern = `${specPath}${fileName}.js`;
    const files = glob.sync(pattern);
    if (files.length === 0) {
      console.warn(`There is no .spec files.\nTest step ignored.\nPattern: ${pattern}`);
      return gulp.src('empty', { allowEmpty: true });
    }

    return gulp.src(files)
      .pipe(jasmine({
        // verbose: true,
        includeStackTrace: true,
        reporter: new SpecReporter({  // add jasmine-spec-reporter
          spec: {
            displayPending: true
          }
        }),
        config: {
          random: false
        }
      }));
  }
}


// function jasmineWatchTask(name) {
//   var buildAndTest = 'run-' + name;
//   gulp.task(name, () => {
//     gulp.watch(sources, { ignoreInitial: false }, gulp.series('compile', test(name)));
//   });
//   gulp.task(buildAndTest, () => {
//     gulp.src('./dist/spec/' + name + '.js')
//       .pipe(jasmine());
//   });
//   // gulp.task(name, [buildAndTest], function () {
//   //   gulp.watch(sources, [buildAndTest]);
//   // });
//   // gulp.task(buildAndTest, ['build'], function () {
//   //   gulp.src('./dist/spec/' + name + '.js')
//   //     .pipe(jasmine());
//   // });
// }

function lint() {
  if (process.env.npm_lifecycle_event === 'test') return;
  return gulp.src('src/**/*.ts')
      .pipe(tslint({
          formatter: 'stylish'
      }))
      .pipe(tslint.report({
          summarizeFailureOutput: true
      }));
}


gulp.task('clean', clean);
gulp.task('tslint', lint);
gulp.task('build', gulp.series('tslint', compileTypescript));
gulp.task('watch', watch);
gulp.task('kill', kill);
gulp.task('start', start);
gulp.task('debug', debug);
gulp.task('local', gulp.series('watch', local));
gulp.task('test', gulp.series(test()));

// (function registerJasmineTasks() {
//   var files = require('glob').sync('./dist/spec/*.js');
//   files.forEach(function (name) {
//     var taskName = name.match(/^.*\/(.*)\.js$/)[1];
//     jasmineWatchTask(taskName);
//   });
// })();

(function registerJasmineTasks() {
  const specPath = './dist/spec/';
  const glob = require('glob');
  const files = glob.sync(`${specPath}*.js`);
  files.forEach(function (name) {
    // ./dist/spec/abc.spec.js => abc.spec
    const taskName = name.match(/^.*\/(.*)\.js$/)[1];
    gulp.task(taskName, function watchTypescriptsforSpec(done) {
      gulp.watch(options.sources, { ignoreInitial: false }, gulp.series('compile', test(taskName)));
    });
  });
})();
