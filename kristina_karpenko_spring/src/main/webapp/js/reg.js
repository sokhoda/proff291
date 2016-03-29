var app = angular.module('app', []);

app.controller("reg", function ($scope, $http) {
    $scope.greeting = "";

    //===================login==============================
    $scope.logBlur = function () {

        if ($scope.login.length < 4) {
            $scope.errorLog = "Login must be longer 4 sign";
        }

            for (var i = 0; i < $scope.login.length; i++) {
                if ($scope.login[i] == " ") {
                    $scope.errorLog = "Login must not have space";
                }
            }
        var note = $scope.login;
            var responsePromise = $http.get('/islogin.html?login=' + note);
            responsePromise.success(
                function (data, status, headers, config) {
                    $scope.greeting = data;
                });
            responsePromise.error(
                function (data, status, headers, config) {
                    alert('AJAX failed!');
                });
        }

    $scope.logFocus = function () {
        $scope.errorId = "";
    }

});