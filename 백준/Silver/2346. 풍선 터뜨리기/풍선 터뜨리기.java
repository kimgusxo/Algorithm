import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int count = Integer.parseInt(br.readLine());
    	String line = br.readLine();
    	
    	Deque<Position> deque = new ArrayDeque<>();
    	ArrayList<Integer> resultList = new ArrayList<>();
    	
    	StringTokenizer st = new StringTokenizer(line);
    	
    	for(int i = 0; i < count; i++) {
    		Position pos = new Position(Integer.parseInt(st.nextToken()), i);
    		deque.add(pos);
    	}
    	
    	for(int i = 0; i < count; i++) {
    		 Position temp = deque.removeFirst();
    		 resultList.add(temp.index+1);
    		 
    		 if(deque.isEmpty()) break;
    		 
    		 if(temp.num < 0) {
    			for(int j = 0; j < Math.abs(temp.num); j++) {
    				deque.addFirst(deque.removeLast());
    		 	}
    		 } else {
    			 for(int j = 0; j < temp.num-1; j++) {
    	    		deque.addLast(deque.removeFirst());
     		 	} 
    		 }
    		
    	}
    	
    	for(Integer i : resultList) {
    		System.out.print(i + " ");
    	}
    	
    }
}

class Position {
	int num;
	int index;
	
	Position(int num, int index) {
		this.num = num;
		this.index = index;
	}
}