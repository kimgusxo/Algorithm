import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int MAX = 1299709;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int c1 = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> c1List = new ArrayList<>();
            for (int j = 0; j < c1; j++) {
                c1List.add(Integer.parseInt(st.nextToken()));
            }

            int c2 = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> c2List = new ArrayList<>();
            for (int j = 0; j < c2; j++) {
                c2List.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(c1List);

            StringBuilder sb = new StringBuilder();

            for(int num : c2List) {
                int start = 0;
                int end = c1List.size() - 1;
                int mid = 0;

                boolean flag = false;
                while(start <= end) {
                    mid = (start+end)/2;

                    if(c1List.get(mid) < num) {
                        start = mid + 1;
                    } else if(c1List.get(mid) > num) {
                        end = mid - 1;
                    } else {
                        flag = true;
                        break;
                    }
                }

                if(flag) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
            System.out.print(sb);
        }

    }
}



