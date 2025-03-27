import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] campus = new char[N][M];
        boolean[][] visited = new boolean[N][M];

        int iy = 0;
        int ix = 0;

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                campus[i][j] = line.charAt(j);

                if(campus[i][j] == 'I') {
                    iy = i;
                    ix = j;
                }
            }
        }

        dfs(iy, ix, campus, visited);

        if(result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }

    }

    public static void dfs(int y, int x, char[][] campus, boolean[][] visited) {
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny > -1 && ny < campus.length && nx > -1 && nx < campus[0].length) {
                if(!visited[ny][nx] && campus[ny][nx] != 'X') {
                    dfs(ny, nx, campus, visited);

                    if(campus[ny][nx] == 'P') {
                        result++;
                    }
                }
            }
        }
    }
}