<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ taglib uri="/WEB-INF/tlds/extremecomponents.tld" prefix="ec" %>
 
<link href="<%=request.getContextPath()%>/css/hints.css" rel="stylesheet" type="text/css" />


<div class="main">
			<div align="center">
				<a href="preparedListFacturas">
	          		<img src="images/general/coinse_refrezcar.png" alt="Actualizar Pantalla" title="Actualizar Pantalla" border="0" ></img>
	          	</a>
	          	</div>
				<div align="right">
					<a href="images/tablasAfip.xls">Descargar tablas de Afip</a>
				</div>
	<br>	
		<div class="panel_100 tab">
	    	<div class="space"></div>
           	<fieldset class="defaultFieldset">
    			<legend><b>Comprobantes Gestionados</b></legend>
    			<div class="space"></div>
				<s:actionerror/>	
					<ec:table					
						tableId="notReg" 
				    	items="listFactura"
						var = "factura"
						locale="es_ES"
						action="preparedListFacturas"
						imagePath="images/table/*.gif"
						width="100%"
				    	retrieveRowsCallback="limit"
   						filterRowsCallback="limit"
   						sortRowsCallback="limit"
   						view="limit"						
						rowsDisplayed="100" >
						<ec:row>
								<ec:column width="40px" property="metodoAfip" title="Metodo Afip" filterCell="droplist" />
								<ec:column width="40px" property="tipoFactura" title="Tipo Cbte." filterable = "false" sortable="false"/>
								<ec:column width="40px" property="punto_vta" title="Pto.Vta."/>
								<ec:column width="40px" property="cbt_desde" title="n° Cbte."/>
								<ec:column width="40px" property="nro_doc" title="Cuit Cliente"/>									
								<ec:column width="60px" property="imp_total" title="Importe"/>
								<ec:column width="60px" property="cae" title="CAE"/>
								<ec:column width="130px" property="fecha_creacion" title="Fa. y hs. gestión CAE" filterable="false"/>
								<ec:column width="100px" property="cae_vto" title="Fa.Vto.CAE" filterable="false"/>
								<ec:column width="200px" property="resultado" title="OBS Afip"  >
									<span style="white-space:normal;" >${factura.resultado}</span>
								</ec:column>
								<ec:column width="100px" property="nombreArchivo" title="Archivo Definitivo"/>
								
	          					<ec:column width="20px" title="XML" filterable="false" sortable="false" alias="read1">
	          						<a href="#">
	          							<img src="images/general/down_azul.png" alt="Descargar XML enviado" title=" Descargar XML enviado" onclick="downloadRequest('${factura.idFactura}')" border="0" id="read${factura.idFactura}"></img>
	          						</a>
	          					</ec:column>
	          					<ec:column width="20px" title="TXT" filterable="false" sortable="false" alias="read2">
	          						<a href="#">
		          						<img src="images/general/down.png" alt="Descargar TXT enviado" title=" Descargar TXT enviado" onclick="downloadFile('${factura.idFactura}')" border="0" id="read${factura.idFactura}"></img>
	          						</a>
	          					</ec:column>
	          					<ec:column width="40px" title=" " filterable="false" sortable="false" alias="read">
	          						<html:link href="#">
	          							<img src="images/general/procesoAfip${factura.tieneCae}.png" alt="Procesado" title=" Factura Procesada " onclick="switchProcesoAfip('${factura.idFactura}')" border="0" id="read${factura.idFactura}"></img>
										<script type="text/javascript">
											if ( ! ${factura.tieneCae} ) document.getElementById("read${factura.idFactura}").title=" Factura NO procesada por Afip ";
											if ( ${factura.tieneCae}) disableTableImageLink("read<bean:write name="fac" property="idFactura"/>","images/general/procesoAfip${factura.tieneCae}.png");
										</script>
									</html:link>
	          					</ec:column>
								
						</ec:row>
					</ec:table>
				<div class="space"></div> 
			</fieldset>		
		</div>	
</div>		

<s:form action="switchProcesoAfip" id="switchProcesoAfipForm">
	<s:hidden key="factura.idFactura" id="idFactura"/>
</s:form>

<s:form action="downloadRequest" id="downloadRequestForm">
	<s:hidden key="factura.idFactura" id="idFacturaR"/>
</s:form>

<s:form action="downloadFile" id="downloadFileForm">
	<s:hidden key="factura.idFactura" id="idFacturaT"/>
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