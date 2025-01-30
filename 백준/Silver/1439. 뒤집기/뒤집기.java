import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    	String str = br.readLine();
    	
    	int front = 0;
    	int back = 0;
    	
    	boolean flag = true;
    	
    	for(int i = 1; i < str.length(); i++) {
    		if(str.charAt(i) != str.charAt(i-1)) {
    			if(flag == true) {
    				front++;
    				flag = false;
    			} else {
    				back++;
    				flag = true;
    			}
    		}
    	}
    	
    	if(back > front) {
    		System.out.print(back);
    	} else {
    		System.out.print(front);    		
    	}

    }

}