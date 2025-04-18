import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        conquer(arr);
        System.out.println(result);
    }

    public static void conquer(int[][] arr) {
        if(arr.length == 1) {
            result = arr[0][0];
            return;
        }


        int[][] newArr = new int[arr.length/2][arr[0].length/2];

        for(int i = 0; i < arr.length; i+=2) {
            for(int j = 0; j < arr[i].length; j+=2) {
                ArrayList<Integer> list = new ArrayList<>();

                list.add(arr[i][j]);
                list.add(arr[i+1][j]);
                list.add(arr[i][j+1]);
                list.add(arr[i+1][j+1]);

                Collections.sort(list);

                newArr[i/2][j/2] = list.get(list.size()-2);
            }
        }

        conquer(newArr);
    }
}


