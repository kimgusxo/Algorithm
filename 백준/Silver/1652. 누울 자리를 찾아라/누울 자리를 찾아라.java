import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	
    public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    	int width = Integer.parseInt(br.readLine());
    	
    	char[][] cBox = new char[width][width];
    	
    	for(int i = 0; i < width; i++) {
    		String line = br.readLine();
    		for(int j = 0; j < width; j++) {
    			cBox[i][j] = line.charAt(j);
    		}
    	}
    	
    	int widthCount = 0;
    	int heightCount = 0;
    	
    	for(int i = 0; i < width; i++) {
    		int count = 1;
    		for(int j = 0; j < width-1; j++) {
    			if(cBox[i][j] == '.') {
    				if(cBox[i][j+1] == '.') {
    					count++;
    				}
    			} else {
    				if(count >= 2) {
    					widthCount++;
    				}
    				count = 1;
    			}
    		}
    		if(count >= 2) {
    			widthCount++;
    		}
    	}
    	
    	for(int i = 0; i < width; i++) {
    		int count = 1;
    		for(int j = 0; j < width-1; j++) {
    			if(cBox[j][i] == '.') {
    				if(cBox[j+1][i] == '.') {
    					count++;
    				}
    			} else {
    				if(count >= 2) {
    					heightCount++;
    				}
    				count = 1;
    			}
    		}
    		if(count >= 2) {
    			heightCount++;
    		}
    	}
    	
    	System.out.println(widthCount + " " + heightCount);

    }
}

