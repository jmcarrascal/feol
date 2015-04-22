<%@ taglib uri="/WEB-INF/tlds/extremecomponents.tld" prefix="ec" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="main">

	<div class="space"></div>
	<div class="panel_100 tab">
    	
		<div class="space"></div>
    	
    	<fieldset class="defaultFieldset">
    	<legend>Lista de Viajes sin autorizar por ARBA</legend>
    	
					<ec:table 
						tableId="notReg"
				    	items="listViajes"
						var = "viajes"
						locale="es_ES"
						action="preparedViajesSinCot"
						imagePath="images/table/*.gif"
						width="100%"
						rowsDisplayed="100" >
						<ec:row>
								<ec:column width="20px" title="Resp. Pdf" filterable="false" sortable="false" alias="pdf">
								<a href="#" id="linkPdf${viajes.viajeNr}"><img src="images/general/downloadPdf${viajes.procesado}.png" alt="Descarga Remito"  title="Descarga Remito"></img></a>
									<script type="text/javascript">											
										if (${viajes.procesado}) {
											$("#linkPdf${viajes.viajeNr}").bind("click", function() {
												downloadRemitoViaje('${viajes.viajeNr}');
											});
										}
									</script>
								</ec:column>
								<ec:column width="20px" title="Proceso ARBA" filterable="false" sortable="false" alias="read">
	          						<a href="#">
	          							<img src="images/general/procesar.png" alt="Autorizar Viaje" title=" Autorizar Viaje " onclick="autorizarViaje('${viajes.viajeNr}');" border="0" ></img>
	          						</a>
	          					</ec:column>
								<ec:column width="40px" property="viajeNr" title="ViajeNr" filterable="true" sortable="true" />
								<ec:column width="auto" property="fecha" title="Fecha" filterable="false" />
										
						</ec:row>
					</ec:table>
    	</fieldset>

	</div>

	
</div>

<div style="display: none" align="center" id="selectPatenteId" >
		<h1 id="idMsgSave" >Seleccione la Patente del Camión</h1>		
				<s:form action="as" >
				<table>					
					<tr>
						<td><s:select id="idPatenteSelect" name="patente.idPatente" cssErrorClass="error" cssClass="ui-widget-content ui-corner-all" list="%{#session['patenteList']}" listKey="idPatente" listValue="descripC" onchange=""/></td>					
					</tr>
				</table>
				
				<a onclick="autorizarViaje_old();">
					<img src="images/general/icon_aceptar_v1.png" alt="Procesar Remito" border="0" style="float:center;margin-top:0px;"></img>
				</a>					
				
				<a onclick="cancelar();">
					<img src="images/general/icon_cancelar.png" alt="Cancelar" border="0" style="float:center;margin-top:0px;"></img>
				</a>	
										
		</s:form>
								
</div>

<div style="display: none" align="center" id="resultCerrarTransacId" >
		<h1 id="idMsgSave" >Transacción</h1>		
		
				<a href="preparedViajesSinCot" onclick="this.blur();">
					<img src="images/general/icon_volver.png" alt="Volver al Agendado" border="0" style="float:center;margin-top:0px;"></img>
				</a>
				<a onclick="downloadRemito();">
					<img src="images/general/icon_download_remito.png" alt="Descargar Remito" border="0" style="float:center;margin-top:0px;"></img>
				</a>	
				
									
										
								
</div>

<s:form action="autorizarViaje" id="autorizarViajeForm">
	<s:hidden key="viaje.viajeNr" id="idViaje"/>
	<s:hidden key="patente.idPatente" id="idPatente"/>
</s:form>

 
<script type="text/javascript">


function autorizarViaje(idViaje){ 	
	$('#idViaje').val(idViaje);
	$('#viajeNrId').val(idViaje);
	$('#idMsgSave').text('Seleccione la patente del viaje ' + idViaje);
	
	$.blockUI({
		message : $('#selectPatenteId'),
		opacity : .1,
		color : 'black',
		css : {
			top : ($(window).height() - 100) / 2 + 'px',
			left : ($(window).width() - 700) / 2 + 'px',
			width : '700px'
		}
	});
}

function cancelar(){
	$.unblockUI();
}

function autorizarViaje_old(){ 	
	
	$('#idPatente').val($('#idPatenteSelect').val());

	if(true){
		//$("#validateTips").hide();
		$.blockUI({ 
			message:  '<h1>Se está enviando información a ARBA, por favor aguarde...</h1>'		
	    }); 
		$.ajax({
				  type: "POST",
				  url: "autorizarViaje",
				  data: $("#autorizarViajeForm").serialize(),
				  dataType: "script",
				  beforeSend: function(objeto){   				
				  },
				  success: function(msg){
					  var result = msg;
					  
						if (result == "OK"){
							//alert(msg)
							$("#idMsgSave").text(msg);
							$.unblockUI();
							$.blockUI({
			   				message : $('#resultCerrarTransacId'),
			   				opacity : .1,
			   				color : 'black',
			   				css : {
			   					top : ($(window).height() - 100) / 2  + 'px',
			   					left : ($(window).width() - 700) / 2 + 'px',
			   					width : '700px'
			   				}
			   				}); 	   			
						}else{
						 	$.unblockUI();
						 	$.blockUI({ 
								message:  result		
						    }); 	
						 	setTimeout($.unblockUI, 4000);
						}
	 			  },
				  error: function(objeto, quepaso, otroobj){
					alert("Comuniquese con el Administrador del Sistema : "+ quepaso);
				  }
			
				});

		}
}

function downloadRemito(){		
	document.getElementById("downloadRemitoForm").submit();
}

function downloadRemitoViaje(viaje){		
	$("#viajeNrId").val(viaje);
	document.getElementById("downloadRemitoForm").submit();
	
}
</script>

<s:form action="downloadRemito" id="downloadRemitoForm" target="_blank">
	<s:hidden key="viaje.viajeNr" id="viajeNrId"/>	
</s:form>

