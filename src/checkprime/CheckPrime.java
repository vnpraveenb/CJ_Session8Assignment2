package checkprime;
/*
 * Implement a class that checks whether a given number is a prime 
 * using both the Thread class and Runnable interface
 * 
 * @author Praveen
 */

import java.util.Scanner;//Imports Scanner Class

class PrimeThread extends Thread// PrimeThread Class extends Thread class 
{
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run()
	{
		try
		{
 			
			boolean isPrime=true; 
			
			Scanner scan= new Scanner(System.in); //Creates an object of Scanner Class
			
			System.out.println("Thread created by extending Thread class: " +"\nEnter any number:");		
			int num=scan.nextInt();	// Sets the user input value into num
			
			scan.close();//Closing Scanner Object
			
			//Checking if the number is prime or not
			for(int i=2;i<=num/2;i++)
			{
		
				if(num%i==0) // To check if the number has a divisor
				{
					isPrime=false;
					break;
				}
			}
			
			//If-else statements to print number is a prime number if isPrime is true, else print number is not a  prime number
			if(isPrime){
						
				System.out.println("Thread created by extending Thread class: " + num + " is a Prime Number");
			}
			else
			{
				System.out.println("Thread created by extending Thread class: " + num + " is not a Prime Number");
			}
			Thread.sleep(50);
		
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

class PrimeRunnable implements Runnable //PrimeRunnable Class to implements Runnable interface
{
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		try
		{
		 
		boolean isPrime=true;
		Scanner scan= new Scanner(System.in);//Creates an object of Scanner Class
		Thread.sleep(50);
		System.out.println("Thread created by implementing Runnable inteface: " +"\nEnter any number:");		
		int num=scan.nextInt();	// Sets the user input value into num

		scan.close();//Closing Scanner Object
		
		//Checking if the number is prime or not
		for(int i=2;i<=num/2;i++)
		{
	
			if(num%i==0) // To check if the number has a divisor
			{
				isPrime=false;
				break;
			}
		}
		
		//If-else statements to print number is a prime number if isPrime is true, else print number is not a  prime number
		if(isPrime)
			System.out.println("Thread created by implementing Runnable Interface: " + num + " is a Prime Number");
		else
			System.out.println("Thread created by implementing Runnable Interface: " + num + " is not a Prime Number");
		}
		catch(Exception e1) {
			System.out.println(e1.getMessage());

		}
	}
}
public class CheckPrime 
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try
		{
			PrimeThread th  = new PrimeThread();
			th.start();//Starting the thread created by extending Thread Class
			
			PrimeRunnable pr=new PrimeRunnable();//Creating object of PrimeRunnable Class
			Thread th1=new Thread(pr);//Creating object of Thread Class using pr
			th1.start();//Starting the thread created by implementing Runnable interface
		}
		catch(Exception e2){}
	}
}