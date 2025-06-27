import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        String s = "Cheese";
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder(st.nextToken());
            if(sb.length() >= 6) {
                if(s.equals(sb.substring(sb.length()-6))) {
                    set.add(sb.toString());
                }
            }
        }

        if(set.size() >= 4) {
            System.out.println("yummy");
        } else {
            System.out.println("sad");
        }

        bw.flush();
    }
}