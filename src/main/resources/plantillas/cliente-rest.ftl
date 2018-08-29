<#import "/plantillas/base.ftl" as base>
<@base.pagina>
    <div class="col p-0">
        <div class="row">
            <div class="col-12 p-0">
                <div class="card col-6 rounded-0 bg-light p-0 mx-auto mt-2">
                    <div class="card-header">
                        <h5 class="card-title">
                            Listar posts REST
                        </h5>
                    </div>
                    <div class="card-body">
                        <form action="/rest/listarPost" method="POST">
                            <div class="form-group">
                                <label for="usuario">Usuario</label>
                                <input class="form-control rounded-0" type="text" name="usuario" placeholder="usuario" required>
                            </div>
                            <button type="submit" class="btn btn-outline-secondary my-2 my-sm-0">Listar posts del usuario</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@base.pagina>