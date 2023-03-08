<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/diction">
    <h1>Từ Điển Tiếng Anh</h1>
    <label>Nhập từ muốn tra cứu</label>
    <input type="text" name="input" placeholder="work...">
    <br><br>
    <input type="submit" value="search">
</form>
<h3>Tiếng Việt: <span>${result}</span></h3>
</body>
</html>