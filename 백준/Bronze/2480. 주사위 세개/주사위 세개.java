import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      
	  Scanner sc = new Scanner(System.in);
	  
	  int dice1 = sc.nextInt();
	  int dice2 = sc.nextInt();
	  int dice3 = sc.nextInt();
	  
	  int max = 0;
	  
	  int award = 0;
	  
	  if(dice1 >= dice2) {
		  max = dice1;
	  } else {
		  max = dice2;
	  }
	  
	  if(max < dice3) {
		  max = dice3;
	  }
	  
	  if(dice1 == dice2 && dice1 == dice3 && dice2 == dice3) {
		  award = 10000 + (max * 1000);
	  } else if((dice1 == dice2 && dice1 != dice3) || (dice1 == dice3 && dice1 != dice2)) {
		  award = 1000 + (dice1 * 100);
	  } else if(dice2 == dice3 && dice1 != dice2) {
		  award = 1000 + (dice2 * 100);
	  } else {
		  award = max * 100;
	  }
	  
	  System.out.println(award);
	  
   }
}