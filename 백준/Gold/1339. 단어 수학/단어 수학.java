import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int line = Integer.parseInt(br.readLine());

        String[] words = new String[line];

        for(int i = 0; i < line; i++) {
            words[i] = br.readLine();
        }

        Map<Character, Double> map = new HashMap<>();

        for(int i = 65; i < 91; i++) {
            map.put((char)i, 0.0);
        }

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                Double d = map.get(word.charAt(i)) + Math.pow(10, word.length()-i+1);
                map.replace(word.charAt(i), d);
            }
        }

        ArrayList<Character> arr = new ArrayList<>(map.keySet());
        Collections.sort(arr, (o1, o2) -> Double.compare(map.get(o2), map.get(o1)));

        int result = 0;
        for(int i = 0; i < line; i++) {
            String str = words[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < str.length(); j++) {
                sb.append(9-arr.indexOf(str.charAt(j)));
            }
            result += Integer.parseInt(sb.toString());
        }


        System.out.println(result);
    }
}
