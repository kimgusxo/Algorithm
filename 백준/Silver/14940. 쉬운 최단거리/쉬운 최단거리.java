import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        int[][] result = new int[N][M];

        int startX = 0, startY = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;

                if(x == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        boolean[][] visited = new boolean[map.length][map[0].length];

        bfs(startX, startY, map, result, visited);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int el = result[i][j];
                if(!visited[i][j] && map[i][j] == 1) {
                    el = -1;
                }
                System.out.print(el + " ");
            }
            System.out.println();
        }

    }

    public static void bfs(int startX, int startY, int[][] map, int[][] result, boolean[][] visited) {
        Queue<Pos> queue = new LinkedList<>();

        queue.add(new Pos(startX, startY, 0));
        visited[startX][startY] = true;
        result[startX][startY] = 0;

        while(!queue.isEmpty()) {
            Pos pos = queue.poll();

            int x = pos.x;
            int y = pos.y;
            int level = pos.level;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nlevel = level+1;

                if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && !visited[nx][ny] && map[nx][ny] != 0 ) {
                    visited[nx][ny] = true;
                    result[nx][ny] = nlevel;
                    queue.add(new Pos(nx, ny, nlevel));
                }
            }
        }

    }
}

class Pos {
    int x, y, level;

    public Pos(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }
}