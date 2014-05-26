package beginner.contest019.c;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Main m = new Main();
	}
	
	public Main(){
		solve();
	}
	
	// x, y  最短距離
	int[][][] hokoraDp;
	String[] gameMap;
	int R;
	int C;
	int K;
	private void solve(){
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();

		gameMap = new String[R];
		Position vilPos = new Position();
		Position hokoraPos = new Position();
		for(int i=0;i<R;i++){
			gameMap[i] = sc.next();
			if(gameMap[i].contains("S")){
				vilPos.x = gameMap[i].indexOf('S');
				vilPos.y = i;
			}else if(gameMap[i].contains("C")){
				hokoraPos.x = gameMap[i].indexOf('C');
				hokoraPos.y = i;
			}
		}
		
		hokoraDp = new int[C][R][K+2];
		hokoraDp[vilPos.x][vilPos.y][0] = 0;
		calcToHokora(vilPos.x, vilPos.y, 0, 0);
		
		System.out.println("村" + vilPos.x+" "+vilPos.y);
		System.out.println("ほこら" + hokoraPos.x+" "+hokoraPos.y);
		
		int res=Integer.MAX_VALUE;
		for(int i=0;i<K;i++){
			if(hokoraDp[hokoraPos.x][hokoraPos.y][i]!=0)
				res = Math.min(res, hokoraDp[hokoraPos.x][hokoraPos.y][i]);
		}
		System.out.println(res);
			
	}
	
	private void calcToHokora(int x, int y, int encount, int count){
		count++;
		if(x<0 || C<=x || y<0 || R<=y || encount>=K){
			System.out.println(x+" "+y);
			return;
		}
		
		char curTikei = gameMap[y].charAt(x); 
		System.out.println(curTikei + ": calc " + x + " " +y);
		if(curTikei == 'C'){
			hokoraDp[x][y][encount] =  count;
			return;
		}else if(curTikei == 'T'){
			return;
		}else if(curTikei == 'E'){
			encount++;
		}
		
		if(hokoraDp[x][y][encount] == 0 || hokoraDp[x][y][encount] > count)
			hokoraDp[x][y][encount] =  count;
		else
			return;
		
		for(int i=-1;i<=1;i+=2){
			for(int j=-1;j<=1;j+=2){
				if(0<=x+i && x+i<C && 0<=y+j && y+j<R )
					calcToHokora(x+i, y+j, encount, count);
			}
		}
	}
	
	private class Position{
		public int x;
		public int y;
	}
}