var app = angular.module('myapp', []);

	app.controller("HelloCtrl", function ($scope, $http) {

	$scope.greeting = "";

	$scope.update = function() {

		var note = $scope.name;

		var responsePromise = $http.get('/helloBody.html?login=' + $scope.name);

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
