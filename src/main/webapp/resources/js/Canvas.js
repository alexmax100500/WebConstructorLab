var canvas = document.getElementById('canvas');
var ctx = canvas.getContext('2d');

var Pallet = document.getElementById('Pallet');

var zeroQ, firstQ,secondQ,thirdQ;

zeroQ = document.getElementById('0Q');
firstQ = document.getElementById('1Q');
secondQ = document.getElementById('2Q');
thirdQ = document.getElementById('3Q');

if(zeroQ!=null)
ctx.drawImage(zeroQ,440,15,295,295);
if(firstQ!=null)
ctx.drawImage(firstQ,152,15,295,295);
if(secondQ!=null)
ctx.drawImage(secondQ,152,305,295,295);
if(thirdQ!=null)
ctx.drawImage(thirdQ,448,305,295,295);

ctx.drawImage(Pallet,150,0,600,600);

function loadGraph()
{

}