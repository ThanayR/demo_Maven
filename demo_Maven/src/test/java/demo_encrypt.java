import resources.util.Library;

public class demo_encrypt extends Library {
	public static void main(String[] args) {
		String originalStr = "SLK Software";
		System.out.println("Original String: " + originalStr);
		
		String encyptStr = strEncrypt(originalStr);
		System.out.println("Encrypted String: " + encyptStr);		

		String decyptStr = strDecrypt(encyptStr);
		System.out.println("Decrypted String: " + decyptStr);
	}

}
