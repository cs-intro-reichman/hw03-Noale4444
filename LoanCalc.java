
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
		while(endBalance(loan, rate, n, g) > 0) {
			g += epsilon;
			iterationCounter++;
		}
    	return g;
    }
    
   
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		
		double H = loan;
		double L = loan / n;
		double g = (L + H) / 2;
		iterationCounter = 0;
		while ((H - L) > epsilon) {
			// Sets L and H for the next iteration
			if (endBalance(loan, rate, n, g) * endBalance(loan, rate, n, L) > 0 ) {
				L = g;
			} else {
				H = g;
			}
			g = (L + H) / 2;
			iterationCounter++;
		}
		return g;
    }
	
	
	private static double endBalance(double loan, double rate, int n, double payment) {
		int i = 0;
		while(loan > 0 && i < n) { // #feedback - we can have a negative balance, so you can just iterate over all the payments. 
			loan = (loan - payment) * ((rate / 100) + 1);
			i++;
		}
		return loan;	
	}
}
