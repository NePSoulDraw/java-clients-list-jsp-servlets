<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catálogo de clientes</title>
    </head>
    <body>
        <h1>Catálogo de clientes</h1>
        <ul>
            <c:forEach var="client" items="${clients}">
                <li>
                    ${client.clientId} - ${client.name} ${client.surname} - ${client.balance}$
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
