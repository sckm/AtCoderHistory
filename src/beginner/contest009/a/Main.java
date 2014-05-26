package beginner.contest009.a;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main p = new Main();
	}

	public Main() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		solve(n);
	}

	public void solve(int n) {
		System.out.println(n/2+n%2);
	}

}
