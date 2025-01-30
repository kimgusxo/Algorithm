import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	
    public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    	int count = Integer.parseInt(br.readLine());
    	
    	for(int i = 0; i < count; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		StringBuilder sb = new StringBuilder();
    		
    		int iterate = Integer.parseInt(st.nextToken());
    		String str = st.nextToken();
    		
    		for(int j = 0; j < str.length(); j++) {
    			for(int k = 0; k < iterate; k++) {
    				sb.append(str.charAt(j));
    			}
    		}
    		
    		System.out.println(sb.toString());
    	}
    	
    }
}

