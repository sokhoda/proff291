<%--
  Created by IntelliJ IDEA.
  User: Roman
  Date: 23.01.2016
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task1</title>
</head>
<body>


<script>
var arr = new Array(1,2,3,4,5,6,7,8,9,10);

for (var i= 0; i< 3; i++){
var l = arr.length-1-i;
var tmp = arr[i];
arr[i] = arr[l];
arr[l] = tmp;
}
console.log(arr);
function fun(){
    alert('Fun function');
}
    fun();


</script>

</body>
</html>
