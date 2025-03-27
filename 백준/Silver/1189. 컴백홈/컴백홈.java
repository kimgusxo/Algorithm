import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[R][C];
        boolean[][] visited = new boolean[R][C];

        for(int i = 0; i < R; i++) {
            String line = br.readLine();
            for(int j = 0; j < C; j++){
                char c = line.charAt(j);
                if(c == '.') {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = -1;
                }
            }
        }

        dfs(0, R-1, arr, visited, 0, K);

        System.out.println(result);
    }

    public static void dfs(int x, int y, int[][] arr, boolean[][] visited, int distance, int K) {

        visited[y][x] = true;
        distance++;

        if(x == arr[0].length-1 && y == 0 && distance == K) {
            result++;
            visited[y][x] = false;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(nx >= 0 && nx < arr[0].length && ny >= 0 && ny < arr.length) {
                if(!visited[ny][nx] && arr[ny][nx] == 1) {
                    dfs(nx, ny, arr, visited, distance, K);
                }
            }
        }
        visited[y][x] = false;
    }
}