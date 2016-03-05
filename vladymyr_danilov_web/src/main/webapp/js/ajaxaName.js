var app = angularModule('myApp', []);

    function HelloNameCtrl ($scope, $http) {
        $scope.greeting = "";
        $scope.update = function() {

            var note = $scope.name;
            //$scope.array = [];

            var responsePromise = $http.get('/angularNameController.html?login=' + $scope.name);

            responsePromise.success(
                function(data, status, headers, config) {
                    for ( var i = 0; i < data; i++ ) {
                        //$scope.array[i] = data;
                        $scope.greeting = data;
                    }
                });
            responsePromise.error(
                function(data, status, headers, config) {
                    alert('AJAX failed!');
                });
        };
    }

    app.controller('HelloNameCtrl', HelloNameCtrl);