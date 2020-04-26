package ClientInterfaces;

import java.io.*;
import java.util.*;

/**
 * KMIP v 2.0 Java Library/API is extensible, easily upgradable (to integrate features of future KMIP versions), and open source. 
 * An object of this class needs to be created in order to access the services 
 * provided by this library.
 * @author Vedika Ghei, Soha Parasnis, Tanisha Rathi, Vidushi Mishra 
 * @version 1.0
 */

public class MainApplication
{
	
	static Properties prop = new Properties();
	InputStream input = null;
	static Connection connection;

	/**
	 * Sets the IP and Port of the key management server, as specified by user, for
	 * a session and returns the object of type Connection.
	 * 
	 * @param IP   IP Address of the key management server
	 * @param Port port number where the key management server listens
	 * @return object of type Connection
	 * @throws NumberFormatException
	 * @throws IOException
	 * @see Connection
	 */
	public Connection getConnection(String IP, int Port) throws NumberFormatException, IOException {
		prop.setProperty("IPAddress", IP);
		prop.setProperty("Port", Integer.toString(Port));
		KMIPConnection kconn = new KMIPConnection();
		connection = kconn.connect(prop.getProperty("IPAddress"), Integer.parseInt(prop.getProperty("Port")));
		return connection;
	}

	/**
	 * Sets the key store and trust store path, type (for eg. JCEKS), and the
	 * password.
	 * 
	 * @param TrustStorePath     a path that specifies where the key store and trust
	 *                           store is located
	 * @param TrustStoreType     the type of the key store and trust store used
	 * @param TrustStorePassword the key store and trust store password
	 */
	public void setKeyStore(String TrustStorePath, String TrustStoreType, String TrustStorePassword) {
		KMIPConnection kconn = new KMIPConnection();
		kconn.setKeyStore(TrustStorePath, TrustStoreType, TrustStorePassword);
	}

	/**
	 * This method allows the user to create a key, of the specified length, type
	 * and cryptographic algorithm, on the key management server.
	 * 
	 * @param algorithm Cryptographic Algorithm (for eg. AES)
	 * @param length    length of the key in bits (for eg. 128)
	 * @param type      type of key (input syntax example: SymmetricKey)
	 * @return {@code List<String>}the Unique Identifier of the key, after its
	 *         creation on the key management server
	 * @throws Exception
	 * @see Exception
	 */
	public List<String> createKey(String algorithm, int length, String type) throws Exception {
		KMIPOperations kops = new KMIPOperations();
		KeyUniqueIDMap k = new KeyUniqueIDMap(algorithm, length, type);
		KeyUniqueIDMap kr = kops.create(k, connection);
		// System.out.println(kr.requiredValues);
		return kr.requiredValues;

	}

	/**
	 * This method allows the user to create a key pair (a public and a private
	 * key), of the specified length, type and cryptographic algorithm, on the key
	 * management server.
	 * 
	 * @param algorithm           Cryptographic Algorithm (for eg. RSA)
	 * @param length              length of the key in bits (for eg. 1024)
	 * @param type                type of key (input syntax example: AsymmetricKey)
	 * @param privateKeyNameValue a unique, meaningful name assigned to the private
	 *                            key
	 * @param publicKeyNameValue  a unique, meaningful name assigned to the public
	 *                            key
	 * @return {@code List<String>}the Unique Identifiers of both the keys, public
	 *         and private
	 * @throws Exception
	 */
	public List<String> createKeyPair(String algorithm, int length, String type, String privateKeyNameValue,
			String publicKeyNameValue) throws Exception {

		KMIPOperations kops = new KMIPOperations();
		KeyUniqueIDMap k = new KeyUniqueIDMap(algorithm, length, type, privateKeyNameValue, publicKeyNameValue);
		KeyUniqueIDMap kr = kops.createKeyPair(k, connection);
		// System.out.println(kr.requiredValues);
		return kr.requiredValues;

	}

	/**
	 * This method allows the user to get the key format type and key material of a
	 * particular key that already exists on the key management server, using its
	 * Unique Identifier.
	 * 
	 * @param uniqueIdentifier UniqueIdentifier of a key that already exists on the
	 *                         key management server
	 * @return {@code List<String>} unique identifier, key format type, key material
	 * @throws Exception
	 * @see Exception
	 */
	public List<String> getKey(String uniqueIdentifier) throws Exception {
		KMIPOperations kops = new KMIPOperations();
		KeyUniqueIDMap kg = new KeyUniqueIDMap(uniqueIdentifier);
		KeyUniqueIDMap kgresponse = kops.get(kg, connection);

		return kgresponse.requiredValues;
	}

	/**
	 * This method allows the user to destroy the key that already exists on the key
	 * management server, using its Unique Identifier. Once a key is destroyed, the
	 * user can see it using {@link LocateKey}, but cannot get it using
	 * {@link GetKey}
	 * 
	 * @param uniqueIdentifier UniqueIdentifier of a key that already exists on the
	 *                         key management server
	 * @return {@code List<String>} unique identifier of the destroyed key
	 * @throws Exception
	 * @see Exception
	 */
	public List<String> destroykey(String uniqueIdentifier) throws Exception {
		KMIPOperations kops = new KMIPOperations();
		KeyUniqueIDMap kdestroy = new KeyUniqueIDMap(uniqueIdentifier);
		KeyUniqueIDMap kdestroyresponse = kops.destroy(kdestroy, connection);

		return kdestroyresponse.requiredValues;
	}

	/**
	 * This method allows the user to locate a key on the key management server,
	 * using its object type. The user can access the UniqueIdentifier of a key,
	 * even after it is destroyed.
	 * 
	 * @param objectType the object type of the key (for eg. "SymmetricKey",
	 *                   "PublicKey", "PrivateKey").
	 * @return {@code List<String>} all the unique identifiers of the existing keys
	 *         of the object type specified.
	 * @throws Exception
	 * @see Exception
	 */
	public List<String> locateKey(String objectType) throws Exception {
		KMIPOperations kops = new KMIPOperations();
		KeyUniqueIDMap klocate = new KeyUniqueIDMap();
		klocate.setType(objectType);
		KeyUniqueIDMap klocateresponse = kops.locate(klocate, connection);

		return klocateresponse.requiredValues;

	}

	/**
	 * This is the main method in the entire library API.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		MainApplication m = new MainApplication();
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		KMIPConnection kconn = new KMIPConnection();
		// Connection connection = kconn.connect("localhost", 5000);
		// Connection connection = kconn.connect("169.57.202.148", 5696); //instead of
		// localhost, put IBM SKLM IP address, and instead of "portno", put KMIP port
		// no.
		// Connection connection = kconn.connect(prop.getProperty("IPAddress"),
		// Integer.parseInt(prop.getProperty("Host")));
		KMIPOperations kops = new KMIPOperations();

		//m.setKeyStore("/home/soha/defaultKeyStore", "JCEKS", "passw0rd");
		//connection = kconn.connect("169.57.202.148", 5696);

        //m.mainCreate(buf,connection, kops); //Create KeyConnection connection = kconn.connect(prop.getProperty("IPAddress"), Integer.parseInt(prop.getProperty("Host")));
        //m.mainGet(buf, connection, kops); //Get Key
        //m.mainDestroy(buf, connection, kops); //Destroy Key
        //m.mainLocate(buf, connection, kops);
        //m.locateKey("SymmetricKey");
    }
    
}