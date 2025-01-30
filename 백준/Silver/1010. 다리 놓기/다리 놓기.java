import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
    	int testCase = sc.nextInt();
    	
    	int count = 0;
    	
    	while(true) {
    		int up = sc.nextInt();
    		int down = sc.nextInt();
    		
    		System.out.println(calc(up, down));
    		count++;
    		
    		if(count == testCase) break; 
    	}
    }
    
    public static int calc(int up, int down) {
    	
    	double result = 1;
    	long numerator = 0;
		long denominator = 0;
    	
    	for(int i = 0; i < up; i++) {
    		numerator = down-i;
    		denominator = up-i;
    		
    		result *= numerator;
    		result /= denominator;
    	}
    	
    	int sum = (int)Math.round(result);
    	
    	return sum;
    }
}