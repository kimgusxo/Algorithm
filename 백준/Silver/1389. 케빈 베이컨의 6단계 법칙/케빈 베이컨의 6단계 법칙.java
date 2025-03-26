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

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            map.computeIfAbsent(n1, k -> new ArrayList<>()).add(n2);
            map.computeIfAbsent(n2, k -> new ArrayList<>()).add(n1);
        }

        ArrayList<Relation> results = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            results.add(new Relation(i, bfs(i, N, map)));
        }

        Collections.sort(results, (o1, o2) -> {
            if(o1.relate == o2.relate) {
                return o1.num - o2.num;
            } else {
                return o1.relate - o2.relate;
            }
        });
        System.out.println(results.get(0).num);
    }

    public static int bfs(int n, int M, Map<Integer, ArrayList<Integer>> map) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        int[] distance = new int[M+1];

        queue.add(n);
        visited.add(n);
        distance[n] = 0;

        int result = 0;

        while(!queue.isEmpty() && visited.size() < M) {
            int cur = queue.poll();

            for(Integer next : map.get(cur)) {
                if(!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                    distance[next] = distance[cur] + 1;
                }
            }
        }

        for(int dist : distance) {
            result += dist;
        }

        return result;
    }
}

class Relation {
    int num;
    int relate;

    public Relation(int num, int relate) {
        this.num = num;
        this.relate = relate;
    }
}