import java.util.Scanner;
import java.util.Collections;
import java.util.PriorityQueue;


public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static int compareLevel = 0;
	
	public static PriorityQueue<Integer> setImportance(int documentCount, int curiousCount, int[] arr) {
		for(int i = 0; i < documentCount; i++) {
			int importance = sc.nextInt();
			arr[i] = importance;
			if(i == curiousCount) {
				compareLevel = i;
			}
		}
		
		PriorityQueue<Integer> prQueue = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0; i < documentCount; i++) {
			prQueue.offer(arr[i]);
		}
		
		return prQueue;
		
	}
	
	public static int findPrintOrder(PriorityQueue<Integer> prQueue, int[] arr) {
		int cnt = 1;
		
		while(!prQueue.isEmpty()) {
			for(int i = 0; i < arr.length; i++) {
				if(prQueue.peek() == arr[i]) {
					if(i == compareLevel) {
						return cnt;
					}
					cnt++;
					prQueue.poll();
				}
			}
		}
		
		return cnt;
	}
	
	public static void main(String[] args) {
		
		int testCase = sc.nextInt();
		
		for(int i = 0; i < testCase; i++) {
			int documentCount = sc.nextInt();
			int curiousCount = sc.nextInt();
			
			int[] arr = new int[documentCount];
					
			System.out.println(findPrintOrder(setImportance(documentCount, curiousCount, arr), arr));
			
		}
		
	}
}