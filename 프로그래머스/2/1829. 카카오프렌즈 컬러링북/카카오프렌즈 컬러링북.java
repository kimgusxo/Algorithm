import java.util.*;

class Solution {
    
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    int el = picture[i][j];
                    int size = bfs(el, i, j, picture, visited);
                    if(size > maxSizeOfOneArea) {
                        maxSizeOfOneArea = size;
                    }
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static int bfs(int el, int y, int x, int[][] picture, boolean[][] visited) {
        Queue<Point> queue = new LinkedList<>();
        int size = 1;

        queue.add(new Point(y, x));
        visited[y][x] = true;

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int py = point.y;
            int px = point.x;

            for(int i = 0; i < 4; i++) {
                int ny = py + dy[i];
                int nx = px + dx[i];

                if(ny >= 0 && ny < picture.length && nx >= 0 && nx < picture[0].length) {
                    if(!visited[ny][nx] && picture[ny][nx] == el) {
                        queue.add(new Point(ny, nx));
                        visited[ny][nx] = true;
                        size++;
                    }
                }
            }
        }

        return size;
    }
}

class Point {
    int y;
    int x;
    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}