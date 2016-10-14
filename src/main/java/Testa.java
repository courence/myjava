import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class Testa {
	public static char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static void main(String[] args) throws Exception {
		String fileName = "/home/jh/downloads/patch2.0.610.tw2";

		String hashType = "MD5";
		System.out.println(new java.util.Date());
		String str1 = getHash(fileName, hashType);
		System.out.println(hashType + " == " + str1);
		System.out.println(new java.util.Date());
		
		FileOutputStream out = new FileOutputStream(new File("/home/jh/downloads/patch2.0.610.tw2.sig"));   


            out.write(str1.getBytes());   



        out.close();

		

	}

	public static String getHash(String fileName, String hashType)
			throws Exception {
		InputStream fis;
		fis = new FileInputStream(fileName);
		byte[] buffer = new byte[1024];
		MessageDigest md5 = MessageDigest.getInstance(hashType);

		int numRead = 0;
		while ((numRead = fis.read(buffer)) > 0) {
			md5.update(buffer, 0, numRead);
		}
		fis.close();
		return toHexString(md5.digest());
	}

	public static void readFile(String fileName) throws Exception {
		InputStream fis;
		fis = new FileInputStream(fileName);
		byte[] buffer = new byte[1024];
		while ((fis.read(buffer)) > 0) {

		}
		fis.close();
		return;
	}

	public static String toHexString(byte[] b) {
		StringBuilder sb = new StringBuilder(b.length * 2);
		for (int i = 0; i < b.length; i++) {
			sb.append(hexChar[(b[i] & 0xf0) >>> 4]);
			sb.append(hexChar[b[i] & 0x0f]);
		}
		return sb.toString();
	}
}
