import java.util.*;

class Solution {
    
    static List<String> answer = new ArrayList<>();

    public String[] solution(String[][] plans) {
        List<Homework> work = new ArrayList<>();
        Stack<Homework> remain = new Stack<>();

        for(String[] p : plans) {
            int startTime = Integer.parseInt(p[1].split(":")[0])*60+Integer.parseInt(p[1].split(":")[1]);
            work.add(new Homework(p[0], startTime, Integer.parseInt(p[2])));
        }

        Collections.sort(work, (w1, w2) -> {
            return Integer.compare(w1.startTime, w2.startTime);
        });

        for(int i = 0; i < work.size()-1; i++) {
            int term = work.get(i+1).startTime-work.get(i).startTime;
            if(term > work.get(i).time) {
                term -= work.get(i).time;
                answer.add(work.get(i).subject);
                while(term > 0 && !remain.isEmpty()) {
                    Homework h = remain.pop();
                    if(h.time > term) {
                        h.time -= term;
                        term = 0;
                        remain.push(h);
                    } else {
                        term -= h.time;
                        answer.add(h.subject);
                    }
                }
            } else if(term == work.get(i).time) {
                answer.add(work.get(i).subject);
            } else {
                work.get(i).time -= term;
                remain.push(work.get(i));
            }

        }

        answer.add(work.get(work.size()-1).subject);

        while(!remain.isEmpty()) {
            answer.add(remain.pop().subject);
        }

        return answer.toArray(new String[0]);
    }
}

class Homework {
    String subject;
    int startTime;
    int time;

    public Homework(String subject, int startTime, int time) {
        this.subject = subject;
        this.startTime = startTime;
        this.time = time;
    }
}