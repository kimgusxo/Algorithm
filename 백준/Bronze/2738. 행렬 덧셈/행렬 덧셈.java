import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[X][Y];
        int[][] arr2 = new int[X][Y];

        for(int i = 0; i < X; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < Y; j++) {
                arr1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < X; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < Y; j++) {
                arr2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < X; i++) {
            for(int j = 0; j < Y; j++) {
                System.out.print(arr1[i][j]+arr2[i][j] + " ");
            }
            System.out.println();
        }
    }
}


