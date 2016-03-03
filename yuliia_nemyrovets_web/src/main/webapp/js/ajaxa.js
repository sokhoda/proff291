var app = angular.module('myapp', []);

app.controller("HelloCtrl", function ($scope, $http) {

	$scope.greeting = "";
	//$scope.vector=[];

	$scope.update = function() {

		var note = $scope.name;

		var responsePromise = $http.get('/hello.html');

		var tmp=data;
		console.log(tmp);

		responsePromise.success(
			function(data, status, headers, config) {
				$scope.greeting = data;
				//for(var i=0; i<5;i++){
				//	$scope.vector.push(note);
				//}

			});
		responsePromise.error(
			function(data, status, headers, config) {
				alert('AJAX failed!');
			});
	}
});
