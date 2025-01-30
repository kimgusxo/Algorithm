import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	
	static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 1, 0, -1, 1, -1, 1, -1 };

	public static void bfs(boolean[][] visit, int[][] map, int Xpos, int Ypos) {
		Queue<Position> queue = new LinkedList<>();
		
		while(true) {
			
			for(int i = 0; i < dx.length; i++) {
				int X = Xpos + dx[i];
				int Y = Ypos + dy[i];
				
				if(map[X][Y] == 1 && visit[X][Y] == false) {
					Position pos = new Position(X, Y);
					queue.add(pos);
					visit[X][Y] = true;
				}
			}
			
			if(queue.isEmpty()) break;
			
			Position pos = queue.remove();
			
			Xpos = pos.X;
			Ypos = pos.Y;
		}
		
	}
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    	while(true) {
    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		
    		int height = Integer.parseInt(st.nextToken());
    		int width = Integer.parseInt(st.nextToken());
    		
    		if(width == 0 && height == 0) break;
    		
    		int landCount = 0;
    		
    		int[][] map = new int[width+2][height+2];
    		
    		for(int i = 1; i < map.length-1; i++) {
    			st = new StringTokenizer(br.readLine());
    			for(int j = 1; j < map[0].length-1; j++) {
    				map[i][j] = Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		boolean[][] visit = new boolean[map.length][map[0].length];
    		
    		for(int i = 1; i < map.length-1; i++) {
    			for(int j = 1; j < map[0].length-1; j++) {
    				if(visit[i][j] == false && map[i][j] == 1) {
    					bfs(visit, map, i, j);
    					landCount++;
    				}
    			}
    		}
    		
    		System.out.println(landCount);
    		
    	}
    }
}

class Position {
	int X;
	int Y;
	
	Position(int X, int Y) {
		this.X = X;
		this.Y = Y;
	}
}