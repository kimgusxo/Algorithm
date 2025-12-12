import java.util.*;

class Solution {
    
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        PriorityQueue<Music> pq = new PriorityQueue<>((a,b) -> {
                if(b.body.length() == a.body.length()) {
                    return a.order - b.order;
                } else {
                    return b.body.length() - a.body.length();
                }
            });
        
        int order = 0;
        for(String info : musicinfos) {
            String[] infos = info.split(",");
            
            String start = infos[0];
            String end = infos[1];
            
            String[] startTime = start.split(":");
            String[] endTime = end.split(":");
            
            int len = (Integer.parseInt(endTime[0])-Integer.parseInt(startTime[0]))*60 + 
                (Integer.parseInt(endTime[1])-Integer.parseInt(startTime[1]));
            
            String title = infos[2];
            StringBuilder sound = new StringBuilder(infos[3]);
            
            
            for(int i = 0; i < sound.length(); i++) {
                if(sound.charAt(i) == '#') {
                    sound.replace(i-1, i+1, String.valueOf(sound.charAt(i-1)).toLowerCase());
                }
            }
            
            StringBuilder target = new StringBuilder();
            
            int idx = 0;
            for(int i = 0; i < len; i++) {
                if(idx == sound.length()) {
                    idx = 0;
                }
                target.append(sound.charAt(idx));
                idx++;
            }
            
            pq.offer(new Music(title, target.toString(), order));
            order++;
        }
        
        StringBuilder find = new StringBuilder(m);
        for(int i = 0; i < find.length(); i++) {
            if(find.charAt(i) == '#') {
                find.replace(i-1, i+1, String.valueOf(find.charAt(i-1)).toLowerCase());
            }
        }
        
        while(!pq.isEmpty()) {
            Music ms = pq.poll();
            if(ms.body.contains(find)) {
                answer = ms.title;
                break;
            }
        }
        
        return answer;
    }
}

class Music {
    String title;
    String body;
    int order;
    
    public Music(String title, String body, int order) {
        this.title = title;
        this.body = body;
        this.order = order;
    }
}