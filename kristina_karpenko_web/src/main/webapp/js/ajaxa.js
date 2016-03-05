var app = angular.module('myapp', []);

app.controller("HelloCtrl", function ($scope, $http) {

    $scope.greeting = "";
    $scope.number = 6;
    $scope.vector= {name:''};
    $scope.update = function () {

        var note = $scope.name;

        var responsePromise = $http.get('/helloBody.html?login=' + $scope.name);

        responsePromise.success(
            function (data, status, headers, config) {
                $scope.number = data;
                for (var i = 0; i < $scope.number; i++) {
                    $scope.vector.push(i);
                }
                //$scope.greeting = data;
                //for(var i=0; i<$scope.number;i++){
                //    $scope.vector.push(i);
                //}
                $scope.greeting = "Krisssss!!!!!!!!!";
            });
        responsePromise.error(
            function (data, status, headers, config) {
                alert('AJAX failed!');
            });
    }
});
