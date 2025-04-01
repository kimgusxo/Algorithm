import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(1);

    }

    public static void dfs(int start) {
        if(arr.size() == M) {
            for (Integer el : arr) {
                System.out.print(el + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i <= N; i++) {
            arr.add(i);
            dfs(i);
            arr.remove(arr.size() - 1);
        }
    }
}

