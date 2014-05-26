package beginner.contest005.c;

import java.util.Scanner;


public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int n = sc.nextInt();
		int[] tako = new int[n];
		for(int i=0;i<n;i++)
			tako[i] = sc.nextInt();
		
		int m = sc.nextInt();
		int[] customer = new int[m];
		for(int i=0;i<m;i++)
			customer[i] = sc.nextInt();
		
		int takoIndex = 0;
		boolean isSoldout = true;
		for(int i=0;i<m;i++){
			while(true){
				if(tako.length <= takoIndex){
					isSoldout =false;
					break;
				}else if(tako[takoIndex] > customer[i]){
					isSoldout = false;
					break;
				}else if(tako[takoIndex]+t < customer[i]){
					takoIndex++;
				}else{
					break;
				}
			}
			if(!isSoldout)
				break;
			takoIndex++;
		}
		
		if(isSoldout)
			System.out.println("yes");
		else
			System.out.println("no");
		
	}
}