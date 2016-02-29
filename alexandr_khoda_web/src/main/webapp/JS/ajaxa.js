var app = angular.module('myapp', []);

	app.controller("HelloCtrl", function ($scope, $http) {

		$scope.number = 5;
		$scope.greeting = "";
		$scope.vect = $scope.getNumber(num, val);

		$scope.getNumber = function(num, val) {
			var arr = new Array(num);
			for (var i = 0; i < num; i++) {
				arr.push(val);
			}
			return arr;
		}

		$scope.update = function() {

		var note = $scope.name;
		$scope.greeting = $scope.name;
		var responsePromise = $http.get('/helloBodyKHO.html?login=' + $scope.name);

		responsePromise.success(
			function(data, status, headers, config) {
				$scope.randInt = data;
			});
		responsePromise.error(
			function(data, status, headers, config) {
				alert('AJAX failed!');
			});
	}
});
