package beginner.contest004.c;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int count = n%5;
		int start = n/5;
		
		int[] res = new int[6];
		for(int i=0;i<6;i++){
			res[i] = (start+i)%6+1;
		}
		
		for(int i=0;i<count;i++){
			int swap = res[i%5];
			res[i%5] = res[i%5+1];
			res[i%5+1] = swap;
		}
		
		for(int i=0;i<6;i++){
			System.out.print(res[i]+"");
		}
		System.out.println("");
	}
}