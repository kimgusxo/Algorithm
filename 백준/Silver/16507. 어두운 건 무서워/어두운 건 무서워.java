import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[][] arr = new int[R+2][C+2];

        for(int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= C; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(i == 1 && j == 1) {
                    arr[i][j] = num;
                } else if(i == 1) {
                    arr[i][j] = arr[i][j-1] + num;
                } else if(j == 1) {
                    arr[i][j] = arr[i-1][j] + num;
                } else {
                    arr[i][j] = (arr[i-1][j] + arr[i][j-1] + num) - arr[i-1][j-1];
                }
            }
        }


        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());
            int b2 = Integer.parseInt(st.nextToken());

            System.out.println(((arr[a2][b2]-arr[a2][b1-1]-arr[a1-1][b2])+arr[a1-1][b1-1])/((a2-a1+1)*(b2-b1+1)));
        }

    }
}

