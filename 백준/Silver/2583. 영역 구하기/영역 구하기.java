import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[M+2][N+2];

        for(int j = 1; j < arr.length-1; j++) {
            for(int k = 1; k < arr[j].length-1; k++) {
                arr[j][k] = 1;
            }
        }

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());

            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            for(int j = y1+1; j <= y2; j++) {
                for(int k = x1+1; k <= x2; k++) {
                    arr[j][k] = 9;
                }
            }
        }

        ArrayList<Integer> li = bfs(arr);

        Collections.sort(li);

        System.out.println(li.size());
        li.forEach(x -> System.out.print(x + " "));
    }

    public static ArrayList<Integer> bfs(int[][] arr) {
        Queue<Pos> queue = new LinkedList<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 1; i < arr.length-1; i++) {
            for(int j = 1; j < arr[0].length-1; j++) {
                if(!visited[i][j] && arr[i][j] == 1) {
                    int val = 1;
                    queue.add((new Pos(i, j)));
                    visited[i][j] = true;

                    while(!queue.isEmpty()) {
                        Pos pos = queue.poll();
                        int x = pos.x;
                        int y = pos.y;

                        for(int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if(!visited[nx][ny] && arr[nx][ny] == 1) {
                                queue.add(new Pos(nx, ny));
                                val++;
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    res.add(val);
                }
            }
        }
        return res;
    }
}

class Pos {
    int x;
    int y;
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}