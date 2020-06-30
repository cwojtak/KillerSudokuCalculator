package killer_sudoku_calculator.main;

import java.util.ArrayList;
import java.util.Scanner;

public class KillerSudokuCalculator {

	public static void main(String[] args) {
		//userInput();
		Runnable r = () -> {
			try {
				automaticTest();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		//long startTime = System.currentTimeMillis();
		r.run();
		//long finishTime = System.currentTimeMillis();
		//System.out.println("Execution Time: " + (finishTime-startTime));
	}
	
	public static void userInput() {
		boolean e = true;
		Scanner c = new Scanner(System.in);
		while(e) {
			System.out.println("Number of blocks:\n");
			int x = c.nextInt();
			System.out.println("Total sum:\n");
			int i = c.nextInt();
			
			ArrayList<ArrayList<Integer>> a = SumsCalculator.findViableSums(i, x);
			System.out.println(a);
			
			System.out.println("Continue(y)?\n");
			String d = c.next();
			if(!d.equals("y")) {
				e = false;
			}
		}
		c.close();
	}
	
	public static void automaticTest() throws InterruptedException {
		for(int x = 1; x < 10; x++) {
			int q = KillerSudokuCalculator.getHighestSum(x);
			for(int y = 1; y <= q; y++) {
				System.out.println("Sum " + y + " over " + x + " blocks: " + SumsCalculator.findViableSums(y, x));
				Thread.sleep(300);
			}
			System.out.println("--------------------");
			Thread.sleep(2000);
		}
	}
	
	public static int getHighestSum(int b) {
		int sum = 0;
		int a = 9;
		for(int i = 0; i < b; i++) {
			sum += a;
			a--;
		}
		return sum;
	}
}
