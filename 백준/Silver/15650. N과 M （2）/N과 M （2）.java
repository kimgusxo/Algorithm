import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer> temp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i = 1; i <= n; i++) {
            arr.add(i);
        }

        for(int i = 0; i < n; i++) {
            dfs(arr, set, i, m);
            set.clear();
            temp.clear();
        }
    }

    public static void dfs(ArrayList<Integer> arr, Set<Integer> set, int start, int size) {
        set.add(arr.get(start));
        temp.add(arr.get(start));

        if(temp.size() == size) {
            for (Integer i : temp) {
                System.out.print(i +" ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i < arr.size(); i++) {
            if(!set.contains(arr.get(i))) {
                dfs(arr, set, i, size);
                temp.remove(arr.get(i));
                set.remove(arr.get(i));
            }
        }


    }
}

