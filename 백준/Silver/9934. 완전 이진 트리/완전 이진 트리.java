import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            levels.add(new ArrayList<>());
        }

        int size = (int) Math.pow(2, N) - 1;
        int[] arr = new int[size];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recursive(0, size-1, arr, levels, 0);

        for(ArrayList<Integer> level : levels) {
            for(Integer i : level) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void recursive(int start, int end, int[] arr, ArrayList<ArrayList<Integer>> levels, int level) {
        if (start == end) {
            levels.get(level).add(arr[start]);
        } else {
            int mid = (start + end) / 2;
            levels.get(level).add(arr[mid]);
            recursive(start, mid-1, arr, levels, level+1);
            recursive(mid+1, end, arr, levels, level+1);
        }
    }
}
