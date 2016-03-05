var app = angular.module('newapp', []);

app.controller("MyCtrl", function ($scope, $http) {

    $scope.count = 0;

    $scope.update = function() {

        var responsePromise = $http.get('/random.html?login=' + $scope.login);

        responsePromise.success(
            function(data, status, headers, config) {
                $scope.count = data;
            });
        responsePromise.error(
            function(data, status, headers, config) {
                alert('AJAX count failed!');
            });
    }
});
