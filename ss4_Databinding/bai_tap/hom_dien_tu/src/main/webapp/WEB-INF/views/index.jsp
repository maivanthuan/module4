<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Setting:</h1>
<form:form action="" method="post" modelAttribute="thudientu">
    <table>
        <tr>
            <th>Language: </th>
            <td>
                <form:select path="language">
                    <form:options items="${languages}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <th> Pages size: </th>
            <td>
                <form:select path="size">
                    <form:options items="${size}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Spam Filter</th>
            <td>
                <form:select path="filter">
                    <form:option value="true">Enable</form:option>
                    <form:option value="false">Disable</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <th>Signature</th>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <th></th>
            <td>
                <input type="submit" role="button" class="btn btn-outline-primary" value="Update">
                <input type="reset" role="button" class="btn btn-outline-secondary" value="Cancel">
            </td>
        </tr>
    </table>
</form:form>
<c:if test="${message!=null}">
    <div style="color:red;">
        <c:out value="${message}"/>
    </div>
</c:if>
</body>
</html>