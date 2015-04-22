<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ taglib uri="/WEB-INF/tlds/extremecomponents.tld" prefix="ec" %>
 
<link href="<%=request.getContextPath()%>/css/hints.css" rel="stylesheet" type="text/css" />


<div class="main">
	
	
	<div class="space"></div>
	
		<div class="panel_100 tab">
	    	<div class="space"></div>
           	<fieldset class="defaultFieldset">
    			<legend><b>Obtención de CAEA</b></legend>
    			<div class="space"></div>
 
			<s:form action="getCaea" id="listFacturaForm" theme="simple" cssClass="inline" method="post" >
						
 				
	 			<table>
 				<tr>
					<td>
	 					<label >Periodo (yyyymm):</label>	 				
	 					<input type="numeric" name="periodo" maxlength="6" size="6" >					
		 			</td>
		 			<td>
	 					<label >Quincena (1/2):</label>	 				
						<input type="text" name="quincena" maxlength="1" size = "1" >
					</td>					
	 				
					</tr>
					<tr>
					
					
				</tr>
				</table>
				<center>
				<div style="display: none" id="idAutoCompleteLoad"><img alt=""
					src="images/general/loading1.gif"></div>
						<div class="space"></div>
				<div id="consultar" style="display:inline;">
						<img src="images/general/icon_aceptar_v1.png" alt="Consultar" border="0" id="getCaea">						
				</div>
				
		</center>
			</s:form>
	
			<div class="space"></div>
						
			
			<div class="space"></div>
		</fieldset>

		<div class="space"></div>
	</div>
</div>

<script language="javascript">

$(document).ready(function(){
	
	$("#getCaea").click(function (){		   			
	   			$.ajax({
	   			  type: "POST",
	   			  url: "getCaea",
	   			  data: $("#listFacturaForm").serialize(),
	   			  dataType: "script",
	   			  beforeSend: function(objeto){   				
	   			  },
	   			  success: function(msg){
	   				alert(msg);
	   			  },
	   			  error: function(objeto, quepaso, otroobj){
	   				alert("Comuniquese con el Administrador del Sistema: "+ quepaso);
	   			  }
	   		
	   			});
			

		});
});
	
</script>


