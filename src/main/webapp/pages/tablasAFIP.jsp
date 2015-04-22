<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>


<link href="<%=request.getContextPath()%>/css/styles.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/popup.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/popup.js" type="text/javascript"></script>

<script src="<%=request.getContextPath()%>/js/jquery.autocomplete.js" type="text/javascript"></script>
 
<script>
	
	$(document).ready(function(){
		
		$("#consultar").click(function (){
			window.scrollTo(0,0);   			
   	   			$.ajax({
   	   			  type: "POST",
   	   			  url: "showCotizacion",
   	   			  data: $("#formCotizacion").serialize(),
   	   			  dataType: "script",
   	   			  beforeSend: function(objeto){   				
   	   			  },
   	   			  success: function(msg){
   	   				
   	   				$("#monto").val(msg);  
   	   			 	
   	   				$("#monedaShow").val($("#moneda").val());

   	   				showPopup();
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
           	<fieldset class="defaultFieldset">
    			<legend><b>Tablas de AFIP</b></legend>
 
	<s:form id="formCotizacion" action="showCotizacion" theme="simple" cssClass="inline" method="post" >
		
			<br>	
				<div align="center">
					<a href="tablas/tablaProvincias.xls" target="_blank">Códigos de Provincia </a>
				</div>
				<br>
				<div align="center">
					<a href="tablas/tipoComprobante.xls">Tipos de Comprobantes </a>
				</div>
				<br>
				<div align="center">
					<a href="tablas/docReceptor.xls">Documento Receptor </a>
				</div>
				<br>
				<div align="center">
					<a href="tablas/operacionIVA.xls">Operación / Condición IVA </a>
				</div>
				<br>
				<div align="center">
					<a href="tablas/conceptosIncluidos.xls">Conceptos Incluidos </a>
				</div>
				<br>
				<div align="center">
					<a href="tablas/incoterms.xls">Incoterms </a>
				</div>
				<br>
				<div align="center">
					<a href="tablas/tablaProvincias.xls">Idiomas </a>
				</div>
				<br>
				<div align="center">
					<a href="tablas/tipoResponsable.xls">Tipos de Responsable </a>
				</div>
				<br>
				<div align="center">
					<a href="tablas/unidadMedida.xls">Unidad de Medida </a>
				</div>
				<br>
				<div align="center">
					<a href="tablas/monedas.xls">Monedas </a>
				</div>
				<br>
				<div align="center">
					<a href="tablas/paises.xls">Países </a>
				</div>
				<br>
				<div align="center">
					<a href="tablas/cuitpais.xls">CUIT País</a>
				</div>
				<br>
				<div align="center">
					<a href="tablas/otrostributos.xls">Otros Tributos </a>
				</div>
				<br>

		
	</s:form>
	</fieldset>
	</div>
	</div>

<s:form action="otipABandejaPendientes" id="goToPendientes">	
</s:form>

<s:form action="otipAgetFichaDactilar" id="downloadFichaDactilarForm">
	<s:hidden key="solicitud.idSolicitud" id="idSolicitudFD"/>
</s:form>
