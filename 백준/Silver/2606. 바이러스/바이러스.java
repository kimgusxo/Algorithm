import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static int bfs(int[][] box, int line, int computer) {
		Queue<Integer> queue = new LinkedList<>();
		int[] result = new int[computer];
		
		int cnt = 0;
		boolean[] visit = new boolean[computer+1];
		
		queue.add(1);
		visit[1] = true;
		
		while(true) {
			int start = queue.remove();
			for(int i = 0; i < line; i++) {
				if(box[i][0] == start && visit[box[i][1]] == false) {
					queue.add(box[i][1]);
					visit[box[i][1]] = true;
					cnt++;
				} else if(box[i][1] == start && visit[box[i][0]] == false) {
					queue.add(box[i][0]);
					visit[box[i][0]] = true;
					cnt++;
				}
			}
			
			if(queue.isEmpty()) break;
			
		}
		return cnt;
	}
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int computer = Integer.parseInt(br.readLine());
    	int line = Integer.parseInt(br.readLine());
    	
    	int[][] box = new int[line][2];
    	
    	for(int i = 0; i < line; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		box[i][0] = Integer.parseInt(st.nextToken());
    		box[i][1] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(box, Comparator.comparingInt((int[] o1) -> o1[0]));
    	
    	int answer = bfs(box, line, computer);
    	
    	System.out.println(answer);
    	
    }
}