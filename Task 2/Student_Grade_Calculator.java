package CodSoft;

import java.util.Scanner;

public class StudentGradeCalculator {
	public static char gradeCalculation(double a) {
		
		if(a>=90) {
			return 'S';
		}
		else if((a>=80)&&(a<90)) {
			return 'A';
		}
		else if((a>=70)&&(a<80)) {
			return 'B';
		}
		else if((a>=60)&&(a<70)) {
			return 'C';
		}
		else if((a>=50)&&(a<60)) {
			return 'D';
		}
		else {
			return 'F';
			
		}
	}

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int sum=0;
	boolean result=true;
	System.out.println("Enter the number of subjects:");
	int a=sc.nextInt();//no of subject
	System.out.println("Enter the Marks for "+a+" subjects:(Maximum Marks:100)");
	int[] ar=new int[a];
	for(int i=0;i<a;i++) {
		System.out.println("Subject "+(i+1)+":");
		ar[i]=sc.nextInt();
		sum+=ar[i];
	}
	for(int j=0;j<a;j++) {
		char gs=gradeCalculation(ar[j]);
		if(ar[j]>100) {
			System.out.println("The mark entered for Subject "+(j+1)+" is more than Maximum Maximum!!");
		}
		else {
			if(gs=='F') {
				result=false;
			}
			System.out.println("Grade for Subject "+(j+1)+" is:"+gs);
		}
	}
	double av=sum/a;
	int totmax=a*100;
	char grade=gradeCalculation(av);
	System.out.println("Number of Subjects:"+a);
	System.out.println("Total Marks:"+sum+"/"+totmax);
	System.out.println("Average Percentage:"+av+"%");
	if(result) {
		System.out.println("Grade:"+grade);
	}
	else {
		System.out.println("F");
	}
	}

}