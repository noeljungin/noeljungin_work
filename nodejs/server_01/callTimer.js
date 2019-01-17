var module = require('./customTimer');

module.timer.on('tick', function(time){
   var time = new Date();
   console.log('now:' + time);
});