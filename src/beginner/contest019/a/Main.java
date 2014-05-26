package beginner.contest019.a;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		
		str = str.replace('O', '0')
				.replace('D', '0')
				.replace('I', '1')
				.replace('Z', '2')
				.replace('S', '5')
				.replace('B', '8');
		
		System.out.println(Integer.parseInt(str));
	}
}