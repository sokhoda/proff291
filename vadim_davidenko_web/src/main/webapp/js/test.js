/**
 * Created by Вадим on 28.02.2016.
 */

var app = angular.module('myTest', []);

app.controller("TestCtrl", function ($scope, $http) {

    $scope.greeting = "";

    $scope.update = function() {

        var note = $scope.name;

        var responsePromise = $http.get('/testBody.html?name=' + $scope.name);

        responsePromise.success(
            function(data, status, headers, config) {
                $scope.greeting = data;
            });
        responsePromise.error(
            function(data, status, headers, config) {
                alert('AJAX failed!');
            });
    }
});
