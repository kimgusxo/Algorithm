import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, ArrayList<Integer>> lightGraph = new HashMap<>();
        Map<Integer, ArrayList<Integer>> heavyGraph = new HashMap<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int light = Integer.parseInt(st.nextToken());
            int heavy = Integer.parseInt(st.nextToken());

            lightGraph.computeIfAbsent(light, k -> new ArrayList<>()).add(heavy);
            heavyGraph.computeIfAbsent(heavy, k -> new ArrayList<>()).add(light);

        }

        int result = 0;

        for(int i = 1; i <= N; i++) {
            int val = dfs(i, lightGraph) + dfs(i, heavyGraph) - 1;

            if(val == N) {
                result++;
            }
        }

        System.out.println(result);
    }

    public static int dfs(int start, Map<Integer, ArrayList<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(start);
        visited.add(start);

        while(!stack.isEmpty()) {
            int cur = stack.pop();

            for(Integer i : graph.getOrDefault(cur, new ArrayList<>())) {
                if(!visited.contains(i)) {
                    stack.push(i);
                    visited.add(i);
                }
            }
        }

        return visited.size();
    }
}