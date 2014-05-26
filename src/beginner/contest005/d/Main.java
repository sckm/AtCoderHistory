package beginner.contest005.d;

import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] d = new int[n*n];
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				d[i*n+j] = sc.nextInt();
			}
		}
		
		int[][] yokonaga = new int[n+1][n*n]; 
		yokonaga[1] = d;
		
			
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int cur = 0;
				for(int k=0;k<n-j;k++){
					cur += d[i*n+j+k];
					yokonaga[k+1][i*n+j] = cur;
				}
			}
		}
		
		int[] areaOisisa = new int[n*n+1];
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int cur = 0;
				for(int k=0;k<n-i;k++){
					cur = 0;
					for(int l=0;l<n-j;l++){
						cur += yokonaga[k+1][(j+l)*n+i];
						areaOisisa[(k+1)*(l+1)] = Math.max(cur, areaOisisa[(k+1)*(l+1)]);
					}
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=n*n;i++){
			max = Math.max(max, areaOisisa[i]); 
	//		System.out.println(i + ": " + max + " " + areaOisisa[i]);

			areaOisisa[i] = max;
		}
		
		int q = sc.nextInt();
		for(int i=0;i<q;i++){
			System.out.println(areaOisisa[sc.nextInt()]);
		}
		
	}
}