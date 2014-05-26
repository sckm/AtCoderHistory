package beginner.contest019.b;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		int differentCount = 0;
		int size = s.length();
		int res = 1;
		int mid = size>>1;
		for(int i=0;i<mid;i++){
			if(s.charAt(i) != s.charAt(size-i-1)){
				differentCount++;
				if(differentCount>=2)
					break;
			}
		}
		
		if(differentCount>=2){
			res = size * 25;
		}else if(differentCount == 1){
			res = 24*2 + 25*(size-2); 
		}else{
			res = 25*(size>>1)*2;
		}
		System.out.println(res);
		
	}
}