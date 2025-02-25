import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> wordArr = new ArrayList<>();

        String line;
        while((line = br.readLine()) != null && !line.isEmpty()) {
            wordArr.add(line);
        }

        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for(String word : wordArr) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);
            if(!map.containsKey(key)) {
                map.put(key, new HashSet<>());
                countMap.put(key, 0);
            }

            map.get(key).add(word);
            countMap.put(key, countMap.get(key) + 1);
        }

        PriorityQueue<Group> pq = new PriorityQueue<>(new Comparator<Group>() {
            @Override
            public int compare(Group o1, Group o2) {
                if (o1.count != o2.count) {
                    return o2.count - o1.count;
                } else {
                    return o1.words.get(0).compareTo(o2.words.get(0));
                }
            }
        });

        for(String key : map.keySet()) {
            ArrayList<String> arr = new ArrayList<>(map.get(key));
            Group temp = new Group(countMap.get(key), arr);
            Collections.sort(temp.words);
            pq.add(temp);
        }

        int cnt = 0;
        while(!pq.isEmpty()) {
            Group el = pq.poll();
            System.out.print("Group of size " + el.count + ": ");
            for(String s : el.words) {
                System.out.print(s + " ");
            }
            System.out.print(".");
            System.out.println();
            cnt++;

            if(cnt == 5) break;
        }
    }
}

class Group {
    int count;
    ArrayList<String> words;

    public Group(int count, ArrayList<String> words) {
        this.count = count;
        this.words = words;
    }
}