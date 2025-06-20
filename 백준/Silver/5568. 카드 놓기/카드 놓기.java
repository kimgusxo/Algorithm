import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Main {

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        ArrayList<Integer> list = new ArrayList<>();

        dfs(arr, visited, 0, list, M);

        System.out.println(set.size());
    }

    public static void dfs(int[] arr, boolean[] visited, int start, ArrayList<Integer> list , int M) {
        if(list.size() == M) {
            StringBuilder sb = new StringBuilder();
            for(int el : list) {
                sb.append(el);
            }
            set.add(sb.toString());
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                list.add(arr[i]);

                dfs(arr, visited, i, list, M);

                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}