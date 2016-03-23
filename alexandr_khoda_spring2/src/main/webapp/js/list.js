var app = angular.module('listEntitiesJSP', []);

	app.controller("listEntitiesCtrl", function ($scope, $window, $http) {

		$scope.cnt = 1;
		$scope.totPages = 1;
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

        var setScopeMessage = function(value) {
                $scope.message =  { "mcolor" : "red", "mtext": value};
        };

        var emptyCheck = function(value, name) {
            if (typeof (value) == 'undefined' || value == '') {
                setScopeMessage(name + " can not have ZERO length.");
                return false;
            }
            return true;
        };

        var spaceCheck = function(value, name) {
            if (value.indexOf(' ') >= 0) {
                setScopeMessage(name + " can not contain SPACES.");
                return false;
            }
            return true;
        };

        var minLenCheck = function(value, name, minLen) {
            if (value.length < minLen) {
                setScopeMessage(name + " can not contain < " + minLen + " symbols.");
                return false;
            }
            return true;
        };

        var digitOnlyCheck = function(value, name) {
            if (!/^\d+$/.test(value)) {
                setScopeMessage(name + " must contain digits ONLY.");
                return false;
            }
            return true;
        };

        var passStringCheck = function(value, name) {
            if (/.*[A-Z]+.*/.test(value)) {
                if (/.*[a-z]+.*/.test(value)) {
                    if (/.*\d+.*/.test(value)) {
                        return true;
                    }
                }
            }
            setScopeMessage(name + " must contain small, capital" +
                " letters and digits.");
            return false;
        };

        var loginCheck = function(value, name, minLen) {
            if (emptyCheck(value, name)) {
                if (spaceCheck(value, name))
                    return minLenCheck(value, name, minLen);
                else
                    return false;
            }
            return false;
        };

        var identifierCheck = function(value, name, minLen) {
            if (emptyCheck(value, name)) {
                if (digitOnlyCheck(value, name))
                    return minLenCheck(value, name, minLen);
                else
                    return false;
            }
            return false;
        };

        var confirmPassCheck = function(value, confirmValue) {
            if (value != confirmValue) {
                setScopeMessage(name + "Password and confirmation are not equal.");
                return false;
            }
            return true;
        };

        var passCheck = function(value, confirmValue, name, minLen) {
            if (emptyCheck(value, name)) {
                if (passStringCheck(value, name))
                    if (minLenCheck(value, name, minLen))
                        return confirmPassCheck(value, confirmValue);
                    else
                        return false;
                else
                    return false;
            }
            return false;
        };

		$scope.doRegister = function() {

		//console.log('\'' + $scope.login + '\'');

        if (!loginCheck($scope.login, 'Login', 4)) {
            return;
        }
        if (!identifierCheck($scope.identifier, 'Identifier', 10)) {
            return;
        }
        if (!passCheck($scope.pass, $scope.confirmPass, 'Password', 8)) {
            return;
        }


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
