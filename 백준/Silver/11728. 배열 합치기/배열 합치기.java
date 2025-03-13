import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st1.nextToken());
        int b = Integer.parseInt(st2.nextToken());

        while(true) {
            boolean flag = a < b;

            if(flag) {
                sb.append(a).append(" ");
                if(st1.hasMoreTokens()) {
                    a = Integer.parseInt(st1.nextToken());
                } else {
                    sb.append(b).append(" ");
                    while(st2.hasMoreTokens()) {
                        sb.append(st2.nextToken()).append(" ");
                    }
                    break;
                }
            } else {
                sb.append(b).append(" ");
                if(st2.hasMoreTokens()) {
                    b = Integer.parseInt(st2.nextToken());
                } else {
                    sb.append(a).append(" ");
                    while(st1.hasMoreTokens()) {
                        sb.append(st1.nextToken()).append(" ");
                    }
                    break;
                }
            }
        }

        System.out.println(sb);

    }
}