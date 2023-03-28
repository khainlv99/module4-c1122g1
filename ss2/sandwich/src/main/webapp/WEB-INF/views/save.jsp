<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 28/03/2023
  Time: 11:28 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<table class="table">
    <tr>
        <th>Tên Sandwich</th>
    </tr>
    <c:forEach var="sandwich" items="${result}">
        <tr>
            <td>${sandwich}</td>
        </tr>
    </c:forEach>
    <p style="color: red;font-size: 30px" >${msg}</p>
</table>
</body>
</html>
