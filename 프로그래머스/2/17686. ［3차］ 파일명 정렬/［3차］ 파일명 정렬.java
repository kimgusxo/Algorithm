import java.util.*;

class Solution {
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        List<File> fileList = new ArrayList<>();
        
        for(String file : files) {
            boolean flag = false;
            int start = -1;
            int end = -1;
            
            for(int i = 0; i < file.length(); i++) {
                if(!flag && Character.isDigit(file.charAt(i))) {
                    start = i;
                    flag = true;
                } else if(flag && !Character.isDigit(file.charAt(i))) {
                    end = i;
                    if (end - start > 5) end = start + 5;
                    break;
                }
            }
            
            if (flag && end == -1) {
                end = Math.min(start + 5, file.length());
            }
            
            File f = new File(file.substring(0, start),
                                file.substring(start, end),
                                file.substring(end));
            
            fileList.add(f);
        }
        
        for(File f : fileList) {
            System.out.println(f.head + " " + f.number + " " + f.tail);
        }
        
        
        Collections.sort(fileList, (o1, o2) -> {
            int headCompare = o1.head.toLowerCase().compareTo(o2.head.toLowerCase());
            if (headCompare != 0) {
                return headCompare;
            } else {
                int num1 = Integer.parseInt(o1.number);
                int num2 = Integer.parseInt(o2.number);
                return Integer.compare(num1, num2);
            }
        });
        
        int idx = 0;
        for(File f : fileList) {
            StringBuilder parser = new StringBuilder();
            parser
                .append(f.head)
                .append(f.number)
                .append(f.tail);
            
            answer[idx] = parser.toString();
            idx++;
        }
        
        return answer;
    }
}

class File {
    String head;
    String number;
    String tail;
    
    public File(String head, String number, String tail) {
        this.head = head;
        this.number = number;
        this.tail = tail;
    }
}