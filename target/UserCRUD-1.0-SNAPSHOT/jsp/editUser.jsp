<%--
  Created by IntelliJ IDEA.
  User: AORUS
  Date: 20.06.2021
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<p>edytuj usera</p>
<form action="/user/edit" method="post">

    Nazwa Użytkownika: <input name="userName" type="text" placeholder="${user.userName}"><br>
    Email: <input name="userEmail" type="email" placeholder="${user.email}"><br>

    <button type="submit">Zapisz</button>
</form>
</body>
</html>
