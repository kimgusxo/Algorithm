import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static void divideDistance(int[][] groupBox, ArrayList<Integer> bookBox) {
		int count = 0;
		
		for(int i = 0; i < groupBox.length; i++) {
			for(int j = 0; j < groupBox[0].length; j++) {
				groupBox[i][j] = bookBox.get(count);
				
				count++;
				if(bookBox.size() == count) break;
			}
		}
	}
	
	public static int calcDistance(ArrayList<Integer> groupPositiveBox, ArrayList<Integer> groupNegativeBox, int group) {
		int distance = 0;
		
		int max = 0;
		
		if(!groupPositiveBox.isEmpty() && !groupNegativeBox.isEmpty()) {
			if(groupPositiveBox.get(0) > Math.abs(groupNegativeBox.get(0))) {
				max = groupPositiveBox.get(0);
			} else {
				max = Math.abs(groupNegativeBox.get(0));
			}
			
			for(int i = 0; i < groupPositiveBox.size(); i += group) {
				distance += groupPositiveBox.get(i)*2;
			}
		
			for(int i = 0; i < groupNegativeBox.size(); i += group) {
				distance += Math.abs(groupNegativeBox.get(i))*2;
			}
			
			distance -= max;
			
		} else if(groupPositiveBox.isEmpty()) {
			for(int i = 0; i < groupPositiveBox.size(); i += group) {
				distance += groupPositiveBox.get(i)*2;
			}
		
			for(int i = group; i < groupNegativeBox.size(); i += group) {
				distance += Math.abs(groupNegativeBox.get(i))*2;
			}
			
			distance += Math.abs(groupNegativeBox.get(0));
		} else if(groupNegativeBox.isEmpty()) {
			for(int i = group; i < groupPositiveBox.size(); i += group) {
				distance += groupPositiveBox.get(i)*2;
			}
		
			for(int i = 0; i < groupNegativeBox.size(); i += group) {
				distance += Math.abs(groupNegativeBox.get(i))*2;
			}
			distance += groupPositiveBox.get(0);
		}
		
		return distance;
	}

    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	
    	int bookNum = sc.nextInt();
    	int group = sc.nextInt();
    	
    	int temp = 0;
    	
    	ArrayList<Integer> bookPositiveBox = new ArrayList<>();
    	ArrayList<Integer> bookNegativeBox = new ArrayList<>();
    	
    	for(int i = 0; i < bookNum; i++) {
    		temp = sc.nextInt();
    		if(temp > 0) {
    			bookPositiveBox.add(temp);
    		} else {
    			bookNegativeBox.add(temp);
    		}
    	}
    	
    	Collections.sort(bookPositiveBox, Collections.reverseOrder());
    	Collections.sort(bookNegativeBox);
    	
    	System.out.println(calcDistance(bookPositiveBox, bookNegativeBox, group));
    	
    }
}