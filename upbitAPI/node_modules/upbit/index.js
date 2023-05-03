var request = require("request");

var Upbit = function()
{
    this.url = "https://crix-api-endpoint.upbit.com/v1/crix/";
}

Upbit.prototype.getTrades =  function (market, cb, count) {
        var path, url, qs;

        path = "trades/ticks";
        qs = "?code=CRIX.UPBIT."
        
        url = this.url+path+qs+market;

        if(count)
        {
            url += "&count="+count;
        }
        
        return request(url, (err, response, body) => {
          let error, result
          if (err || (response.statusCode !== 200 && response.statusCode !== 400)) {
            return cb(new Error(err != null ? err : response.statusCode))
          }
          try {
            result = JSON.parse(body)
          } catch (error1) {
            error = error1
            return cb(null, {
              message: body.toString()
            })
          }
          if (result.message != null) {
            return cb(new Error(result.message))
          }
          return cb(null, result)
        })
      }


module.exports = Upbit;