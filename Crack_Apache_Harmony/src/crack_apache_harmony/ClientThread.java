package crack_apache_harmony;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Enumeration;

import PRNG.Crack.SHA1PRNG_SecureRandomImpl;
import android.util.Log;

public class ClientThread extends Thread {
	OutputStream os;
	byte[] data;
	byte[] testArray= new byte[20];

	public void run() {
		Log.i("RNG_Test", "test");
		SHA1PRNG_SecureRandomImpl rng = new SHA1PRNG_SecureRandomImpl();
		rng.engineNextBytes(testArray);
		SecureRandom srand = new SecureRandom();
		Log.i("RNG_Info", srand.getProvider().getName());
		Log.i("RNG_Info", srand.getProvider().getInfo());
		Log.i("RNG_Info", srand.getAlgorithm());
		 try {
		      Provider p[] = Security.getProviders();
		      for (int i = 0; i < p.length; i++) {
		          System.out.println(p[i]);
		          for (Enumeration e = p[i].keys(); e.hasMoreElements();)
		              Log.i("SecProv", e.nextElement().toString());
		      }
		    } catch (Exception e) {
		      System.out.println(e);
		    }
//		try {
//			InetAddress serverAddr = InetAddress.getByName("192.168.1.43");
//
//			Socket socket = new Socket(serverAddr, 9000);
//			Log.i("RNG_Test","Started Sending");
//			os = socket.getOutputStream();
//			SHA1PRNG_SecureRandomImpl rng = new SHA1PRNG_SecureRandomImpl();
//			byte[] testArray;
//			for (int i=0;i<30000;i++){
//				
//				testArray = new byte[1000];
//				rng.engineNextBytes(testArray);
//				os.write(testArray);
//				
//				Log.i("RNG_Test","Send "+i+" of 30000");
//			}
//			os.close();
//			socket.close();
//			
//
//		} catch (UnknownHostException e1) {
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}

	}
}
