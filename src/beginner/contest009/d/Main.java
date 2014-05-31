package beginner.contest009.d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main p = new Main();
	}

	public Main() {
		Scanner sc = new Scanner(System.in);
		int k = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());
		long[] a = new long[k];
		long[] c = new long[k];
		for(int i=0;i<k;i++)
			a[i] = Long.parseLong(sc.next());
		for(int i=0;i<k;i++)
			c[i] = Long.parseLong(sc.next());
		
		solve(k, m , a, c);
	}

	public void solve(int k, int m, long[] a, long[] c) {
		long[][] mat = new long[k][k];
		long[][] x = new long[k][1];
		for(int i=0;i<k;i++){
			mat[0][i] = c[i];
			x[k-i-1][0] = a[i];
		}
		for(int i=1;i<k;i++)
			mat[i][i-1] = -1;
		
		mat = matPow(mat, m-1, x);
	
		System.out.println(mat[k-1][0]);
	}
	
	private long[][] matPow(long[][] mat, int n, long[][] a){
		while(n>0){
			if((n&1) == 1)
				a = matXor(mat, a);

			mat = matXor(mat, mat);
			n = n>>1;
		}
		
		return a;
	}
	
	private long[][] matXor(long[][] a, long[][] x){
		long[][] c = new long[a.length][x[0].length];
		
		for(int i=0;i<a.length;i++){
			for(int j=0;j<x.length;j++){
				for(int k=0;k<x[0].length;k++){
					c[i][k] = c[i][k] ^ (a[i][j] & x[j][k]);
				}
			}
		}
		
		return c;
	}

}
