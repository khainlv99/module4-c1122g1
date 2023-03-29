<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 29/03/2023
  Time: 11:01 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
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
<form:form action="/index/create" method="post" modelAttribute="settings">
  <h1>Settings</h1>
  <div class="row">
    <div class="col-2"><label for="">Languages: </label></div>
    <div class="col-10">
      <p>${settings.languages}</p>
    </div>
  </div>
  <div class="row">
    <div class="col-2"  style="margin-top: 20px">
      <label for="">Page Size: </label>
    </div>
    <div class="col-10" style="margin-top: 20px">
      <p>${settings.pageSize}</p>
    </div>
  </div>
  <div class="row">
    <div class="col-2"  style="margin-top: 20px">
      <label for="">Spams filter: </label>
    </div>
    <div class="col-10" style="margin-top: 20px">
      <p>${settings.filter}</p>
    </div>
  </div>
  <div class="row">
    <div class="col-2"  style="margin-top: 20px">
      <label for="">Signature: </label>
    </div>
    <div class="col-10" style="margin-top: 20px">
      <p>${settings.signature}</p>
    </div>
  </div>
  <div class="row">
    <div class="col-2"  style="margin-top: 20px">
    </div>
    <div class="col-10" style="margin-top: 20px">
      <input type="submit" value="Update">
      <input type="submit" value="Cancel" onclick="location.href = '/index'">
    </div>
  </div>
</form:form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
