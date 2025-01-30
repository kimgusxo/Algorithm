import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
    	int caseNum = sc.nextInt();
    	
    	PriorityQueue<Integer> prQueue = new PriorityQueue<>();
    	
    	for(int i = 0; i < caseNum; i++) {
    		prQueue.add(sc.nextInt());
    	}
    
    	int sum = 0;
    	
    	if(prQueue.size() > 1) {
    		while(true) {
    			int next = prQueue.remove() + prQueue.remove();
    			sum += next;
    			prQueue.add(next);
    		
    			if(prQueue.size() <= 1) break;
    		}
    	} else if(prQueue.size() == 1) {
    		sum = 0;
    	}
    	
    	System.out.println(sum);
    }
}