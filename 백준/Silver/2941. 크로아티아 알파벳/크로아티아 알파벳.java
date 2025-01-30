import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      
	   Scanner sc = new Scanner(System.in);
	   
	   int cnt = 0;
	 
	   String word = sc.next();
	   
	   for(int i = 0; i < word.length()-1; i++) {
		   if(word.charAt(i) == 'c') {
			   if(word.charAt(i+1) == '=' || word.charAt(i+1) == '-') {
				   cnt++;
				   i++;
			   }
		   } else if(word.charAt(i) == 'd') {
			   if(word.charAt(i+1) == '-') {
				   cnt++;
				   i++;
			   }
		   } else if(word.charAt(i) == 'l' || word.charAt(i) == 'n') {
			   if(word.charAt(i+1) == 'j') {
				   cnt++;
				   i++;
			   }
		   } else if(word.charAt(i) == 's' || word.charAt(i) == 'z') {
			   if(word.charAt(i+1) == '=') {
				   cnt++;
				   i++;
			   }
		   }
	   }
	   
	   for(int i = 0; i < word.length()-2; i++) {
		   if(word.charAt(i) == 'd') {
			   if(word.charAt(i+1) == 'z') {
				   if(word.charAt(i+2) == '=') {
					   cnt++;
				   }
			   }
		   }
	   }
	   
	   
	   System.out.println(word.length()-cnt);
   }
}