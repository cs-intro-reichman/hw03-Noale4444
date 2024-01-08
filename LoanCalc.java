
public class LoanCalc {
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter;    // Monitors the efficiency of the calculation
	
   
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}


	public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		double g = loan / n;
		iterationCounter = 0;
		while (endBalance(loan, rate, n, g) > epsilon) {
			g += epsilon;
			iterationCounter++;
		}
		return g;
	}


	
	public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
		iterationCounter = 0;
		double H = loan;
		double L = loan / n;
		double g = (L + H) / 2;
		while ((H - L) > epsilon) {
			if (endBalance(loan, rate, n, L) * endBalance(loan, rate, n, g) > 0) {
				L = g;
			} else {
				H = g;
			}
			g = (H + L) / 2; // Move this line outside the else block
			iterationCounter++;
		}
		return g;
	}
	
	
	
	private static double endBalance(double loan, double rate, int n, double payment) {
		for( int i = 0; i <= n; i++) {
			loan = (loan - payment) * (1+(rate / 100)) ; 
		}
    	return loan;
	}
}