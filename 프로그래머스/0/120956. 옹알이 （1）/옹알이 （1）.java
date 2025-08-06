import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        String[] words = new String[]{"aya", "ye", "woo", "ma"};
        ArrayList<String> list = new ArrayList<>();
        boolean[] visited = new boolean[words.length];

        recursive(list, visited, words, "");

        int answer = 0;
        for(String babble : babbling) {
            if(list.contains(babble)) answer++;
        }

        return answer;
    }

    public void recursive(List<String> list, boolean[] visited, String[] words, String word) {
        for(int i = 0; i < words.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                word += words[i];
                list.add(word);
                recursive(list, visited, words, word);
                visited[i] = false;
                word = word.replaceAll(words[i], "");
            }
        }
    }
}