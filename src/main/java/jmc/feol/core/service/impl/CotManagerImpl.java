package jmc.feol.core.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.Socket;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import jmc.feol.core.model.cot.ParamConnRentas;
import jmc.feol.core.service.CotManager;
import jmc.feol.util.Manejador;

/**
 * 
 * 
 */
public class CotManagerImpl implements CotManager {

	private SSLSocket socket;
	private ParamConnRentas paramConnRentas;
	private String userRentas;
	private String passwordRentas;
	private File fileB;
	
	public CotManagerImpl(ParamConnRentas paramConnRentas, String passwordRentas,
			File fileB, String userRentas) {		
		this.setParamConnRentas(paramConnRentas);
		this.setPasswordRentas(passwordRentas);
		this.setFileB(fileB);
		this.setUserRentas(userRentas);
	}
	
	public List<String> getCot()  {
		
		List<String> respuestaRentas = new ArrayList<String>();
		try{
			
			System.setProperty("javax.net.ssl.keyStoreType", "JKS");
			String filename = System.getProperty("java.home")
					+ "/lib/security/cacerts".replace('/', File.separatorChar);
			String password = paramConnRentas.getKeystoreJREPassword();
			String host = paramConnRentas.getHost();
			System.out.println("Invoco al Server: " + host);
			Integer hostPort = paramConnRentas.getUrlPort();
			System.setProperty("javax.net.ssl.trustStore", filename);
			System.setProperty("javax.net.ssl.trustStorePassword", password);
			InetAddress dir = InetAddress.getByName(host);
			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
			setSocket((SSLSocket) factory.createSocket(dir, hostPort));
			this.socket.startHandshake();		
			Writer out = new OutputStreamWriter(socket.getOutputStream(),
					"ISO-8859-1");
			writeln("POST " + paramConnRentas.getUrlApp() + " HTTP/1.0", out);
			writeln("User-Agent: Mozilla/4.0 (compatible; MSIE 6.0;)", out);
			write("Content-type: multipart/form-data; boundary=", out);
			writeln(boundary, out);
			writeln("Content-Length: " + Integer.toString(calcularLongitud()), out);
			writeln(("Host:" + paramConnRentas.getHost() + ":" + paramConnRentas.getUrlPort()), out);
			newline(out);
			setParameter("user", this.getUserRentas(), out);
			setParameter("password", this.getPasswordRentas(), out);
			setParameter("file", this.getFileB(), out);
			boundary(out);
			write("--", out);
			newline(out);
			out.flush();
			InputStream inputStream = socket.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			String inputLine = "";
			while ((inputLine = in.readLine()) != null && !(inputLine.equals("0"))) {
				respuestaRentas.add(inputLine);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return respuestaRentas;
	}

	private static void doTunnelHandshake(Socket tunnel, String host, int port)
			throws IOException {
		OutputStream out = tunnel.getOutputStream();
		String msg = "CONNECT " + host + ":" + port + " HTTP/1.0\n"
				+ "User-Agent: "
				+ sun.net.www.protocol.http.HttpURLConnection.userAgent
				+ "\r\n\r\n";
		byte b[];
		try {
			/*
			 * We really do want ASCII7 -- the http protocol doesn't change with
			 * locale.
			 */
			b = msg.getBytes("ASCII7");
		} catch (UnsupportedEncodingException ignored) {
			/*
			 * If ASCII7 isn't there, something serious is wrong, but Paranoia
			 * Is Good (tm)
			 */
			b = msg.getBytes();
		}
		out.write(b);
		out.flush();

		/*
		 * We need to store the reply so we can create a detailed error message
		 * to the user.
		 */
		byte reply[] = new byte[200];
		int replyLen = 0;
		int newlinesSeen = 0;
		boolean headerDone = false; /* Done on first newline */

		InputStream in = tunnel.getInputStream();
		boolean error = false;

		while (newlinesSeen < 2) {
			int i = in.read();
			if (i < 0) {
				throw new IOException("Unexpected EOF from proxy");
			}
			if (i == '\n') {
				headerDone = true;
				++newlinesSeen;
			} else if (i != '\r') {
				newlinesSeen = 0;
				if (!headerDone && replyLen < reply.length) {
					reply[replyLen++] = (byte) i;
				}
			}
		}

		/*
		 * Converting the byte array to a string is slightly wasteful in the
		 * case where the connection was successful, but it's insignificant
		 * compared to the network overhead.
		 */
		String replyStr;
		try {
			replyStr = new String(reply, 0, replyLen, "ASCII7");
		} catch (UnsupportedEncodingException ignored) {
			replyStr = new String(reply, 0, replyLen);
		}

		/*
		 * We check for Connection Established because our proxy returns
		 * HTTP/1.1 instead of 1.0
		 */
		/*
		 * if (!replyStr.startsWith("HTTP/1.1 200")) {
		 * //if(replyStr.toLowerCase().indexOf("200 connection established") ==
		 * -1){ throw new IOException("Unable to tunnel through " + ":" +
		 * ".  Proxy returns \"" + replyStr + "\""); }
		 */
		/* tunneling Handshake was successful! */
	}

	private int calcularLongitud() {
		int longitud_datos = 0;
		longitud_datos += getLongitudDatos("--" + boundary + "\r\n");
		longitud_datos += getLongitudDatos("Content-Disposition: form-data; name=\"user\" "
				+ "\r\n");
		longitud_datos += getLongitudDatos(this.getUserRentas() + "\r\n");
		longitud_datos += getLongitudDatos("--" + boundary + "\r\n");
		longitud_datos += getLongitudDatos("Content-Disposition: form-data; name=\"password\""
				+ "\r\n\r\n");
		longitud_datos += getLongitudDatos(this.getPasswordRentas() + "\r\n");
		longitud_datos += getLongitudDatos("--" + boundary + "\r\n");
		longitud_datos += getLongitudDatos("Content-Disposition: form-data; name=\"file\"; filename=\""
				+ this.getFileB().getName() + "\"\r\n");
		longitud_datos += getLongitudDatos("Content-Type: text/plain \r\n\r\n");
		longitud_datos += getLongitudDatos(this.getFileB());
		longitud_datos += getLongitudDatos("\u0000\r\n");
		longitud_datos += getLongitudDatos("--" + boundary + "--\r\n");
		return longitud_datos;
	}

	private static Random random = new Random();
	private static String boundary = "--------------------" + randomString()
			+ randomString();

	private static void pipe(String filePath, Writer out) throws IOException {
		String fileData;
		FileReader fileReader = new FileReader(filePath);
		char[] cbuf = new char[2048];
		int len;
		fileData = "";
		while ((len = fileReader.read(cbuf)) != -1) {
			fileData += new String(cbuf, 0, len);
			// out.write(cbuf);

		}
		fileData += "\u0000";
		fileReader.close();
		out.write(fileData);

	}

	protected static void write(String s, Writer os) throws IOException {
		os.write(s);

	}

	protected static void newline(Writer os) throws IOException {
		write("\r\n", os);

	}

	protected static void writeln(String s, Writer os) throws IOException {
		write(s, os);
		newline(os);
	}

	protected static String randomString() {
		return Long.toString(random.nextLong(), 36);
	}

	private static void boundary(Writer os) throws IOException {
		write("--", os);
		write(boundary, os);
	}

	private static void writeName(String name, Writer os) throws IOException {
		newline(os);
		write("Content-Disposition: form-data; name=\"", os);
		write(name, os);
		write("\"", os);
	}

	private static void setParameter(String name, String value, Writer os)
			throws IOException {
		boundary(os);
		writeName(name, os);
		newline(os);
		newline(os);
		writeln(value, os);
	}

	private static void setParameter(String name, String filePath,
			String fileName, Writer os) throws IOException {
		boundary(os);
		writeName(name, os);
		write("; filename=\"", os);
		write(fileName, os);
		write("\"", os);
		newline(os);
		write("Content-Type: ", os);
		String type = "text/plain";
		writeln(type, os);
		newline(os);
		pipe(filePath, os);
		newline(os);
	}

	private static void setParameter(String name, File file, Writer os)
			throws IOException {
		setParameter(name, file.getPath(), file.getName(), os);
	}

	private static int getLongitudDatos(File archivo) {
		int longitud = 0;
		String fileData;
		try {
			FileReader fileReader = new FileReader(archivo.getPath());
			char[] cbuf = new char[2048];
			int len;
			fileData = "";
			while ((len = fileReader.read(cbuf)) != -1) {
				fileData += new String(cbuf, 0, len);
			}
			fileReader.close();
			longitud = fileData.length();
		} catch (IOException ioe) {
			// nadinas
		}
		return longitud;
	}

	private static int getLongitudDatos(String string) {
		int len = 0;
		len = string.length();
		return len;
	}


	public void setResultRentasXML(File archivoXML)throws Exception{        
        SAXParser parser;
        SAXParserFactory factoria = SAXParserFactory.newInstance();
        factoria.setNamespaceAware(true);
        parser = factoria.newSAXParser();
        Manejador man = new Manejador();
        parser.parse(archivoXML.getPath(), man);
        
        if (man.sin_error){
              //System.out.println("Todo ok " + strFecha);
              //System.out.print(man.nombreArchivo + " - ");
              //System.out.println(man.nro_comprobante);
              //digecot.setCcncot(man.nro_comprobante);
              for(int i=0; i<=(man.remito-1);i++ ){               
                  System.out.println(man.remitos[i][0] + " Procesado: "+man.remitos[i][1]);
              }
        }
        else{
            //System.out.println("Todo mal "+ strFecha); 
            //System.out.println("Enlace "+ archivoCot.getClaveEnlace() + " / Remito: " + archivoCot.getLetra()+ archivoCot.getNroRemito());
            //System.out.println(man.ErrDescription);
            //digecot.setCcresp(man.ErrDescription);
        	//archivoCot.setNumeroCot("999999");
            //archivoCot.setDescripcion(man.ErrDescription);
            //digecot.setStatus("1");
       }
              
	}

	public File getFileB() {
		return fileB;
	}

	public void setFileB(File fileB) {
		this.fileB = fileB;
	}

	public String getUserRentas() {
		return userRentas;
	}

	public void setUserRentas(String userRentas) {
		this.userRentas = userRentas;
	}

	public String getPasswordRentas() {
		return passwordRentas;
	}



	public void setPasswordRentas(String passwordRentas) {
		this.passwordRentas = passwordRentas;
	}

	public ParamConnRentas getParamConnRentas() {
		return paramConnRentas;
	}

	public void setParamConnRentas(ParamConnRentas paramConnRentas) {
		this.paramConnRentas = paramConnRentas;
	}



	public SSLSocket getSocket() {
		return socket;
	}



	public void setSocket(SSLSocket socket) {
		this.socket = socket;
	}

}
