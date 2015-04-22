<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>


 
<script>
	
	$(document).ready(function(){
		
		$("#consultar").click(function (){
			window.scrollTo(0,0);   			
   	   			$.ajax({
   	   			  type: "POST",
   	   			  url: "verifAfipExpo",
   	   			  data: $("#verifAfipExpoForm").serialize(),
   	   			  dataType: "script",
   	   			  beforeSend: function(objeto){   				
   	   			  },
   	   			  success: function(msg){
   	   				alert(msg)
   	   				//$("#estadId").val(msg); 

   	   				//showPopup();
   	   			  },
   	   			  error: function(objeto, quepaso, otroobj){
   	   				alert("Comunï¿½quese con el Administrador del Sistema: "+ quepaso);
   	   			  }
   	   		
   	   			});
   			

   		});
	});
		
</script>
<div class="main">
		<div class="panel_100 tab">
	    	<div class="space"></div>
     <fieldset class="defaultFieldset" >
		<legend><b>Verificación de conectividad hacia AFIP</b></legend>
		
	<s:form id="verifAfipExpoForm" action="verifAfipExpo" theme="simple" cssClass="inline" method="post" >
		
		
		<s:actionerror/>
		<s:actionmessage/>
						
		<center>
			<div id="consultar" style="display:inline;">
					<img src="images/general/icon_aceptar_v1.png" alt="Consultar" border="0">						
			</div>
		</center>
		
		
	</s:form>
	</fieldset>
		</div>
	<div id="popupContact" >
		<a id="popupContactClose">x</a>
		<h1>Veficación AFIP</h1>
		<div class="space"></div>
		<div class="space"></div>
	    <table>
			<tr>			
				<td><label for="moneda">Estado</label></td>
			   	<td><s:textarea id="estadoId" cols="20" rows="6"  cssErrorClass="error" cssClass="ui-widget-content ui-corner-all" readonly="true"/></td>
			</tr>
	    </table>
								
	</div>
	<div id="backgroundPopup"></div>	

</div>
<s:form action="otipABandejaPendientes" id="goToPendientes">	
</s:form>

<s:form action="otipAgetFichaDactilar" id="downloadFichaDactilarForm">
	<s:hidden key="solicitud.idSolicitud" id="idSolicitudFD"/>
</s:form>
