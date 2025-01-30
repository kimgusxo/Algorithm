import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    	int number = Integer.parseInt(br.readLine());
    
    	for(int i = 0; i < number; i++) {
    		int count = Integer.parseInt(br.readLine());
        	
        	boolean flag = false;
        	
        	String[] sBox = new String[count];
        	
    		for(int j = 0; j < count; j++) {
    			String phoneNumber = br.readLine();
    			
    			sBox[j] = phoneNumber;
    		}
    		
    		Arrays.sort(sBox);
    		
    		for(int j = 0; j < count-1; j++) {
    			if(sBox[j].length() < sBox[j+1].length()) {
    				if(sBox[j].equals(sBox[j+1].substring(0, sBox[j].length()))) {
    					flag = true;
    				}
    			}
    		}
    		
    		if(flag == true) {
    			System.out.println("NO");
    		} else {
    			System.out.println("YES");
    		}
    	}
    	
    }
}