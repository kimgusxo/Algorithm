import java.util.*;

class Solution {

    static int path1 = 0;
    static int path2 = 0;
    
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    
    public int solution(String[] maps) {
        int answer = 0;
        
        int sx = 0, sy = 0, lx = 0, ly = 0, ex = 0, ey = 0;
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                if(maps[i].charAt(j) == 'S') {
                    sx = i;
                    sy = j;
                } else if(maps[i].charAt(j) == 'L') {
                    lx = i;
                    ly = j;
                } else if(maps[i].charAt(j) == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        }
        
        int path1 = bfs(maps, sx, sy, lx, ly);
        int path2 = bfs(maps, lx, ly, ex, ey);
        
        if(path1 != -1 && path2 != -1) {
            return path1+path2;
        } else {
            return -1;
        }
    }
    
    public static int bfs(String[] maps, int x, int y, int zx, int zy) {
        int depth = -1;
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Deque<Node> queue = new ArrayDeque<>();
        
        queue.offer(new Node(0, x, y));
        
        while(!queue.isEmpty()) {
            Node n = queue.poll();
            
            if(n.x == zx && n.y == zy) {
                depth = n.depth;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                
                if(nx >= 0 && nx < maps.length &&
                   ny >= 0 && ny < maps[0].length() &&
                   !visited[nx][ny]) {
                    if(maps[nx].charAt(ny) != 'X') {
                        visited[nx][ny] = true;
                        queue.offer(new Node(n.depth+1, nx, ny));
                    }
                }
            }
        }
        
        return depth;
    }
}

class Node {
    int depth;
    int x;
    int y;
    
    public Node(int depth, int x, int y) {
        this.depth = depth;
        this.x = x;
        this.y = y;
    }
}