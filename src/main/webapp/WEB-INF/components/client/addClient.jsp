<div class="modal fade" id="addClientModal" tabindex="-1" aria-labelledby="addClientModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-dark text-white">
                <h5 class="modal-title" id="addClientModalLabel">Añadir cliente</h5>
                <button class="close" data-bs-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/ServletController?action=insert" 
                  method="POST" class="was-validated">
                
                <div class="modal-body">
                    <div class="form-group mb-2">
                        <label for="name">Nombre</label>
                        <input type="text" class="form-control" name="name" required />
                    </div>
                    
                    <div class="form-group mb-2">
                        <label for="surname">Apellido</label>
                        <input type="text" class="form-control" name="surname" required />
                    </div>
                    
                    <div class="form-group mb-2">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email" required />
                    </div>
                    
                    <div class="form-group mb-2">
                        <label for="phone">Teléfono</label>
                        <input type="number" class="form-control" name="phone" required />
                    </div>
                    
                    <div class="form-group mb-2">
                        <label for="balance">Sueldo</label>
                        <input type="number" class="form-control" name="balance" required />
                    </div>
                </div>
                
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
                
            </form>
        </div>
    </div>
</div>