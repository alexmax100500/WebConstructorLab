var canvas = document.getElementById('canvas');
var ctx = canvas.getContext('2d');

var Pallet = document.getElementById('Pallet');

var zeroQ, firstQ,secondQ,thirdQ;

zeroQ = document.getElementById('0Q');
firstQ = document.getElementById('1Q');
secondQ = document.getElementById('2Q');
thirdQ = document.getElementById('3Q');



zeroQ.onload = setTimeout(function () {
    ctx.drawImage(zeroQ, 347, 15, 295, 295);
},100);
firstQ.onload = setTimeout(function() {
    ctx.drawImage(firstQ, 60, 15, 295, 295);
},100);
secondQ.onload = setTimeout(function() {
    ctx.drawImage(secondQ, 60, 305, 295, 295);
},100);
thirdQ.onload = setTimeout(function() {
    ctx.drawImage(thirdQ, 355, 305, 295, 295);
},100);

Pallet.onload = setTimeout(function() {
    ctx.drawImage(Pallet, 50, 0, 600, 600);
},200);
function loadGraph()
{

}