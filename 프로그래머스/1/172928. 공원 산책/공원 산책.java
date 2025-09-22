class Solution {
public int[] solution(String[] park, String[] routes) {
        int[] pos = new int[2];

        int idx = 0;
        for(String p : park) {
            if(p.indexOf("S") > -1) {
                pos[0] = idx;
                pos[1] = p.indexOf("S");
                break;
            }
            idx++;
        }

        for(String r : routes) {
            pos = move(r, pos[0], pos[1], park);
        }

        return pos;
    }

    public static int[] move(String args, int x, int y, String[] park) {
        int rollbackX = x;
        int rollbackY = y;
        int successX = x;
        int successY = y;

        String[] argArr = args.split(" ");
        switch(argArr[0]) {
            case "E":
                for(int i = 1; i <= Integer.parseInt(argArr[1]); i++) {
                    if((y+i) < park[0].length() && park[x].charAt(y+i) != 'X') {
                        successY++;
                    } else {
                        return new int[]{rollbackX, rollbackY};
                    }
                }
                break;
            case "W":
                for(int i = 1; i <= Integer.parseInt(argArr[1]); i++) {
                    if((y-i) >= 0 && park[x].charAt(y-i) != 'X') {
                        successY--;
                    } else {
                        return new int[]{rollbackX, rollbackY};
                    }
                }
                break;
            case "S":
                for(int i = 1; i <= Integer.parseInt(argArr[1]); i++) {
                    if((x+i) < park.length && park[x+i].charAt(y) != 'X') {
                        successX++;
                    } else {
                        return new int[]{rollbackX, rollbackY};
                    }
                }
                break;
            case "N":
                for(int i = 1; i <= Integer.parseInt(argArr[1]); i++) {
                    if((x-i) >= 0 && park[x-i].charAt(y) != 'X') {
                        successX--;
                    } else {
                        return new int[]{rollbackX, rollbackY};
                    }
                }
                break;
        }
        return new int[]{successX, successY};
    }
}