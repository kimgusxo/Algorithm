import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	static int town = 0;
	
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	
	public static int bfs(int[][] map, boolean[][] visit, int Xpos, int Ypos) {
		
		Queue<Position> queue = new LinkedList<>();
		
		int cnt = 0;
		
		visit[Xpos][Ypos] = true;
		cnt++;
		
		while(true) {
			
			for(int i = 0; i < dx.length; i++) {
				int nextXpos = Xpos + dx[i];
				int nextYpos = Ypos + dy[i];
				
				if(map[nextXpos][nextYpos] == 1 && visit[nextXpos][nextYpos] == false) {
					Position pos = new Position(nextXpos, nextYpos);
					queue.add(pos);
					visit[nextXpos][nextYpos] = true;
				}
			}
			
			if(queue.isEmpty()) break;
			
			Position tempPos = queue.remove();
			
			Xpos = tempPos.Xpos;
			Ypos = tempPos.Ypos;
			
			cnt++;
		}
		
		
		return cnt;
	}
	
	public static void output(int town, PriorityQueue<Integer> prQueue) {
		System.out.println(town);
		
		while(!prQueue.isEmpty()) {
			System.out.println(prQueue.remove());
		}
	}
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    	int width = Integer.parseInt(br.readLine());
    	
    	int[][] map = new int[width+2][width+2];
    	boolean[][] visit = new boolean[map.length][map[0].length];
    	
    	PriorityQueue<Integer> prQueue = new PriorityQueue<>();
    	
    	for(int i = 1; i < map.length-1; i++) {
    		String line = br.readLine();
    		for(int j = 1; j < line.length()+1; j++) {
    			map[i][j] = Character.getNumericValue(line.charAt(j-1));
    		}
    	}
    	
    	for(int i = 1; i < map.length-1; i++) {
    		for(int j = 1; j < map[0].length-1; j++) {
    			if(map[i][j] == 1 && visit[i][j] == false) {
    				prQueue.add(bfs(map, visit, i, j));
    				town++;
    			}
    		}
    	}
    	
    	output(town, prQueue);
    	
    }

}

class Position {
	int Xpos;
	int Ypos;
	
	Position(int Xpos, int Ypos) {
		this.Xpos = Xpos;
		this.Ypos = Ypos;
	}
}