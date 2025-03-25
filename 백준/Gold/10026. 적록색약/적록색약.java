import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] matrix = new String[N+2][N+2];
        String[][] abnormalMatrix = new String[N+2][N+2];

        for(int i = 0; i < N+2; i++) {
            for(int j = 0; j < N+2; j++) {
                matrix[i][j] = "";
                abnormalMatrix[i][j] = "";
            }
        }

        for(int i = 1; i <= N; i++) {
            String line = br.readLine();
            for(int j = 1; j <= N; j++) {
                String color = line.charAt(j-1)+"";
                matrix[i][j] = color;
                if(color.equals("G")) {
                    abnormalMatrix[i][j] = "R";
                } else {
                    abnormalMatrix[i][j] = color;
                }
            }
        }

        int result1 = bfs(matrix);
        int result2 = bfs(abnormalMatrix);

        System.out.println(result1 + " " + result2);
    }

    public static int bfs(String[][] arr) {
        int result = 0;

        Queue<Pixel> queue = new LinkedList<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        for(int i = 1; i < arr.length-1; i++) {
            for(int j = 1; j < arr[i].length-1; j++) {
                if(!visited[i][j]) {
                    queue.add(new Pixel(i, j, arr[i][j]));
                    visited[i][j] = true;

                    while(!queue.isEmpty()) {
                        Pixel p = queue.poll();
                        String current = p.color;
                        int x = p.x;
                        int y = p.y;

                        for(int k = 0; k < 4; k++) {
                            int nx = x+dx[k];
                            int ny = y+dy[k];
                            if(arr[nx][ny].equals(current)) {
                                if(!visited[nx][ny]) {
                                    queue.add(new Pixel(nx, ny, arr[nx][ny]));
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }

                    result++;
                }
            }
        }

        return result;
    }
}

class Pixel {
    int x, y;
    String color;

    public Pixel(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

}
