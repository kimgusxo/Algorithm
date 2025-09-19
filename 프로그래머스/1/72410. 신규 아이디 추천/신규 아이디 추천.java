class Solution {
    public String solution(String new_id) {
        return pipeline(new_id);
    }

    public static String pipeline(String id) {
        for(int i = 1; i <= 7; i++) {
            id = level(i, id);
        }
        return id;
    }

    public static String level(int level, String id) {
        switch(level) {
            case 1:
                return id.toLowerCase();
            case 2:
                return id.replaceAll("[^a-z0-9._-]", "");
            case 3:
                return id.replaceAll("\\.+", ".");
            case 4:
                id = id.startsWith(".") ? id.substring(1) : id;
                id = id.endsWith(".") ? id.substring(0, id.length()-1) : id;
                return id;
            case 5:
                return id.isEmpty() ? "a" : id;
            case 6:
                if(id.length() > 15) {
                    id = id.substring(0, 15);
                    if(id.endsWith(".")) {
                        id = id.substring(0, id.length()-1);
                    }
                }
                return id;
            case 7:
                if(id.length() < 3) {
                    char c = id.charAt(id.length()-1);
                    for(int i = id.length(); i < 3; i++) {
                        id += c;
                    }
                }
                return id;
        }
        return id;
    }
}