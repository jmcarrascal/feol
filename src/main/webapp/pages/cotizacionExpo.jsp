<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>


<link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/popup.js" type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/js/jquery.autocomplete.js" type="text/javascript"></script>
 
<script>
	
	$(document).ready(function(){
		
		
		$("#consultar").click(function (){
			document.getElementById("idAutoCompleteLoad").style.display = "inline";
			window.scrollTo(0,0);   			
   	   			$.ajax({
   	   			  type: "POST",
   	   			  url: "showCotizacionExpo",
   	   			  data: $("#formCotizacion").serialize(),
   	   			  dataType: "script",
   	   			  beforeSend: function(objeto){   				
   	   			  },
   	   			  success: function(msg){
   	   				
   	   				$("#monto").val(msg);  
   	   			 	
   	   				$("#monedaShow").val($("#moneda").val());

   	   				showPopup();
   	   				document.getElementById("idAutoCompleteLoad").style.display = "none";
   	   			  },
   	   			  error: function(objeto, quepaso, otroobj){
   	   				alert("Comunï¿½quese con el Administrador del Sistema: "+ quepaso);
   	   			  }
   	   		
   	   			});
   			

   		});
	});
		
</script>
<div class="main">
	
	
	<div class="space"></div>
	
		<div class="panel_100 tab">
	    	<div class="space"></div>
 
	<s:form id="formCotizacion" action="showCotizacionExpo" theme="simple" cssClass="inline" method="post" >
		
		<fieldset class="defaultFieldset" >
		<legend><b>Cotizacion de Moneda</b></legend>
		<div class="space"></div>
		<s:actionerror/>
		<s:actionmessage/>
		
				
	    <table>
			<tr>
				<td><label for="moneda">Ingrese el codigo de la Moneda</label></td>
			   	<td><s:textfield id="moneda" name="moneda" size="5" maxlength="3" cssErrorClass="error" cssClass="ui-widget-content ui-corner-all"/></td>
			</tr>
	    </table>
		<center>
			<div style="display: none" id="idAutoCompleteLoad"><img alt=""
					src="images/general/loading1.gif"></div>	
					<div class="space"></div>
			<div id="consultar" style="display:inline;">
					<img src="images/general/icon_guardar.png" alt="Consultar" border="0">		
				
			</div>
			
		</center>
		
		</fieldset>
	</s:form>
	
	</div>
	</div>
	
	<div id="popupContact" >
		<a id="popupContactClose">x</a>
		<h1>Consulta de Cotizacion</h1>
		<div class="space"></div>
		<div class="space"></div>
	    <table>
			<tr>
				<td><label for="moneda">Codigo de Moneda</label></td>
		   		<td><s:textfield id="monedaShow" name="moneda" size="5" maxlength="3" cssErrorClass="error" cssClass="ui-widget-content ui-corner-all" readonly="true"/></td>
			</tr>
			<tr>			
				<td><label for="moneda">Valor de la cotización</label></td>
			   	<td><s:textarea id="monto" name="monto" cols="20" rows="3"  cssErrorClass="error" cssClass="ui-widget-content ui-corner-all" readonly="true"/></td>
			</tr>
	    </table>
								
	</div>
	<div id="backgroundPopup"></div>	


<s:form action="otipABandejaPendientes" id="goToPendientes">	
</s:form>

<s:form action="otipAgetFichaDactilar" id="downloadFichaDactilarForm">
	<s:hidden key="solicitud.idSolicitud" id="idSolicitudFD"/>
</s:form>
