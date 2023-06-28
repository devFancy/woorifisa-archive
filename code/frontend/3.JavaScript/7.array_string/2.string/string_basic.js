novel = 'The Little Prince';
const author = 'Saint-Exupery';

// 템플릿 리터럴(Template literal) 방식
console.log(`My favorite nobel is ${novel} 
by ${author}.`); // 변수 동적 바인딩, 줄바꿈 가능

const address =
  'Homer J. Simpson\n' +
  '742 Evergreen Terrace\n' +
  'Springfield';

console.log(address);

const address2 = `Homer J. Simpson
                 742 Evergreen Terrace
                 Springfield`;

console.log(address2);

function createOAuthString(host, clientId, scope) {
    return host + '/login/oauth/authorize?client_id=' + clientId + '&scope=' + scope
  }
  
createOAuthString('https://github.com', 'abc123', 'repo,user');