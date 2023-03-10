<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/calculation">
    <h1>Calculator</h1>
    <input type="text" name="num1">
    <input type="text" name="num2">
    <br>
    <input type="submit" name="operator" value="Addition(+)">
    <input type="submit" name="operator" value="Subtraction(-)">
    <input type="submit" name="operator" value="Multiplication(x)">
    <input type="submit" name="operator" value="Division(/)">
</form>
<h3>Result Division: ${result}</h3>
</body>
</html>