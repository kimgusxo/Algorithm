import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            ArrayList<Stock> arr = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr.add(new Stock(j, Integer.parseInt(st.nextToken())));
            }

            ArrayList<Stock> sorted = new ArrayList<>(arr);

            sorted.sort((o1, o2) -> o2.value - o1.value);

            long result = 0;
            int day = 0;
            int cnt = 0;
            long pay = 0;

            for(Stock s : sorted) {
                if(day < s.day) {
                    for(int j = day; j <= s.day; j++) {
                        if(arr.get(j).value < s.value) {
                            pay += arr.get(j).value;
                            cnt++;
                        } else {
                            result += (arr.get(j).value*cnt) - pay;
                        }
                    }

                    day = s.day+1;
                    cnt = 0;
                    pay = 0;
                }
            }

            System.out.println(result);
        }
    }
}

class Stock {

    int day;
    int value;

    public Stock(int day, int value) {
        this.day = day;
        this.value = value;
    }
}
