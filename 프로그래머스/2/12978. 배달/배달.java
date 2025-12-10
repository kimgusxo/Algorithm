import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<List<Node>> graph = new ArrayList<>();
        IntStream.range(0, N+1).forEach(i -> graph.add(new ArrayList<>()));
        
        for(int[] r : road) {
            graph.get(r[0]).add(new Node(r[0], r[1], r[2]));
            graph.get(r[1]).add(new Node(r[1], r[0], r[2]));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
        int[] dist = new int[N+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        pq.offer(new Node(1, 1, dist[1]));
        
        while(!pq.isEmpty()) {
            Node n = pq.poll();
            
            if(dist[n.cur]+n.weight > dist[n.to]) continue;
            
            dist[n.to] = dist[n.cur]+n.weight;
            
            for(Node el : graph.get(n.to)) {
                pq.offer(el);
            }
        }

        for(int d : dist) {
            if(d <= K) answer++;
        }
        
        return answer;
    }
}

class Node {
    int cur;
    int to;
    int weight;
    
    public Node(int cur, int to, int weight) {
        this.cur = cur;
        this.to = to;
        this.weight = weight;
    }
}