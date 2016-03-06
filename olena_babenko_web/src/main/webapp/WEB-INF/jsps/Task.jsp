<%--
  Created by IntelliJ IDEA.
  User: lenchi
  Date: 28.02.16
  Time: 12:33

ЗАДАНИЕ
пользователь вводит своё имя и нажимает на кнопку
(обращение к серверу и сервер возвращает случайное число от 0 till 10)
Вывести имя столько раз, какое число вернул сервер
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="test">
<head>
    <title>Task</title>
    <script src="js/angular.js"></script>
    <script src="js/taska.js"></script>
</head>
<body>
<div ng-controller="taskCtrl">
    Your name: <input ng-model="name">
    <button ng-click="update()">write</button>
    <p>Name: {{name}}</p>
    <p>Number: {{number}}</p>
    <p>Vector has length: {{vector.length}}</p>

    <ul>
        <li ng-repeat="element in vector">{{element}}</li>
    </ul>
</div>
</body>
</html>

