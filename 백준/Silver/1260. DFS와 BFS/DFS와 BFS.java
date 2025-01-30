import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void reset(boolean[] visit) {
		for(int i = 0; i < visit.length; i++) {
			visit[i] = false;
		}
	}
	
	public static int[] dfs(int[][] dfsBox, boolean[] visit, int point, int line, int start) {
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[point];
		
		visit[start] = true;
		
		int pos = 0;
		
		result[pos] = start;
		
		while(true) {
			
			for(int i = 0; i < dfsBox.length; i++) {
				if(dfsBox[i][0] == start && visit[dfsBox[i][1]] == false) {
					stack.push(dfsBox[i][1]);
				} else if(dfsBox[i][1] == start && visit[dfsBox[i][0]] == false) {
					stack.push(dfsBox[i][0]);
				}
			}
			
			if(stack.isEmpty()) break;
			
			start = stack.pop();
			visit[start] = true;
			
			pos++;
			
			for(int i = 0; i < result.length; i++) {
				if(start == result[i]) {
					start = stack.pop();
					i = 0;
				}
			}
			
			result[pos] = start;
			
			if(pos == (point-1) || pos == line) break;
		}
		
		return result;
	}
	
	public static int[] bfs(int[][] bfsBox, boolean[] visit, int point, int line, int start) {
		Queue<Integer> queue = new LinkedList<>();
		int[] result = new int[point];
		
		visit[start] = true;
		
		int pos = 0;
		
		result[pos] = start;
		
		while(true) {
			
			for(int i = 0; i < bfsBox.length; i++) {
				if(bfsBox[i][0] == start && visit[bfsBox[i][1]] == false) {
					queue.add(bfsBox[i][1]);
					visit[bfsBox[i][1]] = true;
				} else if(bfsBox[i][1] == start && visit[bfsBox[i][0]] == false) {
					queue.add(bfsBox[i][0]);
					visit[bfsBox[i][0]] = true;
				}
			}
			
			if(queue.isEmpty()) break;
			
			start = queue.remove();
			
			pos++;
			
			result[pos] = start; 
			
			if(pos == (point-1) || pos == line) break;
		}
		
		return result;
		
	}
	
	public static void output(int[] result) {
		for(int i = 0; i < result.length; i++) {
			if(result[i] == 0) break;
			System.out.print(result[i] + " ");
		}
		
		System.out.println();
	}
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st1 = new StringTokenizer(br.readLine());
    	
    	int point = Integer.parseInt(st1.nextToken());
    	int line = Integer.parseInt(st1.nextToken());
    	int start = Integer.parseInt(st1.nextToken());
    	
    	int[][] box = new int[line][2];
    	boolean visit[] = new boolean[point+1];
    	
    	for(int i = 0; i < line; i++) {
    		StringTokenizer st2 = new StringTokenizer(br.readLine());
    		
    		int element1 = Integer.parseInt(st2.nextToken());
    		int element2 = Integer.parseInt(st2.nextToken());
    		
    		if(element1 < element2) {
    			box[i][0] = element1;
    			box[i][1] = element2;
    		} else {
    			box[i][0] = element2;
    			box[i][1] = element1;
    		}
    	}
    	
    	int[][] dfsBox = new int[line][2];
    	int[][] bfsBox = new int[line][2];
    	
    	System.arraycopy(box, 0, dfsBox, 0, box.length);
    	System.arraycopy(box, 0, bfsBox, 0, box.length);
    	
    	Arrays.sort(dfsBox, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt((int[] o) -> o[1]).reversed()); 
    	Arrays.sort(bfsBox, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt((int[] o) -> o[1]));
    	
    	output(dfs(dfsBox, visit, point, line, start));
    	
    	reset(visit);
    	
    	output(bfs(bfsBox, visit, point, line, start));
    	
    }
}