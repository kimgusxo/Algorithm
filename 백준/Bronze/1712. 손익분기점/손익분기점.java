import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      
	  Scanner sc = new Scanner(System.in);
	  
	  int fix = sc.nextInt();
	  int val = sc.nextInt();
	  int sell = sc.nextInt();
	 
	  int cnt = 0;
	  
	  while(true) {
		  if(fix < ((sell-val)*cnt)) {
			  break;
		  } else if(val >= sell) {
			  cnt = -1;
			  break;
		  } else {
			  cnt++;
		  }
	  }
	  
	  System.out.println(cnt);
	  
   	}
}