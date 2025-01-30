import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static int searchMax(Queue<Integer> arrList) {
		
		int count = 1;
	
		Deque<Integer> resultQueue = new ArrayDeque<>();
		
		resultQueue.add(arrList.remove());
		
		while(!arrList.isEmpty()) {
			for(int j = 0; j < count; j++) {
				int num = resultQueue.poll();
				int result1 = 0;
				int result2 = 0;
				
				if(j < (count-1)) {
					result1 = num + arrList.poll();
					result2 = num + arrList.peek();
					
					if(j != 0) {
						if(resultQueue.peekLast() >= result1) {
							resultQueue.add(result2);
						} else {
							resultQueue.pollLast();
							resultQueue.add(result1);
							resultQueue.add(result2);
						}
					} else {
						resultQueue.add(result1);
						resultQueue.add(result2);
					}
					
				} else {
					result1 = num + arrList.poll();
					result2 = num + arrList.poll();
			
					if(!resultQueue.isEmpty()) {
						if(resultQueue.peekLast() >= result1) {
							resultQueue.add(result2);
						} else {
							resultQueue.pollLast();
							resultQueue.add(result1);
							resultQueue.add(result2);
						}
					} else {
						resultQueue.add(result1);
						resultQueue.add(result2);
					}
				}
			}
			count++;
		}
		
		PriorityQueue<Integer> prQueue = new PriorityQueue<>(Collections.reverseOrder());
		
		while(!resultQueue.isEmpty()) {
			prQueue.add(resultQueue.poll());
		}
		
		return prQueue.peek();
	}
	
    public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int line = Integer.parseInt(br.readLine());
    	
    	Queue<Integer> arrList = new LinkedList<>();
    	
    	for(int i = 0; i < line; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j <= i; j++) {
    			arrList.add(Integer.parseInt(st.nextToken()));
    		}
    	}
    	
    	System.out.println(searchMax(arrList));
    	
    }
}