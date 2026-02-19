import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size =  Integer.parseInt(st.nextToken());
        int command = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        int[] maxTree = new int[size*4];
        int[] minTree = new int[size*4];

        build(maxTree, list, 1, 0, size-1, true);
        build(minTree, list, 1, 0, size-1, false);

        for(int i = 0; i < command; i++) {
            st = new StringTokenizer(br.readLine());

            int left =  Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            System.out.println(calc(minTree, 1, 0, size-1, left-1, right-1, false) + " " + calc(maxTree, 1, 0, size-1, left-1, right-1, true));
        }
    }

    private static void build(int[] tree, List<Integer> list, int node, int start, int end, boolean isMax) {
        if(start == end) {
            tree[node] = list.get(start);
            return;
        }

        build(tree, list, node*2, start, (start+end)/2, isMax);
        build(tree, list, node*2+1, (start+end)/2+1, end, isMax);

        if(isMax) {
            tree[node] = Math.max(tree[node*2],  tree[node*2+1]);
        } else {
            tree[node] =  Math.min(tree[node*2], tree[node*2+1]);
        }
    }

    private static int calc(int[] tree, int node, int start, int end, int left, int right, boolean isMax) {
        if(left > end || right < start) {
            if(isMax) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }

        if(start >= left && end <= right) {
            return tree[node];
        }

        int leftVal = calc(tree, node*2, start, (start+end)/2, left, right, isMax);
        int rightVal = calc(tree, node*2+1, (start+end)/2+1, end, left, right, isMax);

        if(isMax) {
            return Math.max(leftVal, rightVal);
        } else {
            return Math.min(leftVal, rightVal);
        }
    }
}