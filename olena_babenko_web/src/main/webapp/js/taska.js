var app = angular.module('test', []);

app.controller("taskCtrl", function ($scope, $http) {

    $scope.number = Math.floor(Math.random()*10);
    $scope.value = '';
    $scope.vector = [];

    $scope.createVector = function(data){
        for (var i=0;i<$scope.number; i++){
            $scope.vector[i] = data;
        }
    }

    $scope.update = function() {

        var responsePromise = $http.get('/helloBody.html?login=' + $scope.name);

        responsePromise.success(
            function(data, status, headers, config) {
                    $scope.createVector(data);
            });
        responsePromise.error(
            function(data, status, headers, config) {
                alert('AJAX failed!');
            });
    }
});

