
function Player(name, money) {

	this.name = name;
	this.money = money;

}

var book = new Player("Java", "123");

var res = (x, y) =>{


}

var objects = [] 

objects.push(new Player("A", 500));
objects.push(new Player("B", 500));
objects.push(new Player("C", 500));

function play(objects) {
	console.log("Players are playing the match");
}

function draw(x, y) {

  console.log("drawing circle");
  var c = document.getElementById('canvas');

  if (canvas.getContext) {
	var ctx = c.getContext('2d');
	ctx.canvas.height = window.innerHeight;
	ctx.canvas.width = window.innerWidth;
	ctx.beginPath();
	ctx.arc(x,y,50,0*Math.PI,2*Math.PI);
	ctx.stroke();
	ctx.closePath();
}
}

play(objects);

document.addEventListener("click", (event) => {
	console.log(event.x);
	console.log(event.y);
	draw(event.x, event.y);
})