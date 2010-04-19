var map = null;
var geocoder = null;
var marker;
var tabAccuracy = new Array(2,4,6,10,12,13,16,16,17,18);


function initialize() {
    if (GBrowserIsCompatible()) {
        map = new GMap2(document.getElementById("map"));
        map.addControl(new GLargeMapControl());
        map.setCenter(new GLatLng(0,0), 2);

        geocoder = new GClientGeocoder();
        GEvent.addListener(map, "click", clicked);
    }
}

function clicked(overlay, latlng) {
    if (latlng) {
        geocoder.getLocations(latlng, function(addresses) {
            if(addresses.Status.code != 200) {
                alert("reverse geocoder failed to find an address for " + latlng.toUrlValue());
            }
            else {
                map.clearOverlays();
                address = addresses.Placemark[0];
                marker = new GMarker(latlng, {draggable: true});
                map.addOverlay(marker);

                point2address();

                GEvent.addListener(marker, "dragstart", function() {
                    map.closeInfoWindow();
                });

                GEvent.addListener(marker, "dragend", point2address);
            }
        })
    }
}

function point2address(flag) {
    point = marker.getPoint();
	var latlng = marker.getLatLng();
	var lat = latlng.lat();
    var lng = latlng.lng();
    geocoder.getLocations(point, function(addresses) {
        if(addresses.Status.code != 200) {
            alert("reverse geocoder failed to find an address for " + point.toUrlValue());
        }
        else {
            address = addresses.Placemark[0];
            var myHtml = "<form name='updateLocation' action='' method='post'><table>" +
			 			 "<tr><td><h4>Latitude:</h4></td> <td><input type='text' name='latitude' value=" + lat + "></input> </td> </tr>" +
						 "<tr><td><h4>Langitude:</h4></td> <td><input type='text' name='langitude' value=" + lng + "></input> </td> </tr>" +
						 "<tr><td></td><td><input type='submit' value='Save'/></td></tr>"
						 "</table></form>";
						 
           
            marker.openInfoWindow( myHtml);
        }
        map.setZoom( tabAccuracy[address.AddressDetails.Accuracy] );
    });
}

function addCoordsToMap(response) {
    map.clearOverlays();
    if (!response || response.Status.code != 200) {
        alert('Address not found');
    } 
    else {
        place = response.Placemark[0];
        point = new GLatLng(place.Point.coordinates[1],
                            place.Point.coordinates[0]);
        marker = new GMarker(point, {draggable: true});
        map.addOverlay(marker);

        point2address("plus original address");
        
        GEvent.addListener(marker, "dragstart", function() {
            map.closeInfoWindow();
        });

        GEvent.addListener(marker, "dragend", point2address);
    }
}

function showAddress(address) {
    if (geocoder) {
        geocoder.getLocations(address,addCoordsToMap)
    }
}