<%@ taglib uri="/WEB-INF/tlds/extremecomponents.tld" prefix="ec" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="main">

	<div class="space"></div>
	<div class="panel_100 tab">
    	
		<div class="space"></div>
    	
    	<fieldset class="defaultFieldset">
    	<legend><h1>Lista de Empresas</h1></legend>
		<div class="space"></div>	    	
    	<a href="preparedNewEmpresa"><b>Nueva Empresa</b></a>
					<ec:table 
						tableId="notReg"
				    	items="listEmpresa"
						var = "empresa"
						locale="es_ES"
						action="preparedListEmpresa"
						imagePath="images/table/*.gif"
						width="100%"
						rowsDisplayed="100" >
						<ec:row>
								<ec:column width="40px" property="idEmpresa" title="Id" filterable="false" />
								<ec:column width="200px" property="cuit" title="Cuit" filterable="true" />								
								<ec:column width="200px" property="ruta_provisorio_cot" title="Ruta Provisorio" filterable="true" />
								<ec:column width="200px" property="ruta_definitivo_cot" title="Ruta Definitivo" filterable="true" />
								<ec:column width="200px" property="ruta_entrada_cot" title="Ruta Entrada" filterable="true" />
								<ec:column width="200px" property="ruta_salida_cot" title="Ruta Salida" filterable="true" />
								<ec:column width="200px" property="user_cot" title="Usuario COT" filterable="true" />

								<ec:column width="40px" title="Edit" filterable="false" sortable="false" alias = "checkbox">
									<a href="#">
										<img src="images/general/edit.png" alt="Editar Empresa" border="0" onclick="editEmpresa('${empresa.idEmpresa}')"></img>
									</a>								
									<a href="#">
										<img src="images/general/remove.png" alt="Eliminar Empresa" border="0" onclick="removeEmpresa('${empresa.idEmpresa}')"></img>
									</a>
								</ec:column>
								
						</ec:row>
					</ec:table>
    	</fieldset>

		

	</div>
	
</div>

<s:form action="preparedEditEmpresa" id="editEmpresaForm">
	<s:hidden key="empresa.idEmpresa" id="idEmpresa"/>
</s:form>

<s:form action="removeEmpresa" id="removeEmpresaForm">
	<s:hidden key="empresa.idEmpresa" id="idEmpresaRemove"/>
</s:form>
 
<script type="text/javascript">

function editEmpresa(idEmpresa){
	document.getElementById("idEmpresa").value=idEmpresa;
	document.getElementById("editEmpresaForm").submit();
}
 
function removeEmpresa(idEmpresa){
	document.getElementById("idEmpresaRemove").value=idEmpresa;
	document.getElementById("removeEmpresaForm").submit();
}

function editEmpresa(idEmpresa){
	document.getElementById("idEmpresa").value=idEmpresa;
	document.getElementById("editEmpresaForm").submit();
}

</script>