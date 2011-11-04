/** Writes a set of script tags for loading in HTML in one line */

loadscript('https://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js');
loadscript('javascript/screen.js');
loadscript('javascript/links.js');
loadscript('javascript/debug.js');

function loadscript(src) {
	document.write('<script type="text/javascript" src="' + src + '"></script>');
}

