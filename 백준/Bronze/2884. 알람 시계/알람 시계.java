import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int a = sc.nextInt();
	    int b = sc.nextInt();
	    
        if(a >= 0 && b >= 45) {
        	System.out.println(a + " " + (b-45));
        }
        else if(a > 0 && b < 45) {
        	int c = -(b - 45);
        	System.out.println((a-1) + " " + (60-c));
        }
        else if(a == 0 && b < 45) {
        	int d = -(b - 45);
        	int e = -(a-1);
        	System.out.println((24-e) + " " + (60-d));
        }
    }
}