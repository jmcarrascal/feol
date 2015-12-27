<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="main">
	
	<div class="panel_50 tab">
	    	
		<div class="space"></div>

		<fieldset class="defaultFieldset"  >
			<legend><h1>Nueva Empresa</h1></legend>
			<div class="space"></div>

				<s:form action="newEmpresa" id="addEmpresaForm" method="post" >
						
					<table>
						<tr>
							<td><s:textfield id="nombre" name="empresa.nombre" size="50" maxlength="50" label="Nombre"/></td>
						</tr>
						<tr>
							<td><s:textfield id="cuit" name="empresa.cuit" size="50" maxlength="200" cssErrorClass="error" label="Cuit" /></td>
						</tr>
						<tr>
							<td><s:textfield label="Ruta Provisorio" id="ruta_provisorio_cot" name="empresa.ruta_provisorio_cot" size="50" maxlength="200" /></td>
						</tr>
						<tr>
							<td><s:textfield label="Ruta Definitivo" id="ruta_definitivo_cot" name="empresa.ruta_definitivo_cot" size="50" maxlength="200" /></td>
						</tr>
						<tr>
							<td><s:textfield label="Ruta Entrada" id="ruta_entrada_cot" name="empresa.ruta_entrada_cot" size="50" maxlength="200" /></td>
						</tr>
						<tr>
							<td><s:textfield label="Ruta Salida" id="ruta_salida_cot" name="empresa.ruta_salida_cot" size="50" maxlength="200" /></td>
						</tr>
						<tr>
							<td><s:textfield label="Usuario COT" id="user_cot" name="empresa.user_cot" size="50" maxlength="200" /></td>
						</tr>
						<tr>
							<td><s:textfield label="Password COT" id="pass_cot" name="empresa.pass_cot" size="50" maxlength="200" /></td>
						</tr>

					</table>
								
					
				</s:form>
				<div>
					<center>
						<div id="guardar" style="display:inline;">
								<img src="images/general/icon_guardar.png" alt="Guardar" border="0">									
						</div>
					</center>
				</div>

			
		</fieldset>
	 			
	 	<div class="space"></div>
	 	</div>
</div>

<script type="text/javascript">
$(document).ready(function(){
	$("#guardar").click(function (){
		document.getElementById('addEmpresaForm').submit();
	});
	
});

</script>