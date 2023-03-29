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
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<div class="container">
<form action="/sandwich/save" method="post">
    <div class="row">
        <h1>Sandwich Condiments</h1>
    </div>
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
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
