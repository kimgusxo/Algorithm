import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static PriorityQueue<Integer> results = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> tree = new ArrayList<>();

        for(int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i = 1; i <= N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            Node n1 = new Node(start, distance);
            tree.get(end).add(n1);
            Node n2 = new Node(end, distance);
            tree.get(start).add(n2);
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[N+1];
            search(tree, start, end, 0, visited);

            System.out.println(results.poll());
        }

    }

    private static void search(ArrayList<ArrayList<Node>> tree, int start, int end, int result, boolean[] visited) {
        for(Node n : tree.get(start)) {
            if(!visited[n.end]) {
                visited[start] = true;
                if (n.end == end) {
                    result += n.distance;
                    results.add(result);
                    return;
                } else {
                    result += n.distance;
                    visited[n.end] = true;
                    search(tree, n.end, end, result, visited);
                    result -= n.distance;
                }
            }
        }
    }
}

class Node {
    int end;
    int distance;

    public Node(int end, int distance) {
        this.end = end;
        this.distance = distance;
    }
}
