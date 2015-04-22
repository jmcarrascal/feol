<%@ taglib uri="/WEB-INF/tlds/extremecomponents.tld" prefix="ec" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="main">

	<div class="space"></div>
	<div class="panel_100 tab">
    	
		<div class="space"></div>
    	
    	<fieldset class="defaultFieldset">
    	<legend>Lista de Patentes</legend>
    	
					<ec:table 
						tableId="notReg"
				    	items="listPatente"
						var = "patente"
						locale="es_ES"
						action="preparedListPatente"
						imagePath="images/table/*.gif"
						width="100%"
						rowsDisplayed="100" >
						<ec:row>
								<ec:column width="40px" title=" " filterable="false" sortable="false"
								alias="read">
										<a href="#"> <img src="images/general/remove.png" 
										alt=" Eliminar Patente " title=" Eliminar Patente"
										onclick="deletePatente('${patente.idPatente}')" border="0"></img>
										</a>
								</ec:column>
								<ec:column width="40px" property="idPatente" title="Id" filterable="false" />
								<ec:column width="auto" property="descrip" title="Descripción" filterable="true" />
								<ec:column width="200px" property="valor" title="Valor" filterable="true" />
								
						</ec:row>
					</ec:table>
    	</fieldset>

		

	</div>
	
</div>

<s:form action="deletePatente" id="deletePatenteForm">
	<s:hidden key="patente.idPatente" id="idPatenteF"/>
</s:form>


 
<script type="text/javascript">

function deletePatente(idPatente){
	document.getElementById("idPatenteF").value=idPatente;
	document.getElementById("deletePatenteForm").submit();
}

</script>