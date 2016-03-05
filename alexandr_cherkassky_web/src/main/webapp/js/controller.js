var app = angular.module('myapp', []);

	app.controller("HelloCtrl", function ($scope) {

		$scope.greeting = "";
		$scope.howMuchPrint;

		$scope.update = function() {

			if ($scope.name) {
				$scope.greeting = 'Hello, '+$scope.name+'!';
			}
			$scope.howMuchPrint = math.random(10);



			$scope.people = [
				{"name": "Nexus S",
					"age": "1"},
				{"name": "Motorola XOOM™ with Wi-Fi",
					"age": "2"},
				{"name": "MOTOROLA XOOM™",
					"age": "3"}
			];
		}
	});
