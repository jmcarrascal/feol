package jmc.feol.util;



public class Constants {
	//Usuarios
	public final static Long PERFIL_OPERADOR=0l;
	public final static Long PERFIL_ADMINISTRADOR=1l;
	
	//Directorios
	public final static Long ID_CARPETA_PROVISORIO=1l;
	public final static Long ID_CARPETA_DEFINITIVO=2l;
	public final static Long ID_CARPETA_SALIDA=3l;
	public final static Long ID_CARPETA_ENTRADA=4l;
	public final static Long ID_CARPETA_ERRORES=5l;
	public final static Long ID_RUTA_FILE_CAEA=501l;
	
	//ParamConnAfip
	public final static Long ID_HOST=6l;
	public final static Long ID_URL_APP=7l;
	public final static Long ID_URL_PORT=8l;
	public final static Long ID_USE_PROXY=9l;
	public final static Long ID_PROXY_URL=10l;
	public final static Long ID_PROXY_PORT=11l;
	public final static Long ID_KEYSTORE_PASS=12l;
	
	
	//BaseExterna
	public final static Long ID_ACTUALIZO_BASE_EXTERNA=14l;
	public final static Long ID_URL_BASE=15l;
	public final static Long ID_BASE=16l;
	public final static Long ID_USUARIO=17l;
	public final static Long ID_USUARIO_CLAVE=18l;
	public final static Long ID_TABLA=19l;
	public final static Long ID_CONTROLADOR=20l;
	public final static Long ID_PREFIJO=21l;
	public final static Long ID_CAMPONUMCOT=22l;
	public final static Long ID_CAMPORESPUESTARENTAS=23l;
	public final static Long ID_CAMPOREMITO=24l;
	
	//AS400
	public final static Long ID_SISTEMA=29l;
	public final static Long ID_BASE_GENERIC=50l;
	public final static Long ID_USR_AS=31l;
	public final static Long ID_PASS_AS=32l;
	public final static Long ID_DTAQ_TAMANO_CLAVE=27l;
	public final static Long ID_DTAQ_CLAVE=28l;
	public final static Long ID_DTAQ_LIB=30l;
	public final static Long ID_DTAQ=33l;
	
	public final static Long HORAS_TOKEN_VIGENTE = 25l;
	
	public final static Long ID_TOMO_LAST_CMP=26l;
	
	//Configuracion de Mail	
	public final static Long ID_SMTP_HOST=60l;
	public final static Long ID_SMTP_STARTTLS_ENABLE=61l;
	public final static Long ID_SMTP_PORT=62l;
	public final static Long ID_SMTP_USER=63l;
	public final static Long ID_SMTP_AUTH=64l;	
	public final static Long ID_MAIL_ADMNISTRADOR=70l;
	public final static Long ID_ENVIA_MAIL=71l;	
	public final static Long ID_USO_LISTENERCONNAFIP=72l;	
	
	public final static Long ID_USO_LISTENERREADFILES=140l;	
	public static final Long ID_USO_LISTENERREADFILES_COT = 600l;
		
	public final static Long ID_USO_LISTENERDTAQ=150l;	
	public final static Long ID_LISTENERCONNAFIP_TIEMPO=73l;	
	public final static Long ID_USO_LISTENERFORWARDFACTURA= 80l;
	public final static Long ID_USO_LISTENERFORWARDFFILEACTURA= 81l;
	public final static Long ID_DOMINIO_LISTENERFORWARDFACTURA= 90l;		
	public static final String PACKAGE_MODEL= "jmc.feol.core.model";	
	public final static Long ID_PASSWORD= 100l;	
	public final static Long ID_APP_WEB= 110l;	
	public final static Long ID_USR_SQL= 120l;	
	public final static Long ID_PASSWORD_SQL= 130l;	
	public final static int ID_USR_OPERADOR = 1;
	public final static Long ID_USE_MODE_CAEA = 500l;
	
	//Facturacion MTX
	public final static Long ID_FACTURA_MTX= 160l;
	
	
	//SendMail
	public final static Long USE_SERVICE_SENDMAIL= 200l;

	//Recupero Imagen Cheque
	public final static Long ID_USO_LISTENERGETIMAGECHEQUE= 300l;
	public final static Long TESO_SERVIDOR= 301l;
	public final static Long TESO_BASE= 302l;
	public final static Long TESO_USR= 303l;
	public final static Long TESO_PASS= 304l;
	public final static Long TESO_TABLA= 305l;
	public final static Long TESO_CAMPO_PK= 306l;
	
	//Exportacion v1
	public final static Long ID_USO_LISTENERREADFILESEXPOV1=400l;
	//Directorios
	public final static Long ID_CARPETA_PROVISORIO_EXPOV1=401l;
	public final static Long ID_CARPETA_DEFINITIVO_EXPOV1=402l;
	public final static Long ID_CARPETA_SALIDA_EXPOV1=403l;
	public final static Long ID_CARPETA_ENTRADA_EXPOV1=404l;
	public final static Long ID_CARPETA_ERRORES_EXPOV1=405l;
	
	  
	//cot
	/*
	public final static Long ID_SERVIDOR=500l;
	public final static Long ID_VIAJE_INICIO=501l;
	public final static Long ID_BASE_EMPRESA_COT=502l;
	public final static Long ID_CUIT_COT=503l;
	public final static Long ID_BASE_COMUN=504l;
	public final static Long ID_BASE_STOCK=505l;
	
	public final static Long ID_RAZON=506l;
	public final static Long ID_CALLE=507l;
	public final static Long ID_NUMERO=508l;
	public final static Long ID_LOCALIDAD=509l;
	public final static Long ID_PASS_COT=510l;
	*/
	
	
}
