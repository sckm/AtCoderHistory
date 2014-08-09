package tenka1.b;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main p = new Main();
	}

	public Main() {
		solve();
	}

	public void solve() {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		PriorityQueue<Kaburin> damageQueue = new PriorityQueue<Kaburin>(10000, new KaburinDamageComparator());
		PriorityQueue<Kaburin> returnQueue = new PriorityQueue<Kaburin>(5, new KaburinDamageComparator());
		int combo = 0;
		int kaburin = 5;
		long damage = 0;
		double wait = -1;
		for(int i=0;i<input.length();i++){
			while(!damageQueue.isEmpty() && damageQueue.peek().damageTime<i){
				Kaburin kabu = damageQueue.poll();
				if(kabu.isNormal)
					damage += 10*(1+Math.floor(kabu.combo/10)*0.1);
				else
					damage += 50*(1+Math.floor(kabu.combo/10)*0.1);
//				System.out.println(combo + " " + damage);
				combo++;
				returnQueue.add(kabu);
			}
			
			while(!returnQueue.isEmpty() && returnQueue.peek().damageTime+5 < i){
				Kaburin kabu = returnQueue.poll();
				if(kabu.isNormal)
					kaburin++;
				else
					kaburin += 3;
			}
			
//			System.out.println(i + " " + kaburin + " " + combo + " " + damage);
			if(kaburin<=0 || wait>i)
				continue;
			
			if(input.charAt(i)=='N'){
				damageQueue.add(new Kaburin('N', combo, i, i+1.5));
				kaburin--;
			}else if(input.charAt(i)=='C' && kaburin>=3){
				damageQueue.add(new Kaburin('C', combo, i, i+3.5));
				wait = i+2.5;
				kaburin-=3;
			}
		}
		
		while(!damageQueue.isEmpty()){
			Kaburin kabu = damageQueue.poll();
			if(kabu.isNormal)
				damage += 10*(1+Math.floor(kabu.combo/10)*0.1);
			else
				damage += 50*(1+Math.floor(kabu.combo/10)*0.1);
			combo++;
			returnQueue.add(kabu);
		}
		
		
		System.out.println(damage);
	}
	
	private class Kaburin{
		boolean isNormal;
		int combo;
		int inputTime;
		double damageTime;
		
		public Kaburin(char c, int combo, int inputTime, double damageTime){
			if(c=='N')
				isNormal = true;
			else
				isNormal = false;
			
			this.combo = combo;
			this.inputTime = inputTime;
			this.damageTime = damageTime;
		}
	}
	
	private class KaburinDamageComparator implements Comparator<Kaburin>{
		@Override
		public int compare(Kaburin o1, Kaburin o2) {
			if(o1.damageTime<o2.damageTime){
				return (int)(o1.damageTime - o2.damageTime);
			}else{
				return o1.inputTime - o2.inputTime;
			}
		}
	}
}
