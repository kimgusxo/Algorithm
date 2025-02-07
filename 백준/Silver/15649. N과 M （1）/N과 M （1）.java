import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        boolean[] used = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        ArrayList<Integer> list = new ArrayList<>();
        backTracking(list, arr, used, M);

        for(ArrayList<Integer> li : result) {
            for(int i : li) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    public static void backTracking(ArrayList<Integer> list, int[] arr, boolean[] used, int M) {
        if(list.size() == M) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 1; i <= arr.length-1; i++) {
            if(!used[i]) {
                list.add(arr[i]);
                used[i] = true;
                backTracking(list, arr, used, M);

                list.remove(list.size()-1);
                used[i] = false;
            }
        }
    }
}