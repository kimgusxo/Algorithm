import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 =  Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        int[] parents = new int[N+1];
        int[] depth =  new int[N+1];
        boolean[] visited = new boolean[N+1];

        dfs(graph, parents, depth, visited, 1);

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());

            System.out.println(findSameParent(parents, depth, m1, m2));
        }
    }

    private static void dfs(List<List<Integer>> graph, int[] parents, int[] depth, boolean[] visited, int node) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        parents[node] = 0;
        depth[node] = 0;
        visited[node] = true;

        while(!stack.isEmpty()) {
            int cur = stack.pop();

            for(Integer child : graph.get(cur)) {
                if(!visited[child]) {
                    visited[child] = true;
                    parents[child] = cur;
                    depth[child] = depth[cur]+1;

                    stack.push(child);
                }
            }
        }
    }

    private static int findSameParent(int[] parents, int[] depth, int m1, int m2) {
        while(depth[m1] != depth[m2]) {
            if(depth[m1] > depth[m2]) {
                m1 = parents[m1];
            } else {
                m2 = parents[m2];
            }
        }

        while(m1 != m2) {
            m1 = parents[m1];
            m2 = parents[m2];
        }

        return m1;
    }
}