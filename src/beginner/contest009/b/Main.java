package beginner.contest009.b;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main p = new Main();
	}

	public Main() {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int[] prices = new int[n];
		for(int i=0;i<n;i++)
			prices[i] = sc.nextInt();
		solve(prices);
	}

	public void solve(int[] prices) {
		Arrays.sort(prices);
		int high = prices[prices.length-1];
		for(int i=prices.length-2;0<=i;i--){
			if(prices[i]!=high){
				System.out.println(prices[i]);
				return;
			}
		}
	}

}
