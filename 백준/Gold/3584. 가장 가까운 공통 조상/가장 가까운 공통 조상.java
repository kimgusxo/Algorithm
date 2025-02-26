import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            Node[] tree = new Node[N+1];

            for(int j = 1; j <= N; j++) {
                tree[j] = new Node(j);
            }

            for(int j = 0; j < N-1; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                tree[c].parent = tree[p];
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            ArrayList<Integer> n1Arr = new ArrayList<>();
            ArrayList<Integer> n2Arr = new ArrayList<>();

            while(true) {
                n1Arr.add(tree[n1].value);
                if(tree[n1].parent == null) break;
                n1 = tree[n1].parent.value;
            }

            while(true) {
                n2Arr.add(tree[n2].value);
                if(tree[n2].parent == null) break;
                n2 = tree[n2].parent.value;
            }

            ArrayList<Integer> result = new ArrayList<>();

            for(Integer val1 : n1Arr) {
                for(Integer val2 : n2Arr) {
                    if (Objects.equals(val1, val2)) {
                        result.add(val1);
                    }
                }
            }

            System.out.println(result.get(0));
        }
    }
}

class Node {
    int value;
    Node parent;

    public Node(int value) {
        this.value = value;
        parent = null;
    }
}