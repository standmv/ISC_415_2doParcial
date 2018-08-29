<#import "/plantillas/base.ftl" as base>
<@base.pagina>
    <div class="col p-0">
        <div class="row">
            <div class="col-12 p-0">
                <#list salidas as s>
                    <div class="row p-0 m-0">
                        <div class="card col-6 rounded-0 bg-light p-0 mx-auto mt-2">
                            <div class="card-header">
                                <small class="card-title">
                                    <em>Consultado con REST</em>
                                    &nbsp;|&nbsp;
                                    <i class="fas fa-user"></i> ${s[2]}
                                    &nbsp;|&nbsp;
                                    <i class="fas fa-calendar-alt"></i> ${s[3]}
                                    <#if s[4] != " ">
                                        &nbsp;|&nbsp;
                                        <i class="fas fa-tag"></i> ${s[4]}
                                    </#if>
                                    &nbsp;|&nbsp;
                                    <i class="fas fa-comments"></i> ${s[5]}
                                </small>
                            </div>
                            <div class="card-body">
                                <p class="card-text">
                                    <#if s[1] != " ">
                                        <#if s[6] == "servidor">
                                            <img src="http://localhost:4567/${s[1]}" class="imagen mb-2" width="635" alt="${s[0]}" title="${s[0]}">
                                        </#if>
                                        <#if s[6] == "cliente">
                                            <img src="/${s[1]}" class="imagen mb-2" width="635" alt="${s[0]}" title="${s[0]}">
                                        </#if>
                                        <br>
                                    </#if>
                                    ${s[0]}
                                </p>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        </div>
    </div>
</@base.pagina>