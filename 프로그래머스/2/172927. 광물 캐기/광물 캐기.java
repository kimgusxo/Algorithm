import java.util.*;

class Solution {

    static int answer = 0;
    
    public int solution(int[] picks, String[] minerals) {        
        List<String> mineralList = new ArrayList<>(Arrays.asList(minerals));
        
        List<Mine> mineList = new ArrayList<>();
        
        int total = 0;
        for(int p : picks) {
            total += p;
        }
        
        if(total*5 > minerals.length) {
            int remain = (total*5)-minerals.length;
            
            for(int i = 0; i < remain; i++) {
                mineralList.add("zero");
            }
        }
        
        for(int i = 0; i < total; i++) {
            int weight = 0;
            for(int j = 0; j < 5; j++) {
                switch(mineralList.get((i*5)+j)) {
                    case "diamond":
                        weight += 25;
                        break;
                    case "iron":
                        weight += 5;
                        break;
                    case "stone":
                        weight += 1;
                        break;
                    case "zero":
                        break;
                }
            }
            
            mineList.add(new Mine(i, weight));
        }
        
        Collections.sort(mineList, (m1, m2) -> {
            if(m1.weight == m2.weight) {
                return Integer.compare(m1.num, m2.num);
            }
            return Integer.compare(m2.weight, m1.weight);
        });
        
        int idx = 0;
        for(int i = 0; i < picks.length; i++) {
            for(int j = 0; j < picks[i]; j++) {
                calc(i, mineList.get(idx).num, mineralList);
                idx++;
            }
        }
        
        return answer;
    }
    
    private static void calc(int craft, int num, List<String> mineralList) {
        if(craft == 0) {
            for(int i = num*5; i < num*5+5; i++) {
                String mineral = mineralList.get(i);
                if(mineral.equals("diamond")) {
                    answer += 1;
                } else if(mineral.equals("iron")) {
                    answer += 1;
                } else if(mineral.equals("stone")) {
                    answer += 1;
                }
            }
        } else if(craft == 1) {
            for(int i = num*5; i < num*5+5; i++) {
                String mineral = mineralList.get(i);
                if(mineral.equals("diamond")) {
                    answer += 5;
                } else if(mineral.equals("iron")) {
                    answer += 1;
                } else if(mineral.equals("stone")) {
                    answer += 1;
                }
            }
        } else if(craft == 2) {
            for(int i = num*5; i < num*5+5; i++) {
                String mineral = mineralList.get(i);
                if(mineral.equals("diamond")) {
                    answer += 25;
                } else if(mineral.equals("iron")) {
                    answer += 5;
                } else if(mineral.equals("stone")) {
                    answer += 1;
                }
            }
        }
    }
}

class Mine {
    int num;
    int weight;
    
    public Mine(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }
}