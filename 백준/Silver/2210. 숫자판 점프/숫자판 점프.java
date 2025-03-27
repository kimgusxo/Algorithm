import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[7][7];

        for(int i = 1; i <= 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= 5; i++) {
            for(int j = 1; j <= 5; j++) {
                dfs(i, j, map);
            }
        }

        System.out.println(set.size());
    }

    public static void dfs(int y, int x, int[][] map) {
        Stack<Pos> stack = new Stack<>();

        stack.push(new Pos(y, x, 0, String.valueOf(map[y][x])));

        while(!stack.isEmpty()) {
            Pos pos = stack.pop();

            for(int i = 0; i < 4; i++) {
                int ny = pos.y + dy[i];
                int nx = pos.x + dx[i];

                if(nx > 0 && ny > 0 && nx <= 5 && ny <= 5) {
                    if(pos.level < 5) {
                        int level = pos.level + 1;
                        String val = pos.val + map[ny][nx];
                        stack.push(new Pos(ny, nx, level, val));
                    } else {
                        set.add(pos.val);
                    }
                }
            }
        }
    }
}

class Pos {
    int y;
    int x;
    int level;
    String val;

    public Pos(int y, int x, int level, String val) {
        this.y = y;
        this.x = x;
        this.level = level;
        this.val = val;
    }
}