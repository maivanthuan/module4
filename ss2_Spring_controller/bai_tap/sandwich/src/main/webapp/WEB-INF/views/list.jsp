<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>list Condiments</h1>
<form>
  <h3>Codiment you choice:
      <c:forEach items="${condiment}" var="c">
          ${c}
      </c:forEach>
  </h3>
</form>
</body>
</html>
