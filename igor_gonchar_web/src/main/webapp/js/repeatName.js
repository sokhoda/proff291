var app = angular.module('myapp', []);

app.controller("RepeatName", function ($scope, $http) {

    $scope.greeting = "";
    function getRandom() {
        return Math.random() * (10 - 1) + 1;
    }

    var randomNumber = getRandom();

    $scope.update = function () {

        var note = $scope.name;

        var responsePromise = $http.get('/helloBody.html?login=' + $scope.name);
        var randomNumber = getRandom();
        console.log(randomNumber);

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
