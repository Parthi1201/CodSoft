package CodSoft;
import java.util.*;
public class NumberGuessing {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		int attempts=0;
		boolean guess=false;
		System.out.println("Number Guessing Game:");
		int rn=r.nextInt(100);
		System.out.println("Random Number has been Generated Between 0-100:");
		System.out.println("Your Guess??");
		while(guess==false) {
			attempts++;
			int in=sc.nextInt();
			if(rn==in) {
				System.out.println("You Have Guessed the Right Number:"+rn);
				guess=true;
				System.out.println("Number of Attempts:"+attempts);
			}
			else if(rn<in) {
				System.out.println("Too High!!...Try Again");
			}
			else if(rn>in) {
				System.out.println("Too Low!!...Try Again");
			}
		}
		sc.close();
	}

}
