import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
    	long num = sc.nextLong();
    	
    	long result = 0;
    	
    	long minus = 1;
    	
    	if(num < 1) {
    		result = num;
    	} else {
    		while(true) {
    			num = num - minus;
    			if(num <= minus) break;
    			minus++;
    		}
    		result = minus;
    	}
    	
    	System.out.print(result);
    	
    }
}