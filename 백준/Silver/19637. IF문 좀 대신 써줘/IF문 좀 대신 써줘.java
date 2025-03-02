import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayList<Case> cases = new ArrayList<>();
        cases.add(new Case(st.nextToken(), Integer.parseInt(st.nextToken())));

        int cnt = 1;

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            int val = Integer.parseInt(st.nextToken());

            if(cases.get(cnt-1).val != val) {
                cases.add(new Case(type, val));
                cnt++;
            }

        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine());

            int start = 0;
            int end = cases.size()-1;
            int mid = 0;

            while(start <= end) {
                mid = start+(end-start)/2;

                if(cases.get(mid).val < power) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }
            sb.append(cases.get(start).type).append("\n");
        }
        System.out.println(sb);
    }
}

class Case {
    String type;
    int val;

    public Case(String type, int val) {
        this.type = type;
        this.val = val;
    }
}


