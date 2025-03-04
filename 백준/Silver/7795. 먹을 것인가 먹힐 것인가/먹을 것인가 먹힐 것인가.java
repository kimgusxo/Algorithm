import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<Integer> aList = new ArrayList<>();
            ArrayList<Integer> bList = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                aList.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                bList.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(bList);

            int result = 0;

            for(Integer a : aList) {
                int start = 0;
                int end = bList.size() - 1;
                while(start <= end) {
                    int mid = (start + end) / 2;
                    if(a <= bList.get(mid)) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }

                result += start;
            }

            System.out.println(result);
        }
    }
}



