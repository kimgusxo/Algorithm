import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> posQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negQueue = new PriorityQueue<>();

        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            int el = Integer.parseInt(br.readLine());

            if(el > 1) {
                posQueue.add(el);
            } else if(el <= 0) {
                negQueue.add(el);
            } else {
                result.add(el);
            }
        }

        while(posQueue.size() > 1) {
            int el1 = posQueue.poll();
            int el2 = posQueue.poll();

            int cal = el1 * el2;

            result.add(cal);
        }

        if(!posQueue.isEmpty()) {
            while(!posQueue.isEmpty()) {
                result.add(posQueue.poll());
            }
        }

        while(negQueue.size() > 1) {
            int el1 = negQueue.poll();
            int el2 = negQueue.poll();

            int cal = el1 * el2;

            result.add(cal);
        }

        if(!negQueue.isEmpty()) {
            while(!negQueue.isEmpty()) {
                result.add(negQueue.poll());
            }
        }

        int answer = 0;

        for(Integer el : result) {
            answer += el;
        }

        System.out.println(answer);
    }
}