package beginner.contest004.b;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		char[][] res = new char[4][4];
		for(int i=3;0<=i;i--){
			for(int j=3;0<=j;j--){
				res[i][j] = sc.next().charAt(0);
			}
		}
		
		for(int i=0;i<4;i++){
			for(int j=0;j<3;j++){
				System.out.print(res[i][j]);
			}
			System.out.println(res[i][3]);
		}
	}
}

