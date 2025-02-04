import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer result = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>());
        arr.get(0).add(result);
        int depth = 0;

        while(true) {
            boolean flag = false;
            arr.add(new ArrayList<>());
            for (Integer list : arr.get(depth)) {
                if (list == 1) {
                    flag = true;
                }

                if (list % 3 == 0) {
                    arr.get(depth + 1).add(list / 3);
                }
                if (list % 2 == 0) {
                    arr.get(depth + 1).add(list / 2);
                }
                arr.get(depth + 1).add(list - 1);
            }
            if (flag) break;
            depth++;
        }
        System.out.println(depth);
    }
}
