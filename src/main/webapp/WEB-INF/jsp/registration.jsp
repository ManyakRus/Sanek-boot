<!DOCTYPE html>
<html lang="ru" xmlns="http://www.w3.org/1999/xhtml"
    <head>
        <title>Registration Form</title>
    </head>
    <body>
        <form th:action="#" method="get">

            User name: <input type="text" name="name" value="${user.name}">
                Password: <input type="text" name="password" value="${user.password}">
                <input type="submit" value="send">
        </form>	

    </body>
</html>