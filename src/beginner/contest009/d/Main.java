package beginner.contest009.d;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main p = new Main();
	}

	public Main() {
		Scanner sc = new Scanner(System.in);
		int k = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		int[] a = new int[k];
		int[] c = new int[k];
		for(int i=0;i<k;i++)
			a[i] = Integer.parseInt(sc.next());
		for(int i=0;i<k;i++)
			c[i] = Integer.parseInt(sc.next());
		
		solve(k, m , a, c);
	}

	public void solve(int k, int m, int[] a, int[] c) {
		int res = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<k;i++){
			list.add(c[i]&a[i]);
		}
		System.out.println(m);
		for(int i=k;i<m;i++){
			
		}
		System.out.println(res);
	}

}
