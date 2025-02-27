import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());

            if (N == 0) {
                break;
            } else {
                ArrayList<Integer> list = new ArrayList<>();

                while (st.hasMoreTokens()) {
                    list.add(Integer.parseInt(st.nextToken()));
                }

                ArrayList<Integer> results = new ArrayList<>();
                search(list, 0, results);
            }
            System.out.println();
        }
    }

    private static void search(ArrayList<Integer> list, int index, ArrayList<Integer> results) {
        if(results.size() == 6) {
            for(Integer a : results) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }

        for(int i = index; i < list.size(); i++) {
            results.add(list.get(i));
            search(list, i+1, results);
            results.remove(results.size()-1);
        }


    }
}