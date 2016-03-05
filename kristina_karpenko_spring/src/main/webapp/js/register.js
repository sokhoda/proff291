var app = angular.module('app', []);

app.controller("reg", function ($scope, $http) {

    $scope.greeting = "";
    $scope.idNumber = 0;
    $scope.login="lo";
    $scope.pas="pas";
    $scope.update = function () {

        var note = $scope.login;

        var responsePromise = $http.get('/helloBody.html?login=' + $scope.login);

        responsePromise.success(
            function (data, status, headers, config) {
                $scope.greeting = "erffdfderr";
            });
        responsePromise.error(
            function (data, status, headers, config) {
                alert('AJAX failed!');
            });
    }
    //==================register====================
    $scope.register = function () {

        //var note = $scope.login;

        var responsePromise = $http.post('/register.html?login=' +$scope.login+ $scope.idNumber+$scope.pas);
        //var responsePromise = $http.post
        responsePromise.success(
            function (data, status, headers, config) {
                $scope.greeting = data;
            });
        responsePromise.error(
            function (data, status, headers, config) {
                alert('AJAX failed!');
            });
    }
    //=================================================
    $scope.logBlur = function () {

        if ($scope.login.length < 4) {
            $scope.errorLog = "Login must be longer 4 sign";
        }
        for (var i = 0; i < $scope.login.length; i++) {
            if ($scope.login[i] == " ") {
                $scope.errorLog = "Login must not have space";
            }
        }
    }
    $scope.logFocus = function () {
        $scope.errorId = "";
    }
    //========================id==============
    $scope.idBlur = function () {

        if ($scope.idNumber.length != 10) {
            $scope.errorId = "Id Number must be 10 sign";

        }



        //var numb = $scope.idNumber.match([0-9])///\d/);
        //
        //if(numb != $scope.idNumber){ $scope.errorId = "Id Number must have only 10 number";}
        //for (var i = 0; i < 10; i++) {

        //if ($scope.idNumber[i]  != [0-9/d]) {
        //    $scope.errorId = "Id Number must not have letter";
        //}
        //  $scope.idNumber.match([0-9]);

    }

    $scope.idFocus = function () {
        $scope.errorId = "";
    }
//=====================password===========
    $scope.pasBlur = function () {
        var p = $scope.pas;
        if (($scope.pas.match(/d+/))) {
            $scope.errorPas = "Password is  Good";
        }
        if ($scope.pas.length < 8) {
            $scope.errorPas = "Password must be longer 8 sign";
        }
        if ((p.match(/[A-Za-z0-9]/)) == $scope.pas) {
            $scope.errorPas = "Password Good";
        }
        for (var i = 0; i < $scope.pas.length; i++) {
            if ($scope.pas[i] == " ") {
                $scope.errorPas = "Password must not have space";
            }
        }
        //else{
        //    $scope.errorPas = "Password is Good";
        //}
    }
    $scope.pasFocus = function () {
        $scope.errorPas = "";
    }
//=============ConfirmPas===========
    $scope.pasConfirmBlur = function () {
        if ($scope.pasConf == $scope.pas) {
            $scope.isConfirm = "Confirm!"
        }
        else {
            $scope.isConfirm = "Not confirm!"
        }
    }
    $scope.pasConfirmFocus = function () {
        $scope.isConfirm = ""
    }

});