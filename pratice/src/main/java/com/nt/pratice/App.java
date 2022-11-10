package com.nt.pratice;

/**
 * Hello world!
 *
 */
public class App 
{
		public static void main(String[] args) 
		{
			int a=8;
			int b=a++ % ++a;
			int c=a++ + ++b*--a + a--;//  / ++b - --b+a++ % ++a;
		//	      10    9     10  9    10      9  9    11
			System.out.println(c);
		}//10+9*
}
