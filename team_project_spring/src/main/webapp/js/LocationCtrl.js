var app = angular.module('location_app', []);

app.controller("LocationCtrl", function ($scope) {

    $scope.vectorLocs = "";

    $scope.currentPos = 0;

    $scope.next = function() {
        $scope.currentPos = $scope.currentPos + 10;
        var responsePromise = $http.get('/getLocs?startNumber=' + $scope.currentPos);

        responsePromise.success(
            function(data) {
                if(data != null){
                    $scope.vectorLocs = data;
                }
            });
    };

    $scope.prev = function() {
        $scope.currentPos = $scope.currentPos - 10;
        var responsePromise = $http.get('/getLocs?startNumber=' + $scope.currentPos);

        responsePromise.success(
            function(data) {
                if(data != null){
                    $scope.vectorLocs = data;
                }
            });
    };
});