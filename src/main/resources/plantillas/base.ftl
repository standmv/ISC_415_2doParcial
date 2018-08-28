<#macro pagina logueado=false usuario="" persona="">
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home</title>

    <!-- Bootstrap 4.1 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
            integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
            crossorigin="anonymous"></script>


    <!-- Estilos propios
    <link rel="stylesheet" href="/css/estilo.css">
    <link rel="stylesheet" href="/css/facebook.css">-->
</head>

<body>

<div class="container-fluid">
    <div class="row">
        <div class="col">
            <div class="row">
                <div class="col-12 p-0">
                    <nav class="navbar navbar-expand-lg navbar-dark bg-info">

                        <button class="navbar-toggler" type="button" data-toggle="collapse"
                                data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <a href="#" class="navbar-brand logo">POMPONEO SOCIAL</a>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <#if logueado>
                            <a class="text-white" href="/perfil/${usuario.usuario}"> ${usuario.usuario}</a>
                            &nbsp;&nbsp;
                            <a class="text-white" href="/amigos">Amigos</a>
                            &nbsp;&nbsp;
                            <a data-toggle="modal" class="text-white"
                                    data-target="#notificaciones" >
                                Notificaciones
                                <span class="badge badge-secondary">${usuario.notificaciones?size}</span>
                            </a>
                            &nbsp;&nbsp;
                            <a data-toggle="modal" class="text-white "
                                    data-target="#exampleModal" >
                                 Publicar
                            </a>
                            &nbsp;&nbsp;
                            <a data-toggle="modal" class="text-white "
                                    data-target="#modal-album" >
                                Subir Album
                            </a>
                            &nbsp;&nbsp;
                            <a href="/salir" class="text-white " >
                                 Cerrar Sesion
                            </a>

                        <#else>
                            <ul class="navbar-nav mr-auto">
                            </ul>
                            <form action="/login" method="POST" class="form-inline">
                                <div class="input-group mr-2">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">
                                            <i class="fas fa-user"></i>
                                        </div>
                                    </div>
                                    <input type="text" class="form-control" name="usuario" placeholder="Usuario">
                                </div>
                                <div class="input-group mr-2">
                                    <div class="input-group-prepend">
                                        <div class="input-group-text">
                                            <i class="fas fa-lock"></i>
                                        </div>
                                    </div>
                                    <input type="password" class="form-control" name="contrasena"
                                           placeholder="Contraseña">
                                </div>

                            </form>
                        </#if>
                        </div>
                    </nav>
                </div>
            </div>
            <#nested>
        </div>
    </div>
</div>
</body>

</html>
</#macro>