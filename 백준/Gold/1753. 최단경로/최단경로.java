import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        int K =  Integer.parseInt(br.readLine());

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from =  Integer.parseInt(st.nextToken());
            int to =  Integer.parseInt(st.nextToken());
            int weight =  Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, weight));
        }

        int[] dist = new int[V+1];
        Arrays.fill(dist, INF);

        dijkstra(K, dist);
    }

    private static void dijkstra(int start, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node cur =  pq.poll();

            if(dist[cur.to] < cur.weight) continue;

            for(Node next : graph.get(cur.to)) {
                if(dist[next.to] > dist[cur.to] + next.weight) {
                    dist[next.to] = dist[cur.to] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }

        for(int i = 1; i < dist.length; i++) {
            if(dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}

class Node {
    int to;
    int weight;

    public Node(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}