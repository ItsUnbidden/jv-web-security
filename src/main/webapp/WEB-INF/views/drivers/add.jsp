<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file='/WEB-INF/views/css/table_dark.css' %>
</style>
<html>
<head>
    <title>Add driver</title>
    <script>
        <%@include file='/WEB-INF/views/js/ConfirmPassword.js' %>
    </script>
</head>
<body>
<%@include file='/WEB-INF/views/header.jsp' %>
<h1 class="table_dark">Add driver:</h1>
<form onsubmit="return confirmPassword()" method="post" name="driver_form" id="driver" action="${pageContext.request.contextPath}/drivers/add">
<table border="1" class="table_dark">
    <tr>
        <th>Name</th>
        <th>License number</th>
        <th>Login</th>
        <th>Password</th>
        <th>Confirm Password</th>
        <th>Add</th>
    </tr>
    <tr>
        <td>
            <input type="text" name="name" form="driver" required>
        </td>
        <td>
            <input type="text" name="license_number" form="driver" required>
        </td>
        <td>
            <input type="text" name="login" form="driver" required>
        </td>
        <td>
            <input type="password" name="password" form="driver" required>
        </td>
        <td>
            <input type="password" name="confirm_password" form="driver" required>
        </td>
        <td>
            <input type="submit" name="add" form="driver">
        </td>
    </tr>
</table>
</form>
<p id="error_message" class="table_dark_error"></p>
</body>
</html>
