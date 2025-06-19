import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++) {
            long M = Long.parseLong(br.readLine());
            if(map.containsKey(M)) {
                map.put(M, map.get(M)+1);
            } else {
                map.put(M, 1);
            }
        }

        List<Long> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> {
            int cmp = map.get(o2).compareTo(map.get(o1));
            if (cmp != 0) return cmp;
            return o1.compareTo(o2);
        });

        System.out.println(keySet.get(0));

    }
}