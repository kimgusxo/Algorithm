import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int size = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            boolean[][] visited = new boolean[size][size];

            System.out.println(bfs(x1 ,y1, x2, y2, size, visited));
        }
    }

    public static int bfs(int x1, int  y1, int x2, int y2, int size, boolean[][] visited) {
        Queue<Knight> queue = new LinkedList<>();
        int level = 0;
        visited[x1][y1] = true;
        queue.add(new Knight(x1, y1, level));

        while(!queue.isEmpty()) {
            Knight cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            level = cur.level;

            if(x == x2 && y == y2) {
                return level;
            }

            level++;

            for(int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if((newX >= 0 && newX < size && newY >= 0 && newY < size) && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new Knight(newX, newY, level));
                }
            }
        }
        return level;
    }
}

class Knight {
    int x;
    int y;
    int level;

    public Knight(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }
}