import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        Deque<ChatLog> queue = new ArrayDeque<>();
        Map<String, String> nicknameMap = new HashMap<>();
        
        for(String r : record) {
            String[] parser = r.split(" ");
            
            if(parser[0].equals("Enter")) {
                queue.offer(new ChatLog(parser[0], parser[1]));
                nicknameMap.put(parser[1], parser[2]);
            } else if(parser[0].equals("Leave")) {
                queue.offer(new ChatLog(parser[0], parser[1]));
            } else {
                nicknameMap.put(parser[1], parser[2]);
            }
        }
        
        for(ChatLog log : queue) {
            StringBuilder text = new StringBuilder();
            if(log.state.equals("Enter")) {
                text.append(nicknameMap.get(log.id)).append("님이 들어왔습니다.");
                answer.add(text.toString());
            } else {
                text.append(nicknameMap.get(log.id)).append("님이 나갔습니다.");
                answer.add(text.toString());
            }
        }
        
        return answer.stream().toArray(String[]::new);
    }
}

class ChatLog {
    String state;
    String id;
    
    public ChatLog(String state, String id) {
        this.state = state;
        this.id = id;
    }
}