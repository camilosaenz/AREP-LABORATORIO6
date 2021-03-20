package edu.escuelaing.arep.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
public class SecureURLReader {
	
    public static void Secure() {
        try {
        	File trustStoreFile = new File("keycerts/myTrustStore");
        	char[] trustStorePassword = "123456".toCharArray();
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(new FileInputStream(trustStoreFile), trustStorePassword);
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(trustStore);
            for(TrustManager t: tmf.getTrustManagers()){
                //System.out.println(t);
            }
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, tmf.getTrustManagers(), null);
            SSLContext.setDefault(sslContext);
        } catch (KeyStoreException ex) {
            Logger.getLogger(SecureURLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SecureURLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SecureURLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SecureURLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CertificateException ex) {
            Logger.getLogger(SecureURLReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(SecureURLReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	public static String readURL(String path) throws IOException {
		// Crea el objeto que representa una URL
		URL siteURL=null;
		try {
		siteURL = new URL(path);
		} catch (MalformedURLException ex) {
		Logger.getLogger(SecureURLReader.class.getName()).log(Level.SEVERE, null, ex);
		}
		// Crea el objeto que URLConnection
		URLConnection urlConnection = siteURL.openConnection();
		// Obtiene los campos del encabezado y los almacena en un estructura Map
		Map<String, List<String>> headers = urlConnection.getHeaderFields();
		// Obtiene una vista del mapa como conjunto de pares <K,V> // para poder navegarlo
		Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
		// Recorre la lista de campos e imprime los valores
		for (Map.Entry<String, List<String>> entry : entrySet) {
		String headerName = entry.getKey();
		//Si el nombre es nulo, significa que es la linea de estado
		if (headerName != null) {
		}
		List<String> headerValues = entry.getValue();
		for (String value : headerValues) {
		
		}
		
		//System.out.println("");
		}
		try {
		BufferedReader reader
		= new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String inputLine = null;
		while ((inputLine = reader.readLine()) != null) {
		}
		} catch (IOException x) {
		System.err.println(x);
		}
		return "";
	}
}