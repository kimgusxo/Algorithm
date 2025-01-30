import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int sound = Integer.parseInt(st.nextToken());
    	int see = Integer.parseInt(st.nextToken());
    
    	
    	String[] sBox = new String[sound+see];
    	
    	for(int i = 0; i < (sound+see); i++) {
    		sBox[i] = br.readLine();
    	}
    	
    	Arrays.sort(sBox);
    
    	int count = 0;
    	
    	ArrayList<String> strList = new ArrayList<>();
    	
    	for(int i = 0; i < (sound+see)-1; i++) {
    		if(sBox[i].equals(sBox[i+1])) {
    			strList.add(sBox[i]);
    			count++;
    		}
    	}
    	
    	System.out.println(count);
    	
    	for(int i = 0; i < count; i++) {
    		System.out.println(strList.get(i));
    	}
    	
    }
}