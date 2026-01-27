import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        Deque<Tomato> queue = new ArrayDeque<>();
        int[][] arr = new int[col][row];

        for(int i = 0; i < col; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < row; j++) {
                int el = Integer.parseInt(st.nextToken());
                if(el == 1) {
                    queue.add(new Tomato(i, j, 0));
                    arr[i][j] = 1;
                } else if(el == -1) {
                    arr[i][j] = -1;
                }
            }
        }

        bfs(queue, arr);

        System.out.println(isFilled(arr));
    }

    private static int isFilled(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    return -1;
                }
            }
        }
        return answer;
    }

    private static void bfs(Deque<Tomato> queue, int[][] arr) {
         while(!queue.isEmpty()) {
             Tomato tomato = queue.poll();
             int x = tomato.x;
             int y = tomato.y;
             int day = tomato.day;

             answer = Math.max(day, answer);

             for(int i = 0; i < 4; i++) {
                 int nx =  tomato.x+dx[i];
                 int ny = tomato.y+dy[i];

                 if(nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                     if(arr[nx][ny] == 0) {
                         arr[nx][ny] = 1;
                         queue.add(new Tomato(nx, ny, day+1));
                     }
                 }
             }
         }
    }
}

class Tomato {
    int x;
    int y;
    int day;

    public Tomato(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}