<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/tiendadoi">
<h1>Đổi tiền</h1>
<br><br>
<label>USD</label>
<input type="text" name="usd" placeholder="0">
<br><br>
<input type="submit" value="submit">
</form>
<h3>Result: <span>${change}</span></h3>
</body>
</html>