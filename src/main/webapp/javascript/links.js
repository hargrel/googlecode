function moveLink(id) {
	var left = generateMovementStrings().left;
	var top = generateMovementStrings().top;
	
	$(id).animate({left: left, top: top}, 1000);
}

function generateMovementStrings() {
	var left = "+=500";
	var top = "+=50";
	
	return ( {left:left, top:top} );
}