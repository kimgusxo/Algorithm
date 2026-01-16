import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N =  Integer.parseInt(st.nextToken());
        int R =  Integer.parseInt(st.nextToken());
        int Q =   Integer.parseInt(st.nextToken());

        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 =  Integer.parseInt(st.nextToken());
            int n2 =  Integer.parseInt(st.nextToken());

            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }

        int[] size = new int[N+1];
        boolean[] visited = new boolean[N+1];
        dfs(tree, size, visited, R);

        for(int i = 0; i < Q; i++) {
            int query = Integer.parseInt(br.readLine());
            System.out.println(size[query]);
        }
    }

    private static int dfs(List<List<Integer>> tree, int[] size, boolean[] visited, int node) {
        size[node] = 1;
        visited[node] = true;

        for(Integer child : tree.get(node)) {
            if(!visited[child]) {
                size[node] += dfs(tree, size, visited, child);
            }
        }
        return size[node];
    }
}