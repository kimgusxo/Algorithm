import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int count = sc.nextInt();
    	
		ArrayList<Human> humanList = new ArrayList<>();
		ArrayList<Human> copyList = new ArrayList<>();
    	
    	for(int i = 0; i < count; i++) {
    		int input1 = sc.nextInt();
    		int input2 = sc.nextInt();
    	
    		Human human = new Human(input1, input2);
    		
    		humanList.add(human);
    		copyList.add(human);
    	}
    	
    	Collections.sort(humanList);
    	
    	
    	
    	for(int i = 0; i < humanList.size(); i++) {
    		int ranking = 1;
    		for(int j = i; j < humanList.size(); j++) {
    			if(humanList.get(i).weight < humanList.get(j).weight) {
    				if(humanList.get(i).height < humanList.get(j).height) {
    					ranking++;
    				}
    			}
    		}
    		humanList.get(i).rank = ranking;
    	}
    	
    	for(int i = 0; i < humanList.size(); i++) {
    		for(int j = 0; j < copyList.size(); j++) {
    		
    			if(humanList.get(i).weight == copyList.get(j).weight
    					&& humanList.get(i).height == copyList.get(j).height) {
    				copyList.get(j).rank = humanList.get(i).rank;
        		}
    		}
    	}
    	
    	for(int i = 0; i < copyList.size(); i++) {
    		System.out.print(copyList.get(i).rank + " ");
    	}
    	
    }
    
}

class Human implements Comparable<Human> {
	
	public int weight;
	public int height;
	public int rank;
	
	public Human(int weight, int height) {
		this.weight = weight;
		this.height = height;
		this.rank = 0;
	}

	@Override
	public int compareTo(Human o) {
		if(o.weight < weight) {
			return 1;
		} else {
			if(o.weight == weight) {
				if(o.height < height) {
					return 1;
				} else if(o.height > height) {
					return -1;
				}
				else {
					return 0;
				}
			}
			return -1;
		}
	}
}