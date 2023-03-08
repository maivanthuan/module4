<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/condiment">
<h1>Sandwich Condiment</h1>
    <label>Lettuce</label>
<input type="checkbox" name="condiment" value="Lettuce">
    <label>Tomato</label>
<input type="checkbox" name="condiment" value="Tomato">
    <label>Mustard</label>
<input type="checkbox" name="condiment" value="Mustard">
    <label>Sprouts</label>
<input type="checkbox" name="condiment" value="Sprouts">
    <br>
    <input value="Submit" type="submit">
</form>
</body>
</html>