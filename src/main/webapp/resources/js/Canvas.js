var canvas = document.getElementById('canvas');
var ctx = canvas.getContext('2d');

var Pallet = document.getElementById('Pallet');

var zeroQ, firstQ,secondQ,thirdQ;

zeroQ = document.getElementById('0Q');
firstQ = document.getElementById('1Q');
secondQ = document.getElementById('2Q');
thirdQ = document.getElementById('3Q');

Pallet.onload = function() {
    ctx.drawImage(Pallet, 150, 0, 600, 600);
}

zeroQ.onload = function () {
    ctx.drawImage(zeroQ, 440, 15, 295, 295);
}
firstQ.onload = function() {
    ctx.drawImage(firstQ, 152, 15, 295, 295);
}
secondQ.onload = function() {
    ctx.drawImage(secondQ, 152, 305, 295, 295);
}
thirdQ.onload = function() {
    ctx.drawImage(thirdQ, 448, 305, 295, 295);
}


function loadGraph()
{

}