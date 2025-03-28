import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int result = 0;
    static int farNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Weight>[] tree = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            tree[src].add(new Weight(dest, distance));
            tree[dest].add(new Weight(src, distance));
        }

        dfs(1, tree);
        dfs(farNode, tree);

        System.out.println(result);
    }

    public static void dfs(int i, ArrayList<Weight>[] tree) {
        Stack<Weight> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(new Weight(i, 0));
        visited.add(i);

        while(!stack.isEmpty()) {

            Weight cur = stack.pop();

            if (tree[cur.dest].stream().allMatch(w -> visited.contains(w.dest))) {
                if(result < cur.distance) {
                    result = cur.distance;
                    farNode = cur.dest;
                }
            } else {
                for (Weight w : tree[cur.dest]) {
                    if (!visited.contains(w.dest)) {
                        stack.push(new Weight(w.dest, cur.distance + w.distance));
                        visited.add(w.dest);
                    }
                }
            }
        }
    }
}

class Weight {
    int dest;
    int distance;

    public Weight(int dest, int distance) {
        this.dest = dest;
        this.distance = distance;
    }
}