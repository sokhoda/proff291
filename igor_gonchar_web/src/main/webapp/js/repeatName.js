var app = angular.module('myapp', []);

app.controller("RepeatName", function ($scope, $http) {

    $scope.greeting = "";

    /* function getRandom() {
     return Math.random() * (10 - 1) + 1;
     }
     var randomNumber = getRandom();
     var randomNumber = getRandom();
     console.log(randomNumber); */

    $scope.update = function () {

        var note = $scope.name;

        var responsePromise = $http.get('/randomNumber.html');

        var temp = data;
        console.log(temp);

        responsePromise.success(
            function (data, status, headers, config) {
                //$scope.greeting += data;
                $scope.greeting = data;
            });
        responsePromise.error(
            function (data, status, headers, config) {
                alert('AJAX failed!');
            });
    }
});
