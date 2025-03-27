import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+2][M+2];
        boolean[][] visited = new boolean[N+2][M+2];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            arr[y][x] = 1;
        }

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            for(int ii = 1; ii <= M; ii++) {
                if(!visited[i][ii] && arr[i][ii] == 1) {
                    result = 1;
                    dfs(i, ii, visited, arr);
                    list.add(result);
                }
            }
        }

        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list.get(0));
    }

    public static void dfs(int y, int x, boolean[][] visited, int[][] arr) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(!visited[ny][nx] && arr[ny][nx] == 1) {
                dfs(ny, nx, visited, arr);
                result++;
            }
        }
    }
}