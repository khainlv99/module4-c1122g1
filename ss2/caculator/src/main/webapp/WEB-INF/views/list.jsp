<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 28/03/2023
  Time: 2:59 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<form action="/index" method="post">
<div class="row">
    <div class="col-2"><input type="text" name="numberOne"></div>
    <div class="col-2" style="margin-left: 20px"><input type="text" name="numberTwo"></div>
    <div class="col-2"></div>
    <div class="col-2"></div>
    <div class="col-2"></div>
    <div class="col-2"></div>
</div>
<div class="row" style="margin-top: 30px">
    <div class="col-3"><input type="submit" value="Addition(+)" name="calculate"></div>
    <div class="col-3"><input type="submit" value="Subtraction(-)" name="calculate"></div>
    <div class="col-3"><input type="submit" value="Multiplication(X)" name="calculate"></div>
    <div class="col-3"><input type="submit" value="Division(/)" name="calculate"></div>
</div>
    <p>${msg}</p>
<p>${result}</p>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
