import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static PriorityQueue<Integer> results = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N+1][2];

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int day = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());

            arr[i][0] = day;
            arr[i][1] = pay;
        }

        for(int i = 1; i <= N; i++) {
            recursive(arr, i, 0);
        }

        System.out.println(results.poll());

    }

    public static void recursive(int[][] arr, int start, int result) {
        if (start + arr[start][0] > arr.length) {
            results.add(result);
            return;
        }
        else if (start + arr[start][0] == arr.length) {
            result += arr[start][1];
            results.add(result);
            return;
        }

        result += arr[start][1];
        start += arr[start][0];

        for (int i = start; i < arr.length; i++) {
            recursive(arr, i, result);
        }
    }
}
