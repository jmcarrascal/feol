<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ taglib uri="/WEB-INF/tlds/extremecomponents.tld" prefix="ec" %>
 
<link href="<%=request.getContextPath()%>/css/hints.css" rel="stylesheet" type="text/css" />


<div class="main">
	
	
	<div class="space"></div>
	
		<div class="panel_100 tab">
	    	<div class="space"></div>
           	<fieldset class="defaultFieldset">
    			<legend><b>Facturas</b></legend>
    			<div class="space"></div>
 
			<s:form action="downloadFacturaExpo" id="listFacturaForm" theme="simple" cssClass="inline" method="post" >
						
 				<table>
 				
 					<tr>
	 					<td>
	 						<label >Si no se ingresa el nro de Comprobante se obtiene el ultimo informado</label>
							<div class="space"></div>
			
	 					</td>
						<div class="separator"></div>
 					</tr>
				</table>
				<table>
 				<tr>
					<td>
	 					<label >Punto de Venta:</label>	 				
	 					<input type="text" name="prefijo" maxlength="4" size="4" >					
		 			</td>
		 			<td>
	 					<label >Tipo de Comprobante:</label>	 				
						<input type="text" name="tipoComprobante" maxlength="2" size = "2" >
					</td>					
	 				<td>
	 					<label>Numero de Comprobante:</label>	 				
						<input type="text" name="nroComprobante" maxlength="8" size = "8" >
					</td>
					</tr>
					<tr>
					
				</table>
				<center>
				<div style="display: none" id="idAutoCompleteLoad"><img alt=""
					src="images/general/loading1.gif"></div>
						<div class="space"></div>
				<div id="consultar" style="display:inline;">
						<img src="images/general/icon_aceptar_v1.png" alt="Consultar" border="0" onclick="submitForm('listFacturaForm');">						
				</div>
					
		</center>
			</s:form>
	
		
						
			
			<div class="space"></div>
		</fieldset>

		<div class="space"></div>
	</div>
</div>

<script language="javascript">
function submitForm(formId) { 
	document.getElementById("idAutoCompleteLoad").style.display = "inline";
	document.getElementById(formId).submit();
}
</script> 

