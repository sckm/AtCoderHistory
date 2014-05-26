package beginner.contest004.d;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] marble = new int [3];
		for(int i=0;i<3;i++)
			marble[i] = sc.nextInt();
		
		int leftEdge = 0;
		int rightEdge = 0;

		
		int res = 0;
		
		if(marble[1]<200){
			int half = marble[1]/2;
			if(marble[1]%2 == 0){
				if(marble[0]<marble[2]){
					leftEdge = half;
					leftEdge = half-1;
					res += calcNumMove(-half, half-1);
				}
			}else{
				leftEdge = half;
				leftEdge = half;
				res += calcNumMove(-half, half);
			}
		}else{
			boolean isPos = true;
			if(marble[0]<marble[2]){
				isPos =false;
			}
			
			res += calcNumMove(-99, marble[1]-99);
			if(isPos){
				rightEdge= marble[1]-100;
				leftEdge = -99;
			}else{
				rightEdge=99;
				leftEdge = (-1)*(marble[1]-100);
			}
		}

		if(marble[0]/2 < (leftEdge+99)){
			marble[0]--;
			res+=calcNumMove((-1)*(marble[0]/2+marble[0]%2), marble[0]/2);
		}else{
			res += (marble[0]*(-99-leftEdge));
			res += calcNumMove(0,marble[0]-1);
		}

		if(marble[2]/2 < (100-rightEdge)){
			marble[2]--;
			res+=calcNumMove((-1)*(marble[2]/2+marble[2]%2), marble[2]/2);
		}else{

			res += (marble[2]*(rightEdge-99));
			res += calcNumMove(0,marble[2]-1);
		}
		
		System.out.println(res+"");
	}
	
	// マーブルの初期位置を0にする時
	static private int calcNumMove(int left, int right){
		int res=0;
		if(right<0){
			res = res + (-1)*right*(right-left+1);
			for(int i=left;i<=right;i++)
				res += (i-left);
		}else if(0<left){
			res = res + (right-left+1)*left;
			for(int i=left;i<=right;i++)
				res += i-left;

		}else{
			for(int i=left;i<0;i++)
				res += i-left+1;
			for(int i=0;i<=right;i++)
				res += i;
		}
		return res;
	}
}