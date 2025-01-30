import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    	String str = br.readLine();
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0; i < str.length(); i++) {
    		if(str.charAt(i) > 'C') {
    			char ch = (char) (str.charAt(i)-3);
    			sb.append(ch);
    		} else {
    			char ch = (char) (str.charAt(i)+23);
    			sb.append(ch);
    		}
    	}
    	
    	System.out.println(sb.toString());
    	
    }
}