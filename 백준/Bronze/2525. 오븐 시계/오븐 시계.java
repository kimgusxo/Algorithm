import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      
	  Scanner sc = new Scanner(System.in);
	  
	  int hour = sc.nextInt();
	  int min = sc.nextInt();
	  
	  int time = sc.nextInt();
	  
	  int totalMin = min + time;
	  
	  while(totalMin >= 60) {
		  if(totalMin >= 60) {
			  hour++;
			  totalMin = totalMin-60;
		  }
		  if(hour >= 24) {
			  hour = 0;
		  }
	  }
	  
	  System.out.println(hour + " " + totalMin);
	  
   }
}