var app = angular.module('regJSP', []);

	app.controller("RegisterCtrl", function ($scope, $window, $http) {

		$scope.randInt = 11;
		//$scope.greeting = "";
		//$scope.vect = $scope.getNumber($scope.number, 'ee');
        //
		$scope.getNumber = function(num, val) {
			var arr = new Array();
			for (var i = 0; i < num; i++) {
				arr.push(val);
			}
			return arr;
		};

		$scope.getNumber3 = function() {
			var arr = new Array();
			for (var i = 0; i < $scope.randInt; i++) {
				arr.push($scope.name);
			}

			return arr;
		};

		var getNumber4 = function() {
			var arr = new Array();
			for (var i = 0; i < $scope.randInt; i++) {
				arr.push($scope.name);
			}

			return arr;
		};

		$scope.back2Login = function() {
			$window.location.href = '/';
			//console.log('back2login AJAX');
		};
		$scope.test = function() {
			var responsePromise = $http.get('/testJson.json');
			responsePromise.success(
				function(data, status, headers, config) {
					$scope.message = data;
					console.log(JSON.stringify(data));
					//$scope.messageColor = data.messageC
					//alert(JSON.stringify(data));
				});


			responsePromise.error(
				function(data, status, headers, config) {
					alert('AJAX failed!\n' + data + '\nstatus=' + status);
				});

		};
		$scope.doRegister = function() {
		console.log($scope.login);

		$scope.greeting = $scope.name;
		var responsePromise = $http.get('/doRegister.json?login=' + $scope.login +
			'&identifier=' + $scope.identifier + '&pass=' + $scope.pass);


		responsePromise.success(
			function(data, status, headers, config) {
				$scope.message = data;
				console.log(JSON.stringify(data));
				//$scope.messageColor = data.messageC
				//alert('data=' + data.mText);
			});


		responsePromise.error(
			function(data, status, headers, config) {
				alert('AJAX failed!\n' + data + '\nstatus=' + status);
			});



	}
});
