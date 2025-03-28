import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Map<Integer, ArrayList<Integer>> rightGraph = new HashMap<>();
        Map<Integer, ArrayList<Integer>> leftGraph = new HashMap<>();

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int light = Integer.parseInt(st.nextToken());
            int heavy = Integer.parseInt(st.nextToken());

            rightGraph.computeIfAbsent(light, k -> new ArrayList<>()).add(heavy);
            leftGraph.computeIfAbsent(heavy, k -> new ArrayList<>()).add(light);
        }

        for(int i = 1; i <= N; i++) {
            System.out.println(N-(dfs(i, rightGraph)+dfs(i, leftGraph))+1);
        }
    }

    public static int dfs(int i, Map<Integer, ArrayList<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(i);
        visited.add(i);

        while(!stack.isEmpty()) {
            int num = stack.pop();

            for (Integer c : graph.getOrDefault(num, new ArrayList<>())) {
                if(!visited.contains(c)) {
                    stack.push(c);
                    visited.add(c);
                }
            }
        }
        return visited.size();
    }
}