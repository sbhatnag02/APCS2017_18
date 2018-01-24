package net.mrpaul.pb050.ps09;

public class ChangeCalculator {
	
	public static int recursiveMinChange(int n, int[] coins) {
		if(n == 0) {
			return 0;
		}else {
			int[] differences = new int[coins.length];
			int numCoins = 0;
			for(int i = 0; i < coins.length; i++) {
				differences[i] = n - coins[i];
			}
			int[] solutions = new int[differences.length];
			for(int i = 0; i < differences.length; i++) {
				int solution = differences[i];
				if(solution == 0) {
					solutions[i] = 1;
					return 1;
				}else if(solution < 0) {
					solutions[i] = Integer.MAX_VALUE;
					differences[i] = Integer.MAX_VALUE;
				}else if(solution > 0) {
					solutions[i] = recursiveMinChange(differences[i], coins);
					numCoins++;
				}
			}
			int smallestDif = solutions[0];
			for(int i = 0; i < solutions.length; i++) {
				if(solutions[i] < smallestDif) {
					smallestDif = solutions[i];
				}
			}
			smallestDif++;
			return smallestDif;
		}
	}
	
	public static int dynamicMinChange(int n, int[] coins) {
		if(n == 0) {
			return 0;
		}
		else {
			for(int i = 0; i < coins.length; i++) {
				if(n%coins[i] == 0 && n/coins[i] == 1) {
					return 1;
				}
			}
			return 0; //placeholder
			
		}
	}
	
	public static void main(String[] args) {
		int[] coins = {1, 4, 6};
		System.out.println(dynamicMinChange(15, coins));
	}

}
