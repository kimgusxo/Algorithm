import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> food = new PriorityQueue<>();
        PriorityQueue<Integer> drink = new PriorityQueue<>();

        for(int i = 0; i < 3; i++) {
            food.add(Integer.parseInt(br.readLine()));
        }

        for(int i = 3; i < 5; i++) {
            drink.add(Integer.parseInt(br.readLine()));
        }

        System.out.println(food.poll()+drink.poll()-50);
    }
}
