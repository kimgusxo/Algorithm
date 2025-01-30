import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      
	  Scanner sc = new Scanner(System.in);
	  
	  int num = sc.nextInt();
	  int cnt = 0;
	  
	  String[] str = new String[num];
	  
	  for(int i = 0; i < num; i++) {
		str[i] = sc.next();
	  }
	  
	  for(int i = 0; i < num; i++) {
		  if(str[i].length() > 1) {
			  loop : for(int j = 0; j < str[i].length()-1; j++) {
			  	if(str[i].charAt(j) != str[i].charAt(j+1)) {
			  		for(int k = j+2; k < str[i].length(); k++) {
			  			if(str[i].charAt(j) == str[i].charAt(k)) {
			  				cnt++;
			  				break loop;
			  			}
			  		}
			  	}
			  }
		  }
	  }
	  
	  System.out.println(num-cnt);
	  
   	}
}