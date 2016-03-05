var app = angular.module('myApp', []);

    app.controller("HelloCtrl", function ($scope, $http) {

        $scope.greeting = "";
        $scope.array = [];

        $scope.update = function() {

            var note = $scope.name;

            var responsePromise = $http.get('/helloBody.html?login=' + $scope.name);

            responsePromise.success(
                function(data, status, headers, config) {
                    for ( var i = 0; i < parseInt(data); i++ ) {
                        $scope.array[i] = note;
                    }
                });
            responsePromise.error(
                function(data, status, headers, config) {
                    alert('AJAX failed!');
            });
        }
    });
