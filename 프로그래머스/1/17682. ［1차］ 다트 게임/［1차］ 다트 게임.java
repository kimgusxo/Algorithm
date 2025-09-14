class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        int[] games = new int[3];

        String point = "";
        int idx = -1;

        for(char c : dartResult.toCharArray()) {
            switch(c) {
                case 'S':
                    idx++;
                    games[idx] += Integer.parseInt(point);
                    point = "";
                    break;
                case 'D':
                    idx++;
                    games[idx] += Math.pow(Integer.parseInt(point), 2);
                    point = "";
                    break;
                case 'T':
                    idx++;
                    games[idx] += Math.pow(Integer.parseInt(point), 3);
                    point = "";
                    break;
                case '*':
                    if(idx != 0) {
                        games[idx-1] *= 2;
                    }
                    games[idx] *= 2;
                    break;
                case '#':
                    games[idx] *= -1;
                    break;
                default:
                    point += c;
                    break;
            }
        }

        for(int el : games) {
            answer += el;
        }

        return answer;
    }
}