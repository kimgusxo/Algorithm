import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String log = st.nextToken();

            map.put(name, log);
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort(Collections.reverseOrder());

        for (String key : keySet) {
            if(map.get(key).equals("enter")) {
                System.out.println(key);
            }
        }

    }
}

