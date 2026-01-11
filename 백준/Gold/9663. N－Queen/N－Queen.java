import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        solve(arr, 0, N);

        System.out.println(answer);
    }

    private static boolean isSafe(int[][] arr, int col, int row, int N) {
        for(int i = row; i >= 0; i--) {
            if(arr[i][col] == 1) {
                return false;
            }
        }

        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(arr[i][j] == 1) {
                return false;
            }
        }

        for(int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if(arr[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void solve(int[][] arr, int row, int N) {
        if(row == N) {
            answer++;
            return;
        }

        for(int i = 0; i < N; i++) {
            if(isSafe(arr, i, row, N)) {
                arr[row][i] = 1;
                solve(arr, row+1, N);
                arr[row][i] = 0;
            }
        }
    }
}