import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
    	int testCase = sc.nextInt();
    	
    	int count = 0;
    	
    	while(true) {
    		int X = sc.nextInt();
    		int Y = sc.nextInt();
    		
    		int distance = Y-X;
    		
    		System.out.println(calc(distance));
    		count++;
    		
    		if(count == testCase) break; 
    	}
    }
    
    public static int calc(int distance) {
    	
    	int minus = 1;
    	int cnt = 0;
    	
    	while(true) {
    		distance -= minus*2;
    		cnt = cnt+2;
    		
    		if((distance + minus) <= 0) {
    			cnt--;
    			break;
    		} else if(distance <= 0) {
    			break;
    		}
    		minus++;
    	}
    	
    	return cnt;
    }
}