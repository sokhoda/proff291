

<!doctype html>
<html lang="en" ng-app>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>






<html>
<head>

    <link rel="stylesheet" rel="nofollow" href="http://cdn.leafletjs.com/leaflet-0.5.1/leaflet.css" />
    <script src="http://cdn.leafletjs.com/leaflet-0.5.1/leaflet.js"></script>

    <style>

        #map {width: 1200px; height: 400px; }

    </style>
    <title>Point Relationship on map</title>
</head>
<body>
<div id="map"></div>



<script type='text/javascript'>

    var matrix = [[1, 56.3193, 44.0269],[2, 56.3261,44.1234], [3, 56.3542,44.2312], [4, 56.3672,44.3245]]




    //Определяем карту, координаты центра и начальный масштаб
    var map = L.map('map').setView([56.326944, 44.0075], 12);

    //Добавляем на нашу карту слой OpenStreetMap
    L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: '&copy; <a rel="nofollow" href="http://osm.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(map);



    L.marker([matrix[0][1], matrix[0][2]]).addTo(map)
            .bindPopup("<strong>One</strong><br />Alone marker "+ matrix[0][0]).openPopup();

    L.marker([matrix[1][1], matrix[1][2]]).addTo(map)
            .bindPopup("<strong>Two</strong><br />Alone marker  "+ matrix[1][0]).openPopup();

    L.marker([matrix[2][1], matrix[2][2]]).addTo(map)
            .bindPopup("<strong>Three</strong><br />Alone marker  "+ matrix[2][0]).openPopup();

    L.marker([matrix[3][1], matrix[3][2]]).addTo(map)
            .bindPopup("<strong>Four</strong><br />Alone marker  "+ matrix[3][0]).openPopup();






</script>



</body>
</html>
