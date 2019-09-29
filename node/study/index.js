const { odd, even } = require('./var');
const chectkNumber = require('./func');

function checkStringOddOrEven(str){
    if(str.length % 2) {
        return odd;
    }
    return even;
}

console.log(chectkNumber(10));
console.log(checkStringOddOrEven('hello'));