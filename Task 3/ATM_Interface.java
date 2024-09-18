package CodSoft;

import java.util.InputMismatchException;
import java.util.Scanner;
class ATM{
	Bank b;
	public ATM(Bank b) {
		this.b=b;
	}
	Scanner sc=new Scanner(System.in);
	public void start() {
		boolean a=true;
		while(a) {
			System.out.println("\t\t----WELCOME TO PARTHI BANK----");
			System.out.println("Choose an Operation to Peform:");
			System.out.println("1.Withdraw");
			System.out.println("2.Deposit");
			System.out.println("3.Check Balance");
			System.out.println("4.Exit");
			int choice=getVerify(sc);
			switch(choice) {
			case 1:
				withDraw(sc);
				break;
			case 2:
				deposit(sc);
				break;
			case 3:
				checkBalance();
				break;
			case 4:
				System.out.println("Exiting......");
				a=false;
				break;
			default:
				System.out.println("Try Again!!!,You select in between 1 to 4");
				break;
			}
		}
		sc.close();
	}

public static int getVerify(Scanner sc) {
	int choice=1;
	boolean valid=false;
	while(!valid) {
		try {
			choice=sc.nextInt();
			valid=true;
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid Input!!!! Try Again");
			sc.next();
		}
	}
	return choice;
}
public static double getDouble(Scanner sc) {
	double amount=1;
	boolean valid=false;
	while(!valid) {
		try {
			amount=sc.nextDouble();
			valid=true;
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid Input!!!!! Try again ");
			sc.next();
		}
	}
	return amount;
}
public void withDraw(Scanner sc) {
	System.out.println("Enter the WithDraw Amount:");
	double amount=getDouble(sc);
	if(b.withdraw(amount)) {
		System.out.println("Cash Succesfully Withdrawn from your Account!!!!");
		System.out.println("1.Check Balance:");
		System.out.println("2.Exit");
		int choice=getVerify(sc);
		switch(choice) {
		case 1:
			System.out.println("Account Balance:"+b.getBalance());
			break;
		case 2:
			System.out.println("Thanking You for Using our ATM.......");
			System.exit(0);
		}
	}
	else{
		System.out.println("Insuffiented Amount!!");
	}
}
public void deposit(Scanner sc) {
	System.out.println("Enter the amount to Deposit");
	double amount=getDouble(sc);
	b.deposit(amount);
	System.out.println("Amount sucessfully Deposited!!!"+" New Balance:"+b.getBalance());
	
}
public  void checkBalance() {
	System.out.println("Account Balance:"+b.getBalance());
}

}
class Bank{
	private double accountNum;
	private double balance;
	Bank(double accountNum,double balance){
		this.accountNum=accountNum;
		this.balance=balance;
	}
	public double getBalance() {
		return balance;
	}
	public boolean withdraw(double amount) {
		if(amount>0 && amount<=balance) {
			balance-=amount;
			return true;
		}
		return false;
	}
	public void deposit(double amount) {
		if(amount>0) {
			balance+=amount;
		}
	}
}
	
public class AtmInterface {
	public static void main(String[] args) {
		Bank b=new Bank(1234,10000);
		ATM a=new ATM(b);
		a.start();
		
	}

}