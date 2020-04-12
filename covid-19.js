var map;
var database;
var currentLocation = {
    lat: 39.0248413,
    lng: -77.4633779
};
function setup() {
  var firebaseConfig = {
    apiKey: "AIzaSyClbFNL458EgSmLqHDeZ6KCsiqPB1XTtvE",
    authDomain: "hackathon-4-first-responders.firebaseapp.com",
    databaseURL: "https://hackathon-4-first-responders.firebaseio.com",
    projectId: "hackathon-4-first-responders",
    storageBucket: "hackathon-4-first-responders.appspot.com",
    messagingSenderId: "137381017585",
    appId: "1:137381017585:web:eb7f8697df0e34fe40b650"
  };
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);
  database = firebase.database();
  }

  function errData(error)
  {
    console.log('Error:');
    console.log(error);
  }
  function displayMarkers(data){
    console.log(data.val());
    var volunteers = data.val();
    var keys = Object.keys(volunteers);
    console.log(keys);
    //console.log(keys[0]);
    for(var i = 0; i < keys.length; i++)
    {
      var k = keys[i];
      var name = volunteers[k].name;
      var add = volunteers[k].address;
      console.log(name, add);
    }
  }

  function pinSymbol(color) {
    return {
        path: 'M 0,0 C -2,-20 -10,-22 -10,-30 A 10,10 0 1,1 10,-30 C 10,-22 2,-20 0,0 z',
        fillColor: color,
        fillOpacity: 1,
        strokeColor: '#000',
        strokeWeight: 2,
        scale: 1
    };
}

  function getData(services, forDate){
    //console.log(services, forDate);
    if(!database)
    {
      setup();
    }
    //var volunteers;
    var serviceDate = convertToDate(forDate);
    for(var i=0; i < services.length; i++)
    {
      var root = services[i].concat('/', serviceDate.getFullYear(), serviceDate.getMonth(), serviceDate.getDate());
      var ref = database.ref(root);
      console.log(root);
      var retval = ref.on("value", function(snapshot){
        var volunteers = snapshot.val();
        if(!volunteers)
          return snapshot.val();
        var reference = snapshot.getRef().toString();
        var tokens = reference.split('/');
        var parentKey = tokens[tokens.length - 2];
        console.log(tokens, parentKey);
        var keys = Object.keys(volunteers);
        var places;
        for(var i = 0; i < keys.length; i++)
        {
          var k = keys[i];
          var name = volunteers[k].name;
          var add = volunteers[k].address;

          console.log(services[i]);
          var color = 'yellow';
          switch(parentKey)
          {
            case 'House':
              color = 'red';
              break;
            case 'Grocery':
              color = 'green';
              break;
            case 'Childcare':
                color = 'blue';
                break;
          }

          var address = add.address1.concat(',', add.city, ',', add.state,',',add.zipcode);
          var html = '<div>'+name +'<br/>'+ address + '<br/>'
          console.log(address);
          geocoder = new google.maps.Geocoder();
          geocoder.geocode( { 'address': address}, function(results, status) {
           if (status == 'OK') {
             console.log(results);
             map.setCenter(results[0].geometry.location);
             var marker = new google.maps.Marker({
                 map: map,
                 position: results[0].geometry.location,
                 icon: pinSymbol(color)
             });
             var infowindow = new google.maps.InfoWindow({
               maxWidth: 350
             });
            google.maps.event.addListener(marker, 'mouseover', function() {
              infowindow.setContent(html);
              infowindow.open(map, marker);
            });

            google.maps.event.addListener(marker, 'mouseout', function() {
              infowindow.close();
            });
           } else {
             alert('Geocode was not successful for the following reason: ' + status);
           }
         });
        }
        return snapshot.val();
      })
    }
  }


  function convertToDate(datestring)
  {
    var parts =datestring.split('-');
    var mydate = new Date(parts[0], parts[1] - 1, parts[2]);
    return mydate;
  }

  function saveData(services, data, start, end)
  {
    if(!database)
    {
      setup();
    }
    console.log(start, end);
    var startDate = convertToDate(start);
    var endDate = convertToDate(end);
    console.log(startDate, endDate);
    var loop = startDate;
    while(loop <= endDate)
    {
      console.log(loop);
      for(var i=0; i < services.length; i++)
      {
        var root = services[i].concat('/', loop.getFullYear(), loop.getMonth(), loop.getDate());
        console.log(root);
        var ref = database.ref(root);
        ref.push(data);
      }
      var newDate = loop.setDate(loop.getDate() + 1);
      loop = new Date(newDate);
    }
  }

function initMap() {
    // Create the map.
    if (navigator.geolocation) {
        try {
            navigator.geolocation.getCurrentPosition(function(position) {
                currentLocation = {
                    lat: position.coords.latitude,
                    lng: position.coords.longitude
                };
                console.log(currentLocation);
                map = new google.maps.Map(document.getElementById('map'), {
                    center: currentLocation,
                    zoom: 10,
                    accuracy:"high"
                });
                map.setCenter(currentLocation);
                var marker = new google.maps.Marker({
                    map: map,
                    position: currentLocation,
                    icon: pinSymbol('yellow')
                });
            });
        } catch (err) {

        }
    }
    /*navigator.geolocation.getCurrentPosition(function(position) {
        var pyrmont = {
            lat: position.coords.latitude,
            lng: position.coords.longitude
        };
        map = new google.maps.Map(document.getElementById('map'), {
            center: pyrmont,
            zoom: 17,
            accuracy:"high"
        });
        var marker = new google.maps.Marker({
          position: pyrmont,
          map: map
        });

        var address = "1329A Blueberry Lane, Fairfax, VA 22033";
        geocoder = new google.maps.Geocoder();
        geocoder.geocode( { 'address': address}, function(results, status) {
     if (status == 'OK') {
       console.log(results);
       map.setCenter(results[0].geometry.location);
       var marker = new google.maps.Marker({
           map: map,
           position: results[0].geometry.location
       });
     } else {
       alert('Geocode was not successful for the following reason: ' + status);
     }
   });


        console.log('test-2');
    });



    // Create the places service.
    var service = new google.maps.places.PlacesService(map);

    // Perform a nearby search.
    service.nearbySearch({
            location: pyrmont,
            radius: 4000,
            type: ['housing']
        },
        function(results, status, pagination) {
            if (status !== 'OK') return;

            createMarkers(results);
            getNextPage = pagination.hasNextPage && function() {
                pagination.nextPage();
            };
        });*/

}

function createMarkers(places) {
    var bounds = new google.maps.LatLngBounds();
        for (var i = 0, place; place = places[i]; i++) {
        var image = {
            url: place.icon,
            size: new google.maps.Size(71, 71),
            origin: new google.maps.Point(0, 0),
            anchor: new google.maps.Point(17, 34),
            scaledSize: new google.maps.Size(25, 25)

        };

        var marker = new google.maps.Marker({
            map: map,
            icon: image,
            title: place.name,
            position: place.geometry.location

        });
        bounds.extend(place.geometry.location);
    }
    map.fitBounds(bounds);
}
