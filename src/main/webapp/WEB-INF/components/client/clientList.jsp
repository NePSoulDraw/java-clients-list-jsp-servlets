<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="es_ES"/>

<section id="clients">
    <div class="container">
        <div class="row">
            
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de clientes</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Saldo</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="client" items="${clients}">
                                <tr class="align-middle">
                                    <td>${client.clientId}</td>
                                    <td>${client.name} ${client.surname}</td>
                                    <td><fmt:formatNumber value="${client.balance}" type="currency" currencySymbol="&euro;"/></td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletController?action=edit&clientId=${client.clientId}"
                                           class="btn btn-secondary">
                                            Editar
                                        </a>
                                    </td>
                                </tr>
                                
                                
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            
            <div class="col-md-3">
                <div class="card text-center bg-danger text-light mb-3">
                    <div class="card-body">
                        <h3>Saldo total</h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value="${totalBalance}" type="currency" currencySymbol="&euro;" />
                        </h4>
                    </div>
                </div>
                        
                <div class="card text-center bg-success text-light mb-3">
                    <div class="card-body">
                        <h3>
                            Total clientes
                        </h3>
                        <h4 class="display-4">
                            ${totalClients}
                        </h4>
                    </div>
                </div>
            </div>
            
        </div>
    </div>
</section>