var Upbit = require("../index");

var up = new Upbit();

up.getTrades("KRW-ETH",(err,data)=>{

    if (err){
        console.log(err.message);
        return;
    }

    console.log(data);    

},10)