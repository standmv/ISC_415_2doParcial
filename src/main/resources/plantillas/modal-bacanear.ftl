<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content bg-info text-white">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Publicacion</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true" class="text-white">
              <i class="fas fa-times-circle"></i>
            </span>
                </button>
            </div>
            <div class="modal-body">
                <#if flashMessage??>
                    ${flashMessage}
                </#if>
                <form method="POST" action="/bacanear" id="form-bacanear" enctype='multipart/form-data'>
                    <div class="form-group with-icon label-floating is-empty">
                        <label class="control-label"> Que estas pensando?</label>
                        <textarea class="form-control" placeholder="" name="descripcion" required></textarea>
                        <input type='file' name="foto">
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-light" data-dismiss="modal">
                            Cancelar
                        </button>
                        <button class="btn btn-warning my-2 my-sm-0" type="submit">
                            Publicar
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
<script>
    $(document).ready(function () {
        $(".select2").select2();
    });
</script>