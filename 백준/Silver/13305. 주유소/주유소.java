import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int city = Integer.parseInt(br.readLine());
        Queue<Integer> distances = new LinkedList<>();
        Queue<Integer> prices = new LinkedList<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int j = 0; j < city-1; j++) {
            distances.add(Integer.parseInt(st1.nextToken()));
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int j = 0; j < city-1; j++) {
            prices.add(Integer.parseInt(st2.nextToken()));
        }

        int cost = 0;

        while(distances.size() > 0 && prices.size() > 0) {
            int distance = distances.remove();
            int price = prices.remove();

            while(prices.size() > 0) {
                if(price >= prices.peek()) {
                    break;
                } else {
                    distance += distances.remove();
                    prices.remove();
                }
            }
            cost += distance*price;
        }

        System.out.println(cost);

    }
}
