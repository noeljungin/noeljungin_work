var eventEmitter = require('events');

var sec = 1;

exports.timer = new eventEmitter();

//setinterval을 사용해서 1초에 한번씩 timer 객체에
//tick 이벤트 발생
setInterval(function(){
   exports.timer.emit('tick');
}, sec * 1000);

