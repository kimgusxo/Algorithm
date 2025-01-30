import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int start = Integer.parseInt(st.nextToken());
    	int end = Integer.parseInt(st.nextToken());
    	
    	int result = 0;
    	int count = 1;
    	
    	ArrayList<Integer> numList = new ArrayList<>();
    	
    	
    	while(true) {
    		
    		for(int i = 1; i <= count; i++) {
    			numList.add(count);
    		}
    		
    		count++;
    		
    		if(numList.size() > 1000) break;
    	}
    	
    	for(int i = start-1; i <= end-1; i++) {
    		result += numList.get(i);
    	}
    	
    	System.out.print(result);
    	
    }
}