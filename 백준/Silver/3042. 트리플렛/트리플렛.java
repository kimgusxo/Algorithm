import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int width = Integer.parseInt(br.readLine());
    	
    	char[][] cBox = new char[width][width];
    	
    	ArrayList<Position> posList = new ArrayList<>();
    	
    	for(int i = 0; i < width; i++) {
    		String line = br.readLine();
    		for(int j = 0; j < width; j++) {
    			if(line.charAt(j) != '.') {
    				Position pos = new Position(i, j);
    				posList.add(pos);
    			}
    		}
    	}
    	
    	Queue<WrappingPosition> wrapPosQueue = new LinkedList<>();
    	
    	for(int i = 0; i < posList.size(); i++) {
    		for(int j = i+1; j < posList.size(); j++) {
    			for(int k = j+1; k < posList.size(); k++) {
    				WrappingPosition wp = new WrappingPosition(posList.get(i), posList.get(j), posList.get(k));
    				wrapPosQueue.add(wp);
    			}
    		}
    	}
    	
    	int count = 0;
    	
    	for(int i = 0; !wrapPosQueue.isEmpty(); i++) {
    		
    		WrappingPosition tempPos = wrapPosQueue.remove();
    		
    		int A = (tempPos.two.x - tempPos.three.x) * (tempPos.one.y - tempPos.two.y);
    		int B = (tempPos.one.x - tempPos.two.x) * (tempPos.two.y - tempPos.three.y);
    	
    		if(A == B) {
    			count++;
    		}
    	}
    	
    	System.out.print(count);
    	
    }
}

class Position {
	int x;
	int y;
	
	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class WrappingPosition {
	Position one;
	Position two;
	Position three;
	
	WrappingPosition(Position one, Position two, Position three) {
		this.one = one;
		this.two = two;
		this.three = three;
	}
}