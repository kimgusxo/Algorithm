import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> nameMap = new HashMap<>();
        Map<String, String> numMap = new HashMap<>();

        for(int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameMap.put(Integer.toString(i), name);
            nameMap.put(name, Integer.toString(i));
        }

        for(int i = 1; i <= M; i++) {
            String n = br.readLine();
            if(nameMap.containsKey(n)) {
                System.out.println(nameMap.get(n));
            } else {
                System.out.println(numMap.get(n));
            }
        }
    }
}