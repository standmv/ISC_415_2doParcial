<!doctype html>
<html>
<head>
	<title>Fotos</title>
<meta charset="UTF-8">
      <link href="/css/bootstrap.css" rel="stylesheet">
	<link href="/css/fotos.css" rel="stylesheet">

    </head>
       <body>
       <!-- top nav -->
       <div class="navbar navbar-blue navbar-static-top">
           <div class="navbar-header">
               <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
                   <span class="sr-only">Toggle</span>
                   <span class="icon-bar"></span>
                   <span class="icon-bar"></span>
                   <span class="icon-bar"></span>
               </button>
               <a href="/home" class="navbar-brand logo">P</a>
           </div>
           <nav class="collapse navbar-collapse" role="navigation">
               <form class="navbar-form navbar-left">
                   <div class="input-group input-group-sm" style="max-width:360px;">
                       <input class="form-control" placeholder="Buscar" name="srch-term" id="srch-term" type="text">
                       <div class="input-group-btn">
                           <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                       </div>
                   </div>
               </form>
               <ul class="nav navbar-nav">
                   <li>
                       <a href="/home"><i class="glyphicon glyphicon-home"></i> Home</a>
                   </li>
                   <li>
                       <a href="#postModal" role="button" data-toggle="modal"><i class="glyphicon glyphicon-plus"></i> Publicar</a>
                   </li>

               </ul>

               <ul class="nav navbar-nav navbar-right">
                   <li class="dropdown">
                       <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i></a>
                       <ul class="dropdown-menu">
                           <li><a href="">Perfil</a></li>
                           <li><a href="/album">Fotos</a></li>
                           <li><a href="/informacion">Informacion</a></li>
                           <li><a href="">Salir</a></li>
                       </ul>
                   </li>
               </ul>
           </nav>
       </div>
       <!-- /top nav -->

    <section>
      <div class="container">
        <div class="row">
          <div class="col-12 text-center">
            <h2>Albunes</h2>

          </div>
        </div>
        <div class="row">
          <div class="col-md-6 col-12 text-center">
            <img class="img-fluid" src="/images/400x400.gif"  alt="">
            <h4>Descripcion</h4>
<a href="#" class="btn btn-primary btn-lg disabled" tabindex="-1" role="button" aria-disabled="true"><i><span class="glyphicon glyphicon-plus"></span></i></a>
<a href="#" class="btn btn-primary btn-lg disabled" tabindex="-1" role="button" aria-disabled="true"><i><span class="glyphicon glyphicon-eye-open"></span></i></a>
          </div>
          <div class="col-md-6 col-12 text-center mt-md-0 mt-2">
            <img class="img-fluid" src="/images/400x400.gif" alt="">
              <h4>Descripcion</h4>
			  <a href="#" class="btn btn-primary btn-lg disabled" tabindex="-1" role="button" aria-disabled="true"><i><span class="glyphicon glyphicon-plus"></span></i></a>
<a href="#" class="btn btn-primary btn-lg disabled" tabindex="-1" role="button" aria-disabled="true"><i><span class="glyphicon glyphicon-eye-open"></span></i></a>
          </div>
        </div>

        <hr>

      </div>
    </section>
		<!--post modal-->
		<div id="postModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
		  <div class="modal-dialog">
		  <div class="modal-content">
			  <div class="modal-header">
				  <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>

			  </div>
			  <div class="modal-body">
				  <form class="form center-block">
					<div class="form-group">
					  <textarea class="form-control input-lg" autofocus="" placeholder=""></textarea>
					</div>
				  </form>
			  </div>
              <div class="modal-footer">
                  <div>
                      <form method='post' enctype='multipart/form-data'>
                          <button class="btn btn-primary btn-sm" data-dismiss="modal" aria-hidden="true">Publicar</button>
                          <ul class="pull-left list-inline"><li><a href="#"><input type='file' name='post'><i class="glyphicon glyphicon-upload"></i></a></li><li><a href=""><i class="glyphicon glyphicon-camera"></i></a></li><li><a href=""><i class="glyphicon glyphicon-map-marker"></i></a></li></ul>
                      </form></div>
              </div>

          </div>
          </div>
        </div>

        <script type="text/javascript" src="/js/jquery.js"></script>
        <script type="text/javascript" src="/js/bootstrap.js"></script>
        <script type="text/javascript">
        $(document).ready(function() {
			$('[data-toggle=offcanvas]').click(function() {
				$(this).toggleClass('visible-xs text-center');
				$(this).find('i').toggleClass('glyphicon-chevron-right glyphicon-chevron-left');
				$('.row-offcanvas').toggleClass('active');
				$('#lg-menu').toggleClass('hidden-xs').toggleClass('visible-xs');
				$('#xs-menu').toggleClass('visible-xs').toggleClass('hidden-xs');
				$('#btnShow').toggle();
			});
        });
        </script>
         </body>
</html>
