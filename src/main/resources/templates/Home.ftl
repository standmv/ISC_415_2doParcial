<!DOCTYPE html>
<html lang="en">
	<head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <title>Home</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
          <link href="/css/bootstrap.css" rel="stylesheet">
        <!--[if lt IE 9]>
          <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <link href="/css/facebook.css" rel="stylesheet">

    </head>

    <body>

        <div class="wrapper">
			<div class="box">
				<div class="row row-offcanvas row-offcanvas-left">
					<!-- main right col -->
					<div class="column col-sm-12 col-xs-11" id="main">

						<!-- top nav -->
						<div class="navbar navbar-blue navbar-static-top">
							<div class="navbar-header">
							  <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							  </button>
							  <a href="#" class="navbar-brand logo">P</a>
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
								<a href="#"><i class="glyphicon glyphicon-home"></i> Home</a>
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
									<li><a href="">Fotos</a></li>
									<li><a href="">Informacion</a></li>
								  <li><a href="">Salir</a></li>
								</ul>
							  </li>
							</ul>
							</nav>
						</div>
						<!-- /top nav -->

						<div class="padding">
							<div class="full col-sm-9">

								<!-- content -->
								<div class="row">

								 <!-- main col left -->
								 <div class="col-sm-5">

								  </div>

								  <!-- main col right -->
								  <div class="col-sm-7">



									  <div class="well">
										   <form class="form-horizontal" role="form">
											<h4>Que estas pensando?</h4>
											 <div class="form-group" style="padding:14px;">
											  <textarea class="form-control" placeholder=""></textarea>
											</div>
											<button class="btn btn-primary pull-right" type="button">Publicar</button><ul class="list-inline"><li><a href=""><i class="glyphicon glyphicon-upload"></i></a></li><li><a href=""><i class="glyphicon glyphicon-map-marker"></i></a></li></ul>
										  </form>
									  </div>


									   <div class="panel panel-default">
										 <div class="panel-heading"><p>
											<img src="/img/uFp_tsTJboUY7kue5XAsGAs28.png" height="28px" width="28px">
										  </p></div>
										  <div class="panel-body">

											<div class="clearfix"></div>


											<p>Hola Mundo!</p>

											<hr>
											<form>
											<div class="input-group">
											  <div class="input-group-btn">
												  <button class="btn btn-default">Like</button><button class="btn btn-default">Comentar</button>
											  </div>
											  <input class="form-control" placeholder="Agregar un comentario" type="text">
											</div>
											</form>

										  </div>
									   </div>


								  </div>
							   </div><!--/row-->


							  <hr>

							  <hr>


							</div><!-- /col-9 -->
						</div><!-- /padding -->
					</div>
					<!-- /main -->

				</div>
			</div>
		</div>
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
				  <button class="btn btn-primary btn-sm" data-dismiss="modal" aria-hidden="true">Publicar</button>
					<ul class="pull-left list-inline"><li><a href=""><i class="glyphicon glyphicon-upload"></i></a></li><li><a href=""><i class="glyphicon glyphicon-camera"></i></a></li><li><a href=""><i class="glyphicon glyphicon-map-marker"></i></a></li></ul>
				  </div>
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
