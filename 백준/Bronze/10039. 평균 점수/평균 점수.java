import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int scores = 0;
        for(int i = 0; i < 5; i++) {
            int score = Integer.parseInt(br.readLine());
            if(score < 40) {
                score = 40;
            }
            scores += score;
        }
        
        System.out.println(scores/5);
    }
}