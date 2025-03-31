import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Character, ArrayList<Character>> graph = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String line = br.readLine();

            char c1 = line.split(" ")[0].charAt(0);
            char c2 = line.split(" ")[2].charAt(0);

            graph.computeIfAbsent(c1, k -> new ArrayList<>()).add(c2);
        }

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            String line = br.readLine();

            char c1 = line.split(" ")[0].charAt(0);
            char c2 = line.split(" ")[2].charAt(0);

            System.out.println(dfs(c1, c2, graph));
        }
    }

    public static String dfs(char c1, char c2, Map<Character, ArrayList<Character>> graph) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();

        stack.push(c1);
        set.add(c1);

        while(!stack.isEmpty()) {
            char c = stack.pop();

            if (c == c2) {
                return "T";
            }

            for (Character ch : graph.getOrDefault(c, new ArrayList<>())) {
                if(!set.contains(ch)) {
                    stack.push(ch);
                    set.add(ch);
                }
            }
        }

        return "F";
    }
}

