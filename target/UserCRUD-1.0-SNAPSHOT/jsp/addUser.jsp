<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddUser</title>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<p>dodaj usera</p>
<form action="/user/add" method="post">
    Nazwa: <input name="userName" type="text" placeholder="Nazwa użytkownika"><br>
    Email: <input name="userEmail" type="email" placeholder="Email użytkownika"><br>
    Hasło: <input name="userPassword" type="password" placeholder="Hasło użytkownika"><br>
    <button type="submit">Zapisz</button>
</form>
</body>
</html>
