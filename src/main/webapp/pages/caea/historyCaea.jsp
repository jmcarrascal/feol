<%@ taglib uri="/WEB-INF/tlds/extremecomponents.tld" prefix="ec" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="main">

	<div class="space"></div>
	<div class="panel_100 tab">
    	
		<div class="space"></div>
    	
    	<fieldset class="defaultFieldset">
    	<legend>Historico de CAEAs Emitidos</legend>
    	
					<ec:table 
						tableId="notReg"
				    	items="listCaea"
						var = "caea"
						locale="es_ES"
						action="historyCaea"
						imagePath="images/table/*.gif"
						width="100%"
						rowsDisplayed="100" >
						<ec:row>
								<ec:column width="40px" property="idCaea" title="Id" filterable="false" />
								<ec:column width="200px" property="periodo" title="Periodo" filterable="true" />
								<ec:column width="200px" property="orden" title="Orden/Quincena" filterable="true" />
								<ec:column width="200px" property="fchVigDesde" title="Vigencia Desde" filterable="true" />
								<ec:column width="200px" property="fchVigHasta" title="Vigencia Hasta" filterable="true" />
								<ec:column width="200px" property="CAEA" title="CAEA" filterable="true" />
						</ec:row>
					</ec:table>
    	</fieldset>

		

	</div>
	
</div>

<s:form action="preparedEditParametrizacion" id="editParametrizacionForm">
	<s:hidden key="parametrizacion.idParametrizacion" id="idParametrizacionF"/>
</s:form>


 
<script type="text/javascript">

function editParametrizacion(idParametrizacion){
	document.getElementById("idParametrizacionF").value=idParametrizacion;
	document.getElementById("editParametrizacionForm").submit();
}

</script>