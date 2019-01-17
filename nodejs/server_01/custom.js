//make events module
var eventEmitter = require('events');

//events module reset
var cunstomObject = new eventEmitter();

cunstomObject.on('call', () => {
    console.log('called events');
});

cunstomObject.emit('call')