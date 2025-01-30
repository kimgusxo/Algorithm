import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      
	  Scanner sc = new Scanner(System.in);
	  
	  int num = sc.nextInt();
	  
	  int hexa = 6;
	  int reset = 1;
	  int cnt = 1;
	  
	  for(int i = 1; i < num; i++) {
		 if(num > reset) {
			 reset += hexa * i;
			 cnt++;
		 } else {
			 break;
		 }
	  }
	  
	  System.out.println(cnt);
	  
   	}
}