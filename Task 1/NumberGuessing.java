package CodSoft;
import java.util.*;
public class NumberGuessing {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		
		int attempts=0;
		boolean guess=false;
		boolean play=true;
		
		while(play==true) {
			System.out.println("Number Guessing Game:");
			int rn=r.nextInt(100);
		
			System.out.println("Random Number has been Generated Between 0-100:");
			System.out.println("Your Guess??");
		
			while(guess==false) {
				attempts++;
				int in=sc.nextInt();
				if(attempts>10) {
					System.out.println("Sorry Maximum Amount of Attempts Reached!!");
					System.out.println("Better Luck Next Time!!");
					guess=true;
				}
				else {
					if(rn==in) {
						System.out.println("You Have Guessed the Right Number:"+rn);
						guess=true;
						System.out.println("Your Score:"+(11-attempts));
					}
				
					else if(rn<in) {
						System.out.println("Too High!!...Try Again");
					}
				
					else if(rn>in) {
						System.out.println("Too Low!!...Try Again");
					}
				}
			}
			System.out.println("Wanna Play Again??(yes/no)");
			String playagain=sc.next();
			playagain=playagain.toLowerCase();
			
			if(playagain.equals("yes")) {
				play=true;
				guess=false;
				attempts=0;
			}
			
			else if(playagain.equals("no")){
				play=false;
				System.out.println("Thanks For Playing!!");
			}
			
			else {
				System.out.println("Invalid Response!!");
				play=false;
			}
		}
		sc.close();
	}

}
