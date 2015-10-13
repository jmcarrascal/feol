<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ taglib uri="/WEB-INF/tlds/extremecomponents.tld" prefix="ec" %>
 
<link href="<%=request.getContextPath()%>/css/hints.css" rel="stylesheet" type="text/css" />


<div class="main">
			<div align="center">
				<a href="preparedListCots">
	          		<img src="images/general/coinse_refrezcar.png" alt="Actualizar Pantalla" title="Actualizar Pantalla" border="0" ></img>
	          	</a>
	          	</div>
	<br>	
		<div class="panel_100 tab">
	    	<div class="space"></div>
           	<fieldset class="defaultFieldset">
    			<legend><b>Comprobantes (Arba) Gestionados</b></legend>
    			<div class="space"></div>
				<s:actionerror/>	
					<ec:table					
						tableId="notReg" 
				    	items="listCot"
						var = "cot"
						locale="es_ES"
						action="preparedListCots"
						imagePath="images/table/*.gif"
						width="100%"
				    	retrieveRowsCallback="limit"
   						filterRowsCallback="limit"
   						sortRowsCallback="limit"
   						view="limit"						
						rowsDisplayed="100" >
						<ec:row>
								<ec:column width="40px" property="idCot" title="Id"/>
								<ec:column width="40px" property="secuencia" title="N. Secuencia"/>
								<ec:column width="40px" property="planta" title="Planta"/>
								<ec:column width="100px" property="nombreArchivo" title="Archivo Definitivo"/>
								<ec:column width="auto" property="respuesta" title="Respuesta"/>
	          					<ec:column width="20px" title="TXT" filterable="false" sortable="false" alias="read2">
	          						<a href="#">
		          						<img src="images/general/down.png" alt="Descargar TXT enviado" title=" Descargar TXT enviado" onclick="downloadFile('${cot.idCot}')" border="0" id="read${cot.idCot}"></img>
	          						</a>
	          					</ec:column>
								
						</ec:row>
					</ec:table>
				<div class="space"></div> 
			</fieldset>		
		</div>	
</div>		

<s:form action="downloadFileCot" id="downloadFileForm">	
	<input type="hidden" name="factura.idFactura" id="idFacturaT">
</s:form>


<script type="text/javascript">

function switchProcesoAfip(idFactura){	
	document.getElementById("idFactura").value=idFactura;
	document.getElementById("switchProcesoAfipForm").submit();
}

function downloadRequest(idFactura){	
	document.getElementById("idFacturaR").value=idFactura;
	document.getElementById("downloadRequestForm").submit();
}

function downloadFile(idFactura){	
	document.getElementById("idFacturaT").value=idFactura;
	document.getElementById("downloadFileForm").submit();
}

function actualizar(){
	
}

</script>