import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 =  Integer.parseInt(st.nextToken());
            int y1 =  Integer.parseInt(st.nextToken());
            int r1 =  Integer.parseInt(st.nextToken());
            int x2 =  Integer.parseInt(st.nextToken());
            int y2 =  Integer.parseInt(st.nextToken());
            int r2 =  Integer.parseInt(st.nextToken());

            int dist = (int) (Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
            int inner = (int) Math.pow(Math.abs(r1-r2), 2);
            int outer = (int) Math.pow(r1+r2, 2);

            // 이러면은 작은 원의 반
            if(x1==x2 && y1==y2 && r1==r2) {
                System.out.println(-1);
            } else {
                if(dist < outer && dist > inner) {
                    System.out.println(2);
                } else if(dist == inner) {
                    System.out.println(1);
                } else if(dist == outer) {
                    System.out.println(1);
                } else if(outer < dist) {
                    System.out.println(0);
                } else if(dist < inner) {
                    System.out.println(0);
                }
            }
        }
    }
}