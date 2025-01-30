
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      
	  Scanner sc = new Scanner(System.in);
	  
	  int num  = sc.nextInt();
	  
	  int[] decimal = new int[num];
	  
	  int cnt = 0;
	  
	  for(int i = 0; i < num; i++) {
		  decimal[i] = sc.nextInt();
	  }
	  
	  for(int i = 0; i < num; i++) {
		  if(decimal[i] != 1) {
			  int stack = 0;
			  for(int j = 1; j <= decimal[i]; j++) {
				  if(decimal[i] % j == 0) {
					  stack++;
				  }
				  
				  if(stack > 2) {
					  cnt++;
					  break;
				  }
			  }
		  } else if(decimal[i] == 1) {
			  cnt++;
		  }
	  }
	  
	  System.out.println(num-cnt);
	  
   	}
}