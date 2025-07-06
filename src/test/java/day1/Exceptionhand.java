package day1;
import java.util.Scanner;
public class Exceptionhand {
public static void main(String[] args) {
	System.out.println("enter the number");
	Scanner sc =new Scanner(System.in);
	int num=sc.nextInt();
	try {
		int sum=num/0;
	}
	catch(Exception e) {
		System.err.println(e);
	}
	finally{
		
		System.out.println("program completed");
	}

}
}
