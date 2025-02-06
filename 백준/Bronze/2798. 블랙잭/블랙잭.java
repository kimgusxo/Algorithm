import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();
        while(st.hasMoreTokens()) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < arr.size(); i++) {
            int x = arr.get(i);
            for(int j = i+1; j < arr.size(); j++) {
                int y = arr.get(j);
                for(int k = j+1; k < arr.size(); k++) {
                    int z = arr.get(k);

                    int val = x+y+z;
                    if(val<=m) {
                        result.add(val);
                    }
                }
            }
        }

        Collections.sort(result, Collections.reverseOrder());
        System.out.println(result.get(0));
    }
}