$(document).ready( function() {
    $("input#autocomplete").autocomplete({
    	source: ["/random", "/mix", "/cluster"]
    });
});

function goLuke() {
	var text = $("input#autocomplete").val();
	
	if (text == "/random") {
		moveLinks();
	}
	
//	event.preventDefault();
//	var text = $("input#autocomplete").val();
//	alert(text);
}

//$("input#autocomplete").keypress( function(event) {
//	event.preventDefault();
//	var text = $("input#autocomplete").val();
//	alert(text);
//});


//function goForm() {
//	var text = $("input#autocomplete").val();
//	
//	if (text == "/random") {
//		moveLinks();
//	}
//	
//	return false;
//}