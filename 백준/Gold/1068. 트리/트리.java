import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Node[] tree = new Node[N];
        int[] parents = new int[N];
        int start = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            Node node = new Node(i);
            tree[i] = node;

            int parent = Integer.parseInt(st.nextToken());
            parents[i] = parent;
            if(parent == -1) start = i;
        }

        int remove = Integer.parseInt(br.readLine());
        tree[remove] = null;
        parents[remove] = -2;

        for(int i = 0; i < tree.length; i++) {
            if(tree[i] != null) {
                if(parents[i] > -1) {
                    if(tree[parents[i]] != null) {
                        tree[parents[i]].nodes.add(tree[i]);
                    }
                }
            }
        }

        boolean[] visited = new boolean[N];

        if(remove != start) {
            search(tree[start], visited);
            System.out.println(result);
        } else {
            System.out.println(0);
        }
    }

    private static void search(Node node, boolean[] visited) {
        visited[node.value] = true;
        if(node.nodes.isEmpty()) {
            result++;
            return;
        }

        for(Node child : node.nodes) {
            if(!visited[child.value]) {
                search(child, visited);
                visited[child.value] = false;
            }
        }
    }
}

class Node {
    int value;
    ArrayList<Node> nodes;

    public Node(int value) {
        this.value = value;
        nodes = new ArrayList<>();
    }
}