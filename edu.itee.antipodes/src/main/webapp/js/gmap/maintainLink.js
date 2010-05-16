var map = null;
var geocoder = null;
var marker;
var tabAccuracy = new Array(2,4,6,8);
var lt = document.loc.latitude.value
var lg = document.loc.longitude.value
var loc = document.loc.locationName.value


function initialize() {
    if (GBrowserIsCompatible()) {
        map = new GMap2(document.getElementById("map"));
        map.addControl(new GLargeMapControl());
        var latlng = new GLatLng(document.getElementById("latitude").value, document.getElementById("longitude").value);
        var lat = document.getElementById("latitude").value;
        var lng = document.getElementById("longitude").value;
        //map.setCenter(new GLatLng(document.getElementById("latitude").value,document.getElementById("longitude").value), 8);
        map.setCenter(latlng, 8);
        geocoder = new GClientGeocoder();
        GEvent.addListener(map, "click", clicked);
        if (lat!=0 && lng!=0)
        {
        	addCoords();
        }
        
    }
}

function createMarker(point) {
    var marker = new GMarker(point, {draggable: true});
	map.addOverlay(marker);    
    return marker;
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
            var myHtml = '<b>Latitude:</b>&nbsp;'+ lat + '<br/>' + 
            '<b>Langitude:</b>&nbsp;' + lng + '<br/>';
           
            marker.openInfoWindow( myHtml);
            document.forms['loc'].latitude.value = lat;
            document.forms['loc'].longitude.value = lng;
        }
        map.setZoom( tabAccuracy[address.AddressDetails.Accuracy] );
    });
}

function addCoords() {
    map.clearOverlays();

        latlng = new GLatLng(document.getElementById("latitude").value, document.getElementById("longitude").value);
        marker = new GMarker(latlng, {draggable: true});
        map.addOverlay(marker);

        point2address("plus original address");
        
        GEvent.addListener(marker, "dragstart", function() {
            map.closeInfoWindow();
        });

        GEvent.addListener(marker, "dragend", point2address);

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
        latlng = new GLatLng(document.getElementById("latitude").value, document.getElementById("longitude").value);
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