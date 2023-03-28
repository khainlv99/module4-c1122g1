<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 27/03/2023
  Time: 10:28 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>choose seasoning</title>
</head>
<body>
<form action="/sandwich/save" method="post">
<h1>Sandwich Condiments</h1>
<input type="checkbox" name="condiment" value="lettuce">
<label for="">Lettuce</label>
<input type="checkbox" name="condiment" value="tomato">
<label for="">Tomato</label>
<input type="checkbox" name="condiment" value="mustard">
<label for="">Mustard</label>
<input type="checkbox" name="condiment" value="sprouts">
<label for="">Sprouts</label>
<hr>
<input type="submit">
</form>
</body>
</html>
