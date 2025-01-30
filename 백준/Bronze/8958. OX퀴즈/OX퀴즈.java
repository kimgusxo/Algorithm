import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    	int number = Integer.parseInt(br.readLine());
    	
    	for(int i = 0; i < number; i++) {
    		String str = br.readLine();
    		
    		boolean flag = false;
    		int count = 1;
    		int result = 0;
    		
    		for(int j = 0; j < str.length(); j++) {
    			if(str.charAt(j) == 'O') {
    				result += count;
    				count++;
    			} else if(str.charAt(j) == 'X') {
    				count = 1;
    			}
    		}
    		
    		System.out.println(result);
    			
    	}
    	
    	
    }
}