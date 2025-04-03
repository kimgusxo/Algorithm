import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] visited = new boolean[31];

        for(int i = 0; i < 28; i++) {
            int n = Integer.parseInt(br.readLine());

            visited[n] = true;
        }

        for(int i = 1; i < visited.length; i++) {
            if(!visited[i]) {
                System.out.println(i);
            }
        }

    }
}

