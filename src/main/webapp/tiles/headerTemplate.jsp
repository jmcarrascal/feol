<%@page import="jmc.feol.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="jmc.feol.core.model.Usuario"%>



	
	<div class="pageHeader" style="margin:0px;background-image:url('images/general/coinse_header.png');background-repeat: no-repeat;border-bottom:1px solid #4d4d4d">
	
		<%
			//Tomar el usuario desde el Request
			Usuario usuarioActual = (Usuario) request.getSession().getAttribute("usuario");
		%>
		
	</div>
	

		<%
			switch (usuarioActual.getIdPerfil()) {
			case Constants.ID_USR_OPERADOR:
		%>
		<div id="menu" >
		    <ul class="menu">
		        <li><a href="#" class="parent"><span>Reporte</span></a>
		            <ul>
		                <li><a href="preparedListFacturas"><span>Comprobantes (Afip) Gestionados</span></a></li>
		                <li><a href="preparedListCots"><span>Comprobantes (Arba) Gestionados</span></a></li>
		            </ul>
		        </li>
		        <li><a href="#" class="parent"><span>Gestiones AFIP Local</span></a>
		            
		            <ul>
		                <li><a href="preparedDownloadFactura"><span>Comprobantes informados</span></a></li>
		                <li><a href="preparedGetCaea"><span>Obtener CAEA</span></a></li>
		                <li><a href="historyCaea"><span>Historico CAEA</span></a></li>
		                <li><a href="preparedDownloadFactura"><span>Verificación de Afip</span></a></li>
		            </ul>
		            
		        </li>
		        <li><a href="#" class="parent"><span>Gestiones AFIP Expo</span></a>
		            
		            <ul>
		                <li><a href="preparedCotizacionExpo"><span>Cotización actual</span></a></li>
		                <li><a href="preparedDownloadFacturaExpo"><span>Comprobantes informados</span></a></li>
		                <li><a href="preparedVerifAfipExpo"><span>Verificación de Afip</span></a></li>
		            </ul>
		            
		        </li>
				<li><a href="tablasAFIP" class="parent"><span>Tablas AFIP</span></a>
		        <li><a href="out" class="parent"><span>Salir</span></a>
		    </ul>
		</div>

		<%
			break;
			case 2:
		%>
		<div id="menu" >
		    <ul class="menu">
		        <li><a href="#" class="parent"><span>Administración</span></a>
		            <ul>
		                <li><a href="preparedListParametrizacion"><span>Parametrización</span></a></li>
		            </ul>
		        </li>
		        <li><a href="#" class="parent"><span>Reporte</span></a>
		            <ul>
		                <li><a href="preparedListFacturas"><span>Comprobantes Gestionados</span></a></li>
		            </ul>
		        </li>
		        <li><a href="#" class="parent"><span>Gestiones AFIP Local</span></a>
		            
		            <ul>
		                <li><a href="preparedDownloadFactura"><span>Comprobantes informados</span></a></li>
		                <li><a href="preparedDownloadFactura"><span>Verificación de Afip</span></a></li>
		                <li><a href="facturasPerdidas"><span>Facturas con Problemas de Internet</span></a></li>
		            </ul>
		            
		        </li>
		        <li><a href="#" class="parent"><span>Gestiones AFIP Expo</span></a>
		            
		            <ul>
		                <li><a href="preparedCotizacionExpo"><span>Cotización actual</span></a></li>
		                <li><a href="preparedDownloadFacturaExpo"><span>Comprobantes informados</span></a></li>
		                <li><a href="preparedVerifAfipExpo"><span>Verificación de Afip</span></a></li>
		            </ul>
		            
		        </li>
		        <li><a href="tablasAFIP" class="parent"><span>Tablas AFIP</span></a>
		        <li><a href="out" class="parent"><span>Salir</span></a>
		    </ul>
		</div>
		<%
			break;
			case 4:
		%>
		<div id="menu" >
		    <ul class="menu">
		    <li><a href="#" class="parent"><span>Administración</span></a>
		            <ul>
		                <li><a href="preparedListParametrizacion"><span>Parametrización</span></a></li>
		            </ul>
		        </li>
		        <li><a href="#" class="parent"><span>COT</span></a>
		            <ul>
		                <li><a href="preparedViajesSinCot"><span>Viajes sin Autorización</span></a></li>
		            </ul>
		        </li>
		        <li><a href="#" class="parent"><span>Patentes</span></a>
		            <ul>
		                <li><a href="preparedListPatente"><span>Listar Patentes</span></a></li>
		                <li><a href="preparedNewPatente"><span>Nueva Patente</span></a></li>
		            </ul>
		        </li>
		        <li><a href="out" class="parent"><span>Salir</span></a>
		    </ul>
		</div>
		
		<%
			break;
			case 5:
		%>
				<div id="menu" >
		    <ul class="menu">
		        <li><a href="#" class="parent"><span>Reporte</span></a>
		            <ul>
		                <li><a href="preparedListFacturas"><span>Comprobantes Gestionados</span></a></li>
		            </ul>
		        </li>
		        <li><a href="#" class="parent"><span>Gestiones AFIP Local</span></a>
		            
		            <ul>
		                <li><a href="preparedDownloadFactura"><span>Comprobantes informados</span></a></li>
		                <li><a href="preparedDownloadFactura"><span>Verificación de Afip</span></a></li>
		            </ul>
		            
		        </li>
		        <li><a href="#" class="parent"><span>Gestiones AFIP Expo</span></a>
		            
		            <ul>
		                <li><a href="funcionNoLicenciada"><span>Cotización actual</span></a></li>
		                <li><a href="funcionNoLicenciada"><span>Comprobantes informados</span></a></li>
		                <li><a href="funcionNoLicenciada"><span>Verificación de Afip</span></a></li>
		            </ul>
		            
		        </li>
				<li><a href="tablasAFIP" class="parent"><span>Tablas AFIP</span></a>
		        <li><a href="out" class="parent"><span>Salir</span></a>
		    </ul>
		</div>
<%
			break;
			}
		%>
<br>
<br>
	