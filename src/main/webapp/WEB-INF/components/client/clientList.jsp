<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<ul>
    <c:forEach var="client" items="${clients}">
        <li>
            ${client.clientId} - ${client.name} ${client.surname} - ${client.balance}$
        </li>
    </c:forEach>
</ul>