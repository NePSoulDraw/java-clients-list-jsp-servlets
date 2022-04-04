<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <a href="index.jsp" class="btn btn-secondary btn-block">&larr; Volver al inicio</a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-success btn-block">&check; Guardar cliente</button>
            </div>
            <div class="col-md-3">
                <a href="${pageContext.request.contextPath}/ServletController?action=delete&clientId=${client.clientId}" 
                   class="btn btn-danger btn-block">&Cross; Eliminar cliente
                </a>
            </div>
        </div>
    </div>
</section>