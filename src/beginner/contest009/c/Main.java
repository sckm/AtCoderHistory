package beginner.contest009.c;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main p = new Main();
	}

	public Main() {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int k = Integer.parseInt(sc.next());
		String s = sc.next();
		solve(k, s);
	}

	public void solve(int k, String s) {
		int changeCount = 0;
		
		StringBuilder sb = new StringBuilder(s);
		char cur = 'a';
		boolean isChanged = false;
		while(changeCount<k){
			int last = sb.lastIndexOf(cur+"");

			for(int j=0;j<last;j++){
				if(sb.charAt(j)>cur){
					String temp = sb.toString();
					swap(sb, j, last);
					changeCount=0;
					for(int i=0;i<s.length();i++){
						if(sb.charAt(i)!=s.charAt(i))
							changeCount++;
					}
					if(changeCount>k){
						sb = new StringBuilder(temp);
						changeCount=0;
					}else{
						isChanged=true;
						break;
					}
				}
			}
			if(!isChanged){
				cur++;
				if(cur>='z')
					break;
			}
			isChanged = false;
		}
		
		System.out.println(sb.toString());
		
	}
	
	private void swap(StringBuilder sb, int a, int b){
		char w = sb.charAt(a);
		sb.setCharAt(a, sb.charAt(b));
		sb.setCharAt(b, w);
	}

}
