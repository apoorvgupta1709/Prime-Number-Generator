package dao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class PrimeChecker {

	public static void main(String[] args)  {


		Scanner sc=new Scanner(System.in);
		System.out.println("Choose method to find prime numbers");
		System.out.println("Press 1 for Method A");
		System.out.println("Press 2 for Method B");

		int value=0,first=0,second=0;
		
		try {
			value=sc.nextInt();

			System.out.println("enter first number");
			first =sc.nextInt();

			System.out.println("Enter second number ");
			second=sc.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.println("please enter valid input");
		}
		
		ArrayList<Integer> arr=new ArrayList<>();
		
		switch(value)
		{

		case 1:
			arr=methodA(first+1,second-1);
			break;

		case 2:
			arr=methodB(first+1,second-1);
			break;

		default:
			System.out.println("please enter valid input ");
			break;
		}
		
		Iterator<Integer> itr=arr.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}

		

		sc.close();


	}

	public static ArrayList<Integer> methodA(int first,int second){
		int i, j, flag;

		ArrayList<Integer> arr=new ArrayList<>();
		
		for (i = first; i <= second; i++) {
			if (i == 1 || i == 0)
				continue;
			flag = 1;

			for (j = 2; j <= i / 2; ++j) {
				if (i % j == 0) {
					flag = 0;
					break;
				}
			}
			// if flag=1 than i is prime otherwise i is not prime
			if (flag == 1)
				arr.add(i);
		}
		return arr;
	}

	 public static ArrayList<Integer> methodB(int first ,int second) {
		int  i, j,flag;
		ArrayList<Integer> arr=new ArrayList<>();


		// when a is less than 2
		if (first == 1) {
			arr.add(first);
			first++;
			if (second >= 2) {
				arr.add(first);
				first++;
			}
		}
		if (first== 2) {
			arr.add(first);
		}
			

		// even numbers are not prime so check before starting loop
		if (first % 2 == 0)
			first++;

		for (i = first; i <= second; i = i + 2) {

			flag = 1;

			// traverse till square root of j only 
			for (j = 2; j * j <= i; ++j) {
				if (i % j == 0) {
					flag = 0;
					break;
				}
			}

			// if flag=1 than i is prime otherwise i is not prime
			if (flag == 1)
				arr.add(i);
		}
		return arr;


	}

}
