<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="main">
	
	<div class="panel_100 tab">
	    	
		<div class="space"></div>

		<fieldset class="defaultFieldset" >
			<legend>Nueva Patente</legend>

				<s:form action="newPatente" id="newPatenteForm" theme="simple" cssClass="inline" method="post" >
						
					<table>
						<tr>
		 					<td><label for="id">Descripción:</label></td>	 				
							<td><s:textfield id="descrip" name="patente.descrip" size="50" maxlength="50" cssErrorClass="error" cssClass="ui-widget-content ui-corner-all"/></td>
						<tr>
						<tr>
		 					<td><label for="id">* Valor:</label></td>	 				
							<td><s:textfield id="valor" name="patente.valor" size="50" maxlength="200" cssErrorClass="error" cssClass="ui-widget-content ui-corner-all"/></td>
						<tr>

					</table>
								
					
	
					
				</s:form>
					<center>
						<div id="guardar" style="display:inline;">
								<img src="images/general/icon_guardar.png" alt="Guardar" border="0">									
						</div>
					</center>
			

			
		</fieldset>
	 			
	 	<div class="space"></div>
	 	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	$("#guardar").click(function (){
		document.getElementById('newPatenteForm').submit();
	});
	
});

</script>