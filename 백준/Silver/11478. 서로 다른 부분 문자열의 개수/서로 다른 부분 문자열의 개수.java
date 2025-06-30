import java.io.*;
import java.util.*;

class Main {

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        for(int i = 1; i <= str.length(); i++) {
            for(int ii = 0; ii < str.length(); ii++) {
                if(ii+i <= str.length()) {
                    set.add(str.substring(ii, ii+i));
                }
            }
        }

        bw.write(String.valueOf(set.size()));

        bw.flush();
    }
}