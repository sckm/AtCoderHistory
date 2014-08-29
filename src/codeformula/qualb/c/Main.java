package codeformula.qualb.c;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main p = new Main();
	}
 
	public Main() {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		solve(a, b);
	}
 
	public void solve(String a, String b) {
		int[] alphaCount = new int[26];
		StringBuilder na = new StringBuilder();
		StringBuilder nb = new StringBuilder();
		for(int i=0;i<a.length();i++){
			alphaCount[a.charAt(i)-'a']++;
			if(a.charAt(i)!=b.charAt(i)){
				na.append(a.charAt(i));
				nb.append(b.charAt(i));
			}
		}
		
		if(na.length() != nb.length() || na.length()>6 || na.length()==1){
			System.out.println("NO");
			return;
		}else if(na.length()==0){
			boolean isOk = false;
			for(int i=0;i<alphaCount.length;i++){
				if(alphaCount[i]>=2)
					isOk = true;
			}
			if(isOk)
				System.out.println("YES");
			else
				System.out.println("NO");
			return;
		}else if(na.length()==2){
			if(na.charAt(0)==nb.charAt(1) && na.charAt(1)==nb.charAt(0))
				System.out.println("YES");
			else
				System.out.println("NO");
			return;
		}
		
		for(int i=0;i<na.length();i++){
			if(alphaCount[na.charAt(i)-'a']>=2){
				na.append(na.charAt(i));
				nb.append(na.charAt(i));
				break;
			}
		}
		if(rec(0, 3, na, nb)){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
	}
 
	private boolean rec(int n, int sw, StringBuilder a, StringBuilder b){
		if(n>=3)
			return a.toString().equals(b.toString());
		
		boolean res = false;
		int cur = 3;
		while(!res && cur < (1<<a.length())){
			int hb = Integer.highestOneBit(cur);
			int s0 = 0;
			while(hb != 1){
				hb >>= 1;
				s0++;
			}
			int lb = Integer.lowestOneBit(cur);
			int s1 = 0;
			while(lb != 1 ){
				lb >>= 1;
				s1++;
			}
			swap(a, s0, s1);

			res |= rec(n+1, cur, a, b);
			
			swap(a, s0, s1);
			
			cur++;
			while(Integer.bitCount(cur)!=2)
				cur++;
			
		}
		
		
		return res;
		
	}
	
	private void swap(StringBuilder a, int i, int j){
		char c = a.charAt(i);
		a.setCharAt(i, a.charAt(j));
		a.setCharAt(j, c);
	}
}