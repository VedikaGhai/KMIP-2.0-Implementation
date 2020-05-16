package com.ibm.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.ibm.model.Key;
import com.ibm.model.KeyPair;
import com.ibm.model.User;

import com.ibm.algorithms.aes;
import com.ibm.algorithms.rsa;

import ClientInterfaces.Connection;
import ClientInterfaces.MainApplication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TestController {

	private List<User> employees = createList();
	
	MainApplication mainObject = new MainApplication();
	
	public void getConnection() throws IOException {
		mainObject.setKeyStore("C:/Users/A/defaultKeyStore", "JCEKS", "passw0rd");
		Connection connection = mainObject.getConnection("169.57.202.148", 5696);
		
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
	public List<User> firstPage() {
		return employees;
	}

	@PostMapping(path = { "/createkey" })
	public Key create(@RequestBody Key key) throws Exception {
		
		System.out.println(key.getTypeOfKey()+" "+key.getAlgorithm()+" "+key.getKeySize()+" "+key.getUniqueIdentifier());

		//pass these parameters to the create key function
		//add unique identifier to the object
		//return the same object
		//key.setUniqueIdentifier("ThisIsUniqueIdentifier");
		getConnection();
		List<String> uuid = mainObject.createKey(key.getAlgorithm(), key.getKeySize(), key.getTypeOfKey());
		key.setUniqueIdentifier(uuid.get(0));
		//System.out.println(key.getTypeOfKey()+" "+key.getAlgorithm()+" "+key.getKeySize()+" "+key.getUniqueIdentifier());
		System.out.println(uuid);
		return key;
	}

	@PostMapping(path = { "/createkeypair" })
	public KeyPair createKeyPair(@RequestBody KeyPair keyPair) throws Exception {
		
		System.out.println(keyPair.getTypeOfKey()+" "+keyPair.getAlgorithm()+" "+keyPair.getKeySize()+" "+keyPair.getPrivateKeyUniqueIdentifier()+" "+keyPair.getPublicKeyUniqueIdentifier()+" "+keyPair.getPrivateKeyNameValue()+" "+keyPair.getPublicKeyNameValue());

		//pass these parameters to the create key function
		//add unique identifier to the object
		//return the same object
		//keyPair.setPrivateKeyUniqueIdentifier("ThisIsPrivateKeyUniqueIdentifier");
		//keyPair.setPublicKeyUniqueIdentifier("ThisIsPublicKeyUniqueIdentifier");
		getConnection();
		List<String> uuid = mainObject.createKeyPair(keyPair.getAlgorithm(), keyPair.getKeySize(), keyPair.getTypeOfKey(), keyPair.getPrivateKeyNameValue(), keyPair.getPublicKeyNameValue());
		keyPair.setPrivateKeyUniqueIdentifier(uuid.get(0));
		keyPair.setPublicKeyUniqueIdentifier(uuid.get(1));
		//System.out.println(keyPair.getTypeOfKey()+" "+keyPair.getAlgorithm()+" "+keyPair.getKeySize()+" "+keyPair.getPrivateKeyUniqueIdentifier()+" "+keyPair.getPublicKeyUniqueIdentifier()+" "+keyPair.getPrivateKeyNameValue()+" "+keyPair.getPublicKeyNameValue());
		System.out.println(uuid);
		return keyPair;
	}

	@PostMapping(path = { "/getkey" })
	public List<String> get(@RequestBody Key key) throws Exception {
		//get key by passing uniqueIdentifier
		System.out.println(key.getUniqueIdentifier());
		/*List<String> keyBlock = new ArrayList<String>();
		keyBlock.add("ThisIsKey");
		keyBlock.add("ThisIsKeyMaterial");
		keyBlock.add("ThisIsKeyFormatType");
		keyBlock.add("ThisIsObjectType");*/
		getConnection();
		List<String> keyBlock = mainObject.getKey(key.getUniqueIdentifier());
		System.out.println(keyBlock);
		//keyBlock.add(0, "Key Unique Identifier : "+keyBlock.get(0));
		//keyBlock.add(1, "Key Format Type : "+keyBlock.get(1));
		//keyBlock.add(2, "Key Material : "+keyBlock.get(2));
		//keyBlock.add(3, "Object Type : "+keyBlock.get(3));
		return keyBlock;
	}
	
	@PostMapping(path = { "/destroykey" })
	public List<String> destroy(@RequestBody Key key) throws Exception {
		//get result status by passing unique identifier
		System.out.println(key.getUniqueIdentifier());
		//String ResultStatus = "ThisIsResultStatus";
		getConnection();
		List<String> ResultStatus = mainObject.destroyKey(key.getUniqueIdentifier());
		System.out.println(ResultStatus);
		return ResultStatus;
	}

	@PostMapping(path = { "/locatekey" })
	public List<String> locate(@RequestParam("ObjectType") String ObjectType) throws Exception {
		//get result status by passing unique identifier
		System.out.println(ObjectType);
		//List<String> UniqueIdentifiers = new ArrayList<String>();
		//UniqueIdentifiers.add("UUID1");
		//UniqueIdentifiers.add("UUID2");
		getConnection();
		List<String> UniqueIdentifiers = mainObject.locateKey(ObjectType);
		System.out.println(UniqueIdentifiers);
		return UniqueIdentifiers;
	}

	@PostMapping(path = { "/encrypt" })
	public String encrypt(@RequestParam("plaintextFile") MultipartFile file, @RequestParam("uniqueIdentifier") String uniqueIdentifier) throws Exception {
		//String plaintext = file.getBytes().toString();
		//System.out.println(plaintext);
		//System.out.println(uniqueIdentifier);
		
		//convert multipart to file and read content
		String fileName = "D:/"+"encrypted-"+file.getOriginalFilename();
		File ciphertext =  new File(fileName);
		file.transferTo(ciphertext);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(ciphertext));
		String fileContent="";
		String i; 
		while ((i = bufferedReader.readLine()) != null){
			fileContent+=i;
		} 
		System.out.println(fileContent);
		
		//consider value of key for now
		//String secretKey = "30820122300D06092A864886F70D01010105000382010F003082010A02820101008F2613A05EE5132FBE1B28447FAE2B37D6B7C3D75CB4CEF67E229FE9C4D019D998E30F44AD4F767E477BEB632AEB38A5EC9D5897327FABD81E8B45F35536D399635C12F95008C5996B393533B471D432742E75C4F58B8F3398B8FF4CD0752CD368F410EA41EB435BD9ADA7E4825EA25FF31BCFCE12B4C07D0306B86C52721328F804A0C548A39972F346C1A4DDEA3B760C74FD510F0F92275384B92EFF3D5846352C74CA644EC30194353D18853BE7B2BC49FA957E29C2B84CC32E4048BDFDD99C7F4A2A6E5AD8D02D8F1BA4909419ACC9DEDDE84B5B4B49AD575815E2F1A186FCAC9E3FD3BCB5825AD4796FACA97A42B8D61101C6DA4F9C6375C5C3FA6C599D0203010001";
		String SymmetricKeyObjectType = "SymmetricKey";
		String PublicKeyObjectType = "PublicKey";
		//String ObjectType = "PublicKey";
		String encryptedText = "";
		getConnection();
		List<String> keyBlock = mainObject.getKey(uniqueIdentifier);
		String secretKey = keyBlock.get(2);
		String ObjectType = keyBlock.get(3);

		if(ObjectType.equals(SymmetricKeyObjectType))
		{
			aes aesAlgo = new aes();
			encryptedText = aesAlgo.encrypt(fileContent, secretKey);
			System.out.println(encryptedText);
			return encryptedText;
		}
		else if(ObjectType.equals(PublicKeyObjectType))
		{
			rsa rsaAlgo = new rsa();
			encryptedText = rsaAlgo.encrypt(fileContent, secretKey);
			System.out.println(encryptedText);
		}

		//WRITE TO FILE NOT WORKING
		//FileWriter fileWriter = new FileWriter(ciphertext);
		//fileWriter.write(encryptedText);
		//BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		//bufferedWriter.write(encryptedText);

		return encryptedText;

	}

	@PostMapping(path = { "/decrypt" })
	public String decrypt(@RequestParam("ciphertextFile") MultipartFile file, @RequestParam("uniqueIdentifier") String uniqueIdentifier) throws Exception {
		//String plaintext = file.getBytes().toString();
		//System.out.println(plaintext);
		//System.out.println(uniqueIdentifier);
		
		//convert multipart to file and read content
		String fileName = "D:/"+"decrypted-"+file.getOriginalFilename();
		File plaintext =  new File(fileName);
		file.transferTo(plaintext);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(plaintext));
		String fileContent="";
		String i; 
		while ((i = bufferedReader.readLine()) != null){
			fileContent+=i;
		} 
		System.out.println(fileContent);
		
		//consider value of key for now
		//String secretKey = "308204BC020100300D06092A864886F70D0101010500048204A6308204A202010002820101008F2613A05EE5132FBE1B28447FAE2B37D6B7C3D75CB4CEF67E229FE9C4D019D998E30F44AD4F767E477BEB632AEB38A5EC9D5897327FABD81E8B45F35536D399635C12F95008C5996B393533B471D432742E75C4F58B8F3398B8FF4CD0752CD368F410EA41EB435BD9ADA7E4825EA25FF31BCFCE12B4C07D0306B86C52721328F804A0C548A39972F346C1A4DDEA3B760C74FD510F0F92275384B92EFF3D5846352C74CA644EC30194353D18853BE7B2BC49FA957E29C2B84CC32E4048BDFDD99C7F4A2A6E5AD8D02D8F1BA4909419ACC9DEDDE84B5B4B49AD575815E2F1A186FCAC9E3FD3BCB5825AD4796FACA97A42B8D61101C6DA4F9C6375C5C3FA6C599D02030100010282010031E6B624CBAFD3766B3110628097F89CE88EFB08525AFD62D429C1D13E38C52A23AFD39CBF45DA2ABF44A593D65C554D1224EFC31569884038B59856F137C19FD11141D403606B71C5FD155CC6E47F726F29DB082408D88CC60A8785018E3768234821B567F15973E57831F4E8B590A91E186DE28A86D42B4028D19581501EF93CB4FEFC669C2CF0366C1EC600582CCDA8BDBD522DA9721B1E974986BDCE1D477BA39CBF742DD9F34ED7426C8E81469C985F1F02945DCEC9132146567F09720AF48973B38D14067FA10E1BB80D13053CA4420EC34C617D91F368F060898AAA2E548CCFA8A07806E2F4DB8335D2FB32BCF73BC9E7E841D6321F75E33A5594AF8902818100D8566B2C9D90F13F008825BF49329553FF77D49BB1C3E89EFA7CDD9EAF03E2FE3A24226ADF7A15CE93FCC6533D1F5E7675A8940C991A92AC75A8219AE8A002232E633BA8317DE3DC141D80D1666E9C7089FA8307428D6A9B533566E0F449B8D83DD752DF4F554833D12BD71E13DBE7C47235508CCC41076DDC48D5084E239E8302818100A9649D85C7C65A57D017F2ABA8980964924BBB2471C2CD2321D9B656BF488D0A907A8BC16BFC1E4B4ECF2F87429F67430E2E371DD8422320AEF0FD7436802D031D226573AF2F9CF31E4997B53CB68D37D71CF41C18C63C7009E9F64CC74434B0768015F4A6E8D5BB0DE67CC9B1E44CD0DC47969E81282583334A9511E6B2AD5F02818020B5A84CBDA22DA7BDF7D7E53D3705B7069862B00BC7B843595249DBF5505C20DE3F9A689853883A8CCB9A5CF98FE5A37994BC95CF0C6282EAE339F98714B25E09647D9FA7A40630BF65DA954EAC88C0C74BF645C1BD4A1224199DED8362262DA3E40BA6B2030E00AFAEB63ED8F7D5EA30EE78B86125AFEEDF70AFAD2ACB5DEB0281805DEE2A1F45F12AA5A901AE921B91FB1B66B851D4DAB44FB65C8DF23B5624AFF91CB6A78AA10B93ECE48DA4E8573C37318ACA7BCBB3E0B0C3EDDE3A5D57DF69966170725B5CD8852A972FEDCD1516916656857AA39DE5471C459313FDED3D580E4617AE95147CE60FAC9C93B3F04E0D7E7FB7BEC0B414040125CF04AC8185B0F70281806CB961439C636501EBE761E6620ED3B4EBE497C969A7056D371BC08BB83463395561933206B593644BC7B19130469C80F021380EB54439E8EA025DD33A793D62F17E29A83A848B6AF8085B613D7219BC4E1E0945E996247FA42F452DB39B97F273CD5183E128260E3654DB8ECC261106A881CCC06E8626B9EE87B5AADAFD84AC";
		String SymmetricKeyObjectType = "SymmetricKey";
		String PrivateKeyObjectType = "PrivateKey";
		//String ObjectType = "PrivateKey";
		String decryptedText = "";
		getConnection();
		List<String> keyBlock = mainObject.getKey(uniqueIdentifier);
		String secretKey = keyBlock.get(2);
		String ObjectType = keyBlock.get(3);

		if(ObjectType.equals(SymmetricKeyObjectType))
		{
			aes aesAlgo = new aes();
			decryptedText = aesAlgo.decrypt(fileContent, secretKey);
			System.out.println(decryptedText);	
		}
		else if (ObjectType.equals(PrivateKeyObjectType))
		{
			rsa rsaAlgo = new rsa();
			decryptedText = rsaAlgo.decrypt(fileContent, secretKey);
			System.out.println(decryptedText);
		}	

		//WRITE TO FILE NOT WORKING
		//FileWriter fileWriter = new FileWriter(ciphertext);
		//fileWriter.write(encryptedText);
		//BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		//bufferedWriter.write(encryptedText);

		return decryptedText;
	}

	private static List<User> createList() {
		List<User> tempUsers = new ArrayList<User>();

		User user1 = new User();
		user1.setUserName("user1");
		user1.setPassword("password1");
		
		User user2 = new User();
		user2.setUserName("user2");
		user2.setPassword("password2");
		
		tempUsers.add(user1);
		tempUsers.add(user2);

		//System.out.println(tempEmployees);
		return tempUsers;
	}

}

