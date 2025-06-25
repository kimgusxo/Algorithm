import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String title = br.readLine();
            if(map.containsKey(title)) {
                map.put(title, map.get(title)+1);
            } else {
                map.putIfAbsent(title, 0);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        keySet.sort((o1, o2) -> {
            int cmp = Integer.compare(map.get(o2), map.get(o1)); // value 내림차순
            if(cmp == 0) {
                return o1.compareTo(o2); // key 오름차순 (사전순)
            }
            return cmp;
        });

        bw.write(keySet.get(0) + "\n");

        bw.flush();
    }
}