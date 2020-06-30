package killer_sudoku_calculator.main;

import java.util.ArrayList;

public class SumsCalculator {
	
	public static ArrayList<ArrayList<Integer>> findViableSums(int tot, int blocks){
		ArrayList<ArrayList<Integer>> a = recursiveSummer(new ArrayList<ArrayList<Integer>>(), tot, blocks, new ArrayList<Integer>());
		return a;
	}
	
	private static ArrayList<ArrayList<Integer>> recursiveSummer(ArrayList<ArrayList<Integer>> sums, int tot, int blocks, ArrayList<Integer> current){
		if(blocks == 1){ 
			for(int k = 0; k < current.size(); k++) {
				if(current.get(k) == tot) return sums;
			}
			if(tot > 9) return sums;
			current.add(tot);
			SumsCalculator.orderLeastToGreatest(current);
			for(int z = 0; z < sums.size(); z++) {
				ArrayList<Integer> comp = sums.get(z);
				if(current.equals(comp)) return sums;
			}
			sums.add(current);
			return sums;
		}
		int i;
		for(i = 1; i < 10; i++) {
			boolean shouldContinue = false;
			if(tot-i == 0) break; //don't check for negative numbers
			ArrayList<Integer> b = new ArrayList<Integer>();
			for(int j = 0; j < current.size(); j++) {
				if(i==current.get(j)) {
					shouldContinue = true;
					break;
				}
				b.add(current.get(j));
			}
			if(shouldContinue == true) continue;
			b.add(i);
			recursiveSummer(sums, tot-i, blocks-1, b); //recurse
		}
		return sums;
	}
	
	private static ArrayList<Integer> orderLeastToGreatest(ArrayList<Integer> begin){
		boolean fired = false;
		for(int x = 0; x+1 < begin.size(); x++) {
			if(begin.get(x) > begin.get(x + 1)) {
				int a = begin.get(x);
				begin.set(x, begin.get(x+1));
				begin.set(x+1, a);
				fired = true;
			}
		}
		if(fired) orderLeastToGreatest(begin);
		return begin;
	}	
}
