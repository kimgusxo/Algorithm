import java.util.*;

class Solution {
    
    static List<String> combList = new ArrayList<>();
    static List<String> answerList = new ArrayList<>();
    
    public int solution(String[][] relation) {
        for(int i = 1; i <= relation[0].length; i++) {
            comb(relation[0].length, i, 0, new StringBuilder());
        }
        
        calc(relation);
            
        return answerList.size();
    }
    
    private static void comb(int colLen, int len, int start, StringBuilder c) {
        if(c.length() == len) {
            combList.add(c.toString());
            return;
        }
        
        for(int i = start; i < colLen; i++) {
            c.append(i);
            comb(colLen, len, i+1, c);
            c.deleteCharAt(c.length()-1);   
        }
    }
    
    private static void calc(String[][] relation) {
        for(String c : combList) {
            boolean flag = false;
            List<String> list = new ArrayList<>();
            for(int i = 0; i < relation.length; i++) {
                StringBuilder temp = new StringBuilder();
                for(char ch : c.toCharArray()) {
                    temp.append(relation[i][Character.getNumericValue(ch)]);
                }
                
                if(list.indexOf(temp.toString()) == -1) {
                    list.add(temp.toString());
                } else {
                    flag = true;
                    break;
                }
            }
            
            if(!flag) {
                boolean dup = false;
                for(String ans : answerList) {
                    boolean allContained = true;
                    for(char ch : ans.toCharArray()) {
                        if(c.indexOf(ch) == -1) {
                            allContained = false;
                            break;
                        }
                    }
                    if(allContained) {
                        dup = true;
                        break;
                    }
                }

                if(!dup) {
                    answerList.add(c);
                }
            }
        }
    }
}