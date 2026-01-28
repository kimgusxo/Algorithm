import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for(int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                if(row[j].equals("1")) {
                    graph.get(i).add(j);
                }
            }
        }

        for(int i = 0; i < N; i++) {
            search(graph, i);
        }
    }

    private static void search(Map<Integer, List<Integer>> graph, int i) {
        boolean[] visited = new boolean[graph.size()];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);

        while(!queue.isEmpty()) {
            int n = queue.poll();

            for(int v : graph.get(n)) {
                if(!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }

        for(boolean b : visited) {
            System.out.print((b ? "1" : "0") + " ");
        }
        System.out.println();
    }
}