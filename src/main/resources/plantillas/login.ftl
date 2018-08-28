
<link href="/css/login_regis.css" rel="stylesheet">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script>
    $(function() {

        $('#login-form-link').click(function(e) {
            $("#login-form").delay(100).fadeIn(100);
            $("#register-form").fadeOut(100);
            $('#register-form-link').removeClass('active');
            $(this).addClass('active');
            e.preventDefault();
        });
        $('#register-form-link').click(function(e) {
            $("#register-form").delay(100).fadeIn(100);
            $("#login-form").fadeOut(100);
            $('#login-form-link').removeClass('active');
            $(this).addClass('active');
            e.preventDefault();
        });

    });
</script>
   <div class="container">
       <div class="row">
           <div class="col-md-6 col-md-offset-3">
               <div class="panel panel-login">
                   <div class="panel-heading">
                       <div class="row">
                           <div class="col-xs-6">
                               <a href="#" class="active" id="login-form-link">Login</a>
                           </div>
                           <div class="col-xs-6">
                               <a href="#" id="register-form-link">Register</a>
                           </div>

                       </div>
                       <hr>
                   </div>
                   <div class="panel-body">
                       <div class="row">
                           <div class="col-lg-12">
                               <form class="form-horizontal" id="login-form" role="form" method="post" action="/login" style="display: block;">
                                   <h2 class="text-center">Login</h2>

                                   <div class="form-group">
                                       <label for="email" class="col-sm-3 control-label">Usuario</label>
                                       <div class="col-sm-9">
                                           <input type="text" id="email" placeholder="" class="form-control" name="usuario">
                                       </div>
                                   </div>
                                   <div class="form-group">
                                       <label for="password" class="col-sm-3 control-label">Contraseña</label>
                                       <div class="col-sm-9">
                                           <input type="password" id="password" placeholder="" class="form-control" name="contrasena">
                                       </div>
                                   </div>

                                   <div class="form-group">
                                       <div class="col-sm-9 col-sm-offset-3">
                                           <button type="submit" class="btn btn-primary">Ingresar</button>
                                       </div>
                                   </div>
                               </form>
                               <form id="register-form" method="post" action="/registrar" class="content" name="registrationForm" style="display: none;">
                                   <input type="hidden" name="iniciarsesion" value="false">
                                   <div class="row">
                                       <div class="col col-12 col-xl-6 col-lg-6 col-md-6 col-sm-12">
                                           <div class="form-group label-floating is-empty">
                                               <label class="control-label">Nombre</label>
                                               <input class="form-control" placeholder="" name="nombre" type="text" required>
                                           </div>
                                       </div>
                                       <div class="col col-12 col-xl-6 col-lg-6 col-md-6 col-sm-12">
                                           <div class="form-group label-floating is-empty">
                                               <label class="control-label">Apellido</label>
                                               <input class="form-control" placeholder="" name="apellido" type="text" required>
                                           </div>
                                       </div>

                                       <div class="col col-12 col-xl-6 col-lg-6 col-md-6 col-sm-12">
                                           <label for="fecha-nacimiento">Fecha Nacimiento</label>
                                           <div class="input-group mb-2">
                                               <div class="input-group-prepend">
                                                   <div class="input-group-text">
                                                       <i class="fas fa-calendar-alt"></i>
                                                   </div>
                                               </div>
                                               <input type="date" class="form-control" name="fecha-nacimiento" required>
                                           </div>
                                       </div>

                                       <div class="col col-12 col-xl-6 col-lg-6 col-md-6 col-sm-12">
                                           <label for="sexo">Sexo</label>
                                           <br>
                                           <div class="form-check form-check-inline">
                                               <input class="form-check-input" type="radio" name="sexo" value="M" required>
                                               <label class="form-check-label" for="sexo">Masculino</label>
                                           </div>
                                           <div class="form-check form-check-inline">
                                               <input class="form-check-input" type="radio" name="sexo" value="F" required>
                                               <label class="form-check-label" for="sexo">Femenino</label>
                                           </div>
                                       </div>

                                       <div class="col col-12 col-xl-6 col-lg-6 col-md-6 col-sm-12">
                                           <div class="form-group label-floating is-empty">
                                               <label class="control-label">Nacionalidad</label>
                                               <input class="form-control" placeholder="" name="nacionalidad" type="text" required>
                                           </div>
                                       </div>

                                       <div class="col col-12 col-xl-12 col-lg-12 col-md-12 col-sm-12">
                                           <div class="form-group label-floating is-empty">
                                               <label class="control-label">Usuario</label>
                                               <input class="form-control" placeholder="" name="usuario" type="text" required>
                                           </div>
                                           <div class="form-group label-floating is-empty">
                                               <label class="control-label">Contraseña</label>
                                               <input class="form-control" placeholder="" name="contrasena" type="password" required>
                                           </div>

                                           <button type="submit" class="btn btn-purple btn-lg full-width">Registrarme!</button>
                                       </div>
                                   </div>
                               </form>

                           </div>
                       </div>
                   </div>
               </div>
           </div>
       </div>
   </div>

