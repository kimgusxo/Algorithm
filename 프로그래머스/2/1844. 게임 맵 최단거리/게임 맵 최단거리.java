import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N = Integer.MAX_VALUE;

    public int solution(int[][] maps) {
        int answer = 0;

        boolean[][] visited = new boolean[maps.length][maps[0].length];
        answer = bfs(maps, visited);

        if(answer == Integer.MAX_VALUE) return -1;
        
        return answer;
    }

    public static int bfs(int[][] maps, boolean[][] visited) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Node n = queue.poll();

            if(n.x == maps.length-1 && n.y == maps[0].length-1) {
                N = Math.min(N, n.level);
            }

            for(int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                int nLevel = n.level+1;
                if(nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new Node(nx, ny, nLevel));
                    visited[nx][ny] = true;
                }
            }
        }

        return N;
    }
}

class Node {
    int x, y, level;
    public Node(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }
}