//$(document).ready(function (cnt, totPages) {
//    alert('cnt == totPages');
//    if (cnt == totPages){
//        $("#nextInput").css('visibility','hidden');
//    }
//    if (cnt == 1){
//        $("#previousInput").hide();
//    }
//});
function disableButtons(cnt, totPages) {
    if (cnt == totPages) {
        $("#nextInput").css('visibility', 'hidden');
    }
    if (cnt == 1) {
        $("#previousInput").css('visibility','hidden');
    }
}

var app = angular.module('listEntitiesJSP', []);

	app.controller("listEntitiesCtrl", function ($scope, $window, $http) {

		$scope.cnt = 1;
		$scope.totPages = 1;
		//$scope.vect = $scope.getNumber($scope.number, 'ee');
        //
		$scope.back2Login = function() {
			$window.location.href = '/';
			//console.log('back2login AJAX');
		};

        $scope.doUpdateClient = function(cid, sPortion, cnt, totPages ) {
            //console.log('\'' + $scope.login + '\'');
            $window.location.href =
                '/editClient.html?cid=' + cid + '&portionSize='+ sPortion +
                    '&cnt='+ cnt +'&totPages=' + totPages;
        }

		$scope.doDeleteClient = function() {
		//console.log('\'' + $scope.login + '\'');
		var responsePromise = $http.get('/doDeleteClient.json?login=' + $scope.login +
			'&identifier=' + $scope.identifier + '&pass=' + $scope.pass);

		responsePromise.success(
			function(data, status, headers, config) {
				$scope.message = data;
				console.log(JSON.stringify(data));
			});

		responsePromise.error(
			function(data, status, headers, config) {
				alert('AJAX failed!\n' + data + '\nstatus=' + status);
			});
	}
});
