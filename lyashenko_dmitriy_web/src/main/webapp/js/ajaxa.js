var app = angular.module('myapp', []);

	app.controller("HelloCtrl", function ($scope, $http) {

	$scope.greeting = "";
		$scope.randonm = 0;


	$scope.update = function() {

		var note = $scope.name;

		var rop = $scope.randonm;

		var responsePromise2 = $http.get('/helloBody2.html?login=' + $scope.randonm);

		responsePromise2.success(
			function(data, status, headers, config) {
				$scope.randonm = data;
			});
		responsePromise2.error(
			function(data, status, headers, config) {
				alert('AJAX failed!((((');
			});



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
