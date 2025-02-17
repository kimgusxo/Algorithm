import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> lane = new ArrayList<>();
        int student = 1;

        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            lane.add(num, student);
            student++;
        }

        for(int i = lane.size() - 1; i >= 0; i--) {
            System.out.print(lane.get(i) + " ");
        }

    }
}