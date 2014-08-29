package codeformula.qualb.a;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main p = new Main();
	}

	public Main() {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int res0 = 0;
		int res1 = 0;
		for(int i=n.length()-1;i>=0;i--){
			if((n.length()-i)%2==0)
				res0 += n.charAt(i)-'0';
			else
				res1 += n.charAt(i)-'0';
		}
		System.out.println(res0 +" "+res1);
			
		
	}

	public void solve() {
	}

}
