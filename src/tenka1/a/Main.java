package tenka1.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main p = new Main();
	}

	public Main() {
//		Scanner sc = new Scanner(System.in);
		solve();
	}

	public void solve() {
		ArrayList<String> numStrs = new ArrayList<String>(1001);
		for(int i=1;i<=1000;i++){
			numStrs.add(i+"");
		}
		
		Collections.sort(numStrs, new NumStringComparator());
		for(int i=0;i<numStrs.size();i++){
			System.out.println(numStrs.get(i));
		}
		
	}
	
	private class NumStringComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
		
	}

}
