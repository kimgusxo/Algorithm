import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        int cnt = 0;

        for(int i = 0; i < N; i++) {
            String person = br.readLine();

            if(person.equals("ENTER")) {
                cnt += set.size();
                set.clear();
            } else {
                set.add(person);
            }
        }

        cnt += set.size();

        bw.write(cnt + "\n");

        bw.flush();
    }
}