import java.util.*;

class Solution {
    static Map<String, Element> map = Map.of(
         "ze",new Element("0", 4),
         "on",new Element("1", 3),
         "tw",new Element("2", 3),
         "th",new Element("3", 5),
         "fo",new Element("4", 4),
         "fi",new Element("5", 4),
         "si",new Element("6", 3),
         "se",new Element("7", 5),
         "ei",new Element("8", 5),
         "ni",new Element("9", 4)
    );
    public int solution(String s) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while(idx < s.length()) {
            if(s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                sb.append(s.charAt(idx));
                idx++;
            } else {
                Element el = map.get(s.substring(idx, idx+2));
                sb.append(el.val);
                idx += el.length;   
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}

class Element {
    String val;
    int length;
    
    public Element(String val, int length) {
        this.val = val;
        this.length = length;
    }
}