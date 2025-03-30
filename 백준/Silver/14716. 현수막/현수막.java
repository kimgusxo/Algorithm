import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static int word = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+2][M+2];
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    dfs(i, j, arr, visited);
                }
            }
        }

        System.out.println(word);

    }

    public static void dfs(int y, int x, int[][] arr, boolean[][] visited) {
        Stack<Pos> stack = new Stack<>();

        stack.push(new Pos(y, x));
        visited[y][x] = true;

        while(!stack.isEmpty()) {
            Pos pos = stack.pop();
            int py = pos.y;
            int px = pos.x;

            for(int i = 0; i < 8; i++) {
                int ny = py + dy[i];
                int nx = px + dx[i];

                if(!visited[ny][nx] && arr[ny][nx] == 1) {
                    stack.push(new Pos(ny, nx));
                    visited[ny][nx] = true;
                }
            }
        }

        word++;
    }
}

class Pos {
    int y;
    int x;

    public Pos(int y, int x) {
        this.y = y;
        this.x = x;
    }
}