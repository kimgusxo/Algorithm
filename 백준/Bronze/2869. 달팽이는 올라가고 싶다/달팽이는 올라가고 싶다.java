import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
   public static void main(String[] args) throws IOException {
	   
	  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	  String s = bf.readLine();
	  StringTokenizer st = new StringTokenizer(s);
	  
	  int increase = Integer.parseInt(st.nextToken());
	  int decrease = Integer.parseInt(st.nextToken());
	  int highest = Integer.parseInt(st.nextToken());
	  
	  int day = (highest-decrease)/(increase-decrease);
	  
	  if((highest-decrease)%(increase-decrease) != 0) {
		  day++;
	  }
	  
	  
	  System.out.println(day);
	  
   	}
}