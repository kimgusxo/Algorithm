import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	
	public static void sentenceCombination(String sentence, ArrayList<String> strList) {
		
		Stack<Integer> stack = new Stack<>();
		
		ArrayList<Position> posList = new ArrayList<>();
		
		char[] sentenceBox = new char[sentence.length()];
		
		for(int i = 0; i < sentenceBox.length; i++) {
			sentenceBox[i] = sentence.charAt(i);
		}
		
		for(int i = 0; i < sentence.length(); i++) {
			if(sentenceBox[i] == '(') {
				stack.push(i);
				sentenceBox[i] = ' ';
			} else if(sentenceBox[i] == ')') {
				int posX = stack.pop();
				Position positionSet = new Position(posX, i);
				posList.add(positionSet);
				sentenceBox[i] = ' ';
			}
		}
		
		boolean[] visit = new boolean[posList.size()];
		
		for(int i = 1; i < posList.size(); i++) {
			combination(posList, visit, 0, posList.size(), i, sentenceBox, strList);
		}
		
		String temp = String.valueOf(sentenceBox);
		temp = temp.replaceAll(" ", "");
		
		strList.add(temp);
	}
	
	public static void combination(ArrayList<Position> posList, boolean[] visited, int start, int n, int r, char[] sentenceBox, ArrayList<String> strList) {
		
		if(r == 0) {
			print(posList, visited, n, sentenceBox, strList);
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(posList, visited, i+1, n, r-1, sentenceBox, strList);
	        visited[i] = false;
	    }
	}
	
	public static void print(ArrayList<Position> posList, boolean[] visited, int n, char[] sentenceBox, ArrayList<String> strList) {
		String temp = "";
		char[] tempBox = new char[sentenceBox.length];
		tempBox = sentenceBox.clone();
		for (int i = 0; i < n; i++) {
            if (visited[i] == true) {
            	int x = posList.get(i).posX;
            	int y = posList.get(i).posY;
            	
            	tempBox[x] = '(';
            	tempBox[y] = ')';
            }
        }
		temp = String.valueOf(tempBox);
		temp = temp.replaceAll(" ", "");
		
		strList.add(temp);
	}
	
    public static void main(String[] args) throws IOException {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String sentence = br.readLine();
    	
    	ArrayList<String> strList = new ArrayList<>();
    	
    	sentenceCombination(sentence, strList);
    	
    	Collections.sort(strList);
    	
    	List<String> resultList = strList.stream().distinct().collect(Collectors.toList());
    	
    	for(String el : resultList) {
    		System.out.println(el);
    	}
    }
}

class Position {
	Integer posX;
	Integer posY;
	
	Position(Integer posX, Integer posY) {
		this.posX = posX;
		this.posY = posY;
	}
}