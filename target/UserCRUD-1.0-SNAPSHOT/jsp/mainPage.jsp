<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Baza użytkowników</title>
</head>
<body>

<table style="width:100%" border="1">
    <tr>
        <th>ID</th>
        <th>username</th>
        <th>email</th>
        <th>actions</th>
    </tr>
    <c:forEach items="${users}" var="user" varStatus="status">
    <tr>
        <td>${user.id}</td>
        <td>${user.userName}</td>
        <td>${user.email}</td>
        <td><u><a href="<c:url value="/user/edit?username=${user.userName}&email=${user.email}&id=${user.id}"/>">Edytuj</a></u>
            <u><a href="<c:url value="/user/show?username=${user.userName}&email=${user.email}&id=${user.id}"/>">Pokaż</a></u>
            <u><a href=<c:url value="/deleteUser?username=${user.userName}&email=${user.email}&id=${user.id}"/>>Usuń</a></u>   </td>
        </c:forEach>
    </tr>
</table>
<a href="<c:url value="/user/add"/>">Dodaj użytkownika</a>

</body>
</html>