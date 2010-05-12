var map = null;
var marker;

//TO DO
//hidden input for map.setCenter

function initialize() {
	if (GBrowserIsCompatible()) {
		map = new GMap2(document.getElementById("map_canvas"));
		map.setMapType(G_SATELLITE_MAP);
		map.setCenter(new GLatLng(-45.028202, 168.654728), 15);
		map.addControl(new GSmallMapControl());
		geocoder = new GClientGeocoder();
			GDownloadUrl("xml/polylines.xml", function(data) {
	          var xml = GXml.parse(data);
	          var markers = xml.documentElement.getElementsByTagName("marker");
	          for (var i = 0; i < markers.length; i++) {
	        	var encodedPoint = markers[i].getAttribute("pt");
	        	var encodedLevel = markers[i].getAttribute("lvl");
	            var latlng = new GLatLng(parseFloat(markers[i].getAttribute("lat")),
	                                    parseFloat(markers[i].getAttribute("lng")));
	            var marker = createMarker(latlng);
				var polyline = createPolyline(encodedPoint,encodedLevel)
	          }//for
	        });//GDownload
	    }
	}

function createPolyline(point,level) {
	var polyline = new GPolyline.fromEncoded({
		color: "#FFFF00",
		weight: 10,
		points: point,
		levels: level,
		zoomFactor: 32,
		numLevels: 4
		});
	map.addOverlay(polyline);
	return polyline;
}

function createMarker(point) {
    var marker = new GMarker(point);
    GEvent.addListener(marker, "click", function(){
    	marker.openInfoWindowHtml('<img src="img/test.jpg"/>');
    	});
	map.addOverlay(marker);
    return marker;
  }
