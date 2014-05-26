package beginner.contest005.b;

import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = Integer.MAX_VALUE;
		
		for(int i=0;i<n;i++)
			res = Math.min(res, sc.nextInt());
		
		System.out.println(res);
	}
}