import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < N; i++){
            list.add(i+1);
        }

        boolean[] visited = new boolean[N];

        search(list, visited, result);
    }

    private static void search(ArrayList<Integer> list, boolean[] visited, ArrayList<Integer> result){
        if(result.size() == list.size()) {
            for(Integer el : result) {
                System.out.print(el + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < list.size(); i++){
            if(!visited[i]) {
                result.add(list.get(i));
                visited[i] = true;
                search(list, visited, result);
                result.remove(result.size()-1);
                visited[i] = false;
            }
        }
    }
}


