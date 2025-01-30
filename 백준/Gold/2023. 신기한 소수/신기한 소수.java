import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int ten = 10;
	
	public static Queue<Integer> calcResult(Queue<Integer> queue, int range) {
		Queue<Integer> resultQueue = new LinkedList<>();
		
		queue.add(2);
		queue.add(3);
		queue.add(5);
		queue.add(7);
		
		while(true) {
			
			if(queue.peek()*10 > range) break;
			
			int result = queue.remove();
			
			for(int i = result*ten; i < (result*ten)+ten; i++) {
				
				boolean flag = true;
				
				for(int j = 2; j < (int)Math.sqrt(i) + 1; j++) {
					if(i%j == 0) {
						flag = false;
						break;
					}
				}
				
				if(flag == true) {
					queue.add(i);
				}
			}
		}
		
		resultQueue.addAll(queue);
		
		return resultQueue;
	}
	
	public static void output(Queue<Integer> resultQueue) {
		while(!resultQueue.isEmpty()) {
			System.out.println(resultQueue.remove());
		}
	}
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int cipher = Integer.parseInt(br.readLine());
    	int range = (int) Math.pow(10, cipher);
    	
    	Queue<Integer> queue = new LinkedList<>();
    	
    	output(calcResult(queue, range));
    	
    }
}