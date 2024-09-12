package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		
		System.out.print("How much money you are bringing every day:");
		int startAmount = in.nextInt();
		
		System.out.print("The winning chance is (use decimal from 0 to 1):");
		double winChance = in.nextDouble();
		
		System.out.print("I am successful after reaching this amount today:");
		double winLimit = in.nextDouble();
		
		System.out.print("The total simulation is:");
		int totalSimulation = in.nextInt();
		
		int losses = 0;
		for (int s = 1; s <= totalSimulation; s +=1) { 
			int plays = 0;
			int i = startAmount;
			while (i > 0  && i < winLimit) {
				double result = Math.random();
				if (result >= 0 && result < winChance) {
					i += 1;
				}
				else {
					i -= 1;
				}
				plays += 1;
			}
			if (i == 0) {
				 System.out.println("Simulation" + s + ": " + plays + " LOSE");
				 losses += 1;
			}
			else {
				System.out.println("Simulation" + s + ": " + plays + " WIN");
			}
		}
		System.out.println("Losses: " + losses + " Simulations: " + totalSimulation);
		double ruinRateExpect = 1 - startAmount/winLimit;
		double ruinRateSimulation = (double)losses/totalSimulation;
		System.out.println("Ruin Rate from Simulation: " + ruinRateSimulation + " Expected Ruin Rate: " + ruinRateExpect);
	}

}
