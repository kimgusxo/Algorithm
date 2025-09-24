class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        Video v = new Video(
            Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]), 
            Integer.parseInt(pos.split(":")[0]) * 60 + Integer.parseInt(pos.split(":")[1]),
            Integer.parseInt(op_start.split(":")[0]) * 60 + Integer.parseInt(op_start.split(":")[1]),
            Integer.parseInt(op_end.split(":")[0]) * 60 + Integer.parseInt(op_end.split(":")[1])
        );
        
        for(String com : commands) {
            v = v.command(v, com);              
        }
        
        return v.result(v);
    }
}

class Video {
    int len;
    
    int sec;
    
    int op_sec_start;
    int op_sec_end;
    
    public Video(int len, int sec, int op_sec_start, int op_sec_end) {
        this.len = len;
        this.sec = sec;
        this.op_sec_start = op_sec_start;
        this.op_sec_end = op_sec_end;
        
    }
    
    private static Video timeAdjust(Video v) {
        if(v.sec < 0) {
            v.sec = 0;
        } else if(v.sec > v.len) {
            v.sec = v.len;
        }
        
        if(v.op_sec_start <= v.sec && v.sec <= v.op_sec_end) {
            v.sec = v.op_sec_end;
        }
        
        return v;
    }
    
    public static Video command(Video v, String com) {
        timeAdjust(v);
        switch(com) {
            case "next":
                v.sec += 10;
                timeAdjust(v);
                break;
            case "prev":
                v.sec -= 10;
                timeAdjust(v);
                break;
        }
        return v;
    }
    
    public static String result(Video v) {
        timeAdjust(v);
        
        int min = v.sec/60;
        int sec = v.sec%60;
        
        StringBuilder sb = new StringBuilder();
        sb.append(min < 10 ? "0"+min : min).append(":").append(sec < 10 ? "0"+sec : sec);
        return sb.toString();
    }
}