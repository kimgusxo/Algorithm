import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	
	public static int bfs(int[][] map) {
		boolean[][] visit = new boolean[map.length][map[0].length];
		
		Queue<Position> posQueue = new LinkedList<>();
		Stack<Position> stack = new Stack<>();
		
		int Xpos = 1;
		int Ypos = 1;
		
		visit[Xpos][Ypos] = true;
		int level = 1;
		
		while(true) {
			for(int i = 0; i < dx.length; i++) {
				
				int nextXpos = Xpos + dx[i];
				int nextYpos = Ypos + dy[i];
				
				if(map[nextXpos][nextYpos] == 1 && visit[nextXpos][nextYpos] == false) {
					Position pos = new Position(nextXpos, nextYpos, level);
					visit[nextXpos][nextYpos] = true;
					posQueue.add(pos);
				}
			}
			
			Position result = posQueue.remove();
			stack.push(result);
			
			Xpos = result.x;
			Ypos = result.y;
			level = result.level+1;
			
			
			if(Xpos == map.length-2 && Ypos == map[0].length-2) break;
			
		}
		
		return stack.pop().level+1;
		
	}
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int height = Integer.parseInt(st.nextToken()) + 2;
    	int width = Integer.parseInt(st.nextToken()) + 2;
    
    	int[][] map = new int[height][width];
    	
    	for(int i = 1; i < height-1; i++) {
    		String line = br.readLine();
    		for(int j = 1; j < width-1; j++) {
    			map[i][j]= Character.getNumericValue(line.charAt(j-1));
    		}
    	}
    	
    	System.out.println(bfs(map));
    	
    }
}

class Position {
	int x;
	int y;
	int level;
	
	public Position(int x, int y, int level) {
		this.x = x;
		this.y = y;
		this.level = level;
	}
}