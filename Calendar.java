
public class Calendar {	
  
	static int curMonth;
	static int curDay;
	static int curYear;
	static int endYear = 2000; 
	static int curDayOfWeek; 
	static int nDaysInMonth; 
	static boolean isLeapYear; 
	static int nDays; 
	static int countSunday = 0;

	public static void main(String args[]) { 
    int givenYear = Integer.parseInt(args[0]);
	int debugDaysCounter = 1; 
	int countSunday = 0; 
    curDay = 1;
	curMonth = 1;
	curYear = 1900; 
    curDayOfWeek = 2; 

	while (curYear <= givenYear ) { 
		if(curYear == givenYear) {
		System.out.print(curDayOfWeek+"/"+curMonth+"/"+curYear); 

		if (debugDaysCounter % 7 == 0) 
		System.out.print(" Sunday"); 


		System.out.println(); 
		advance();
		}
		debugDaysCounter++; 
	} 
	
	

		}
      
		public static void advance() {
            for(curMonth = 1; curMonth <= 12; curMonth++) {
           
			if(curDayOfWeek < 7)
			curDayOfWeek++; 
			else 
			curDayOfWeek = 1; 


			if (curDay < nDaysInMonth(curMonth, curYear)){
			curDay++ ;
			} else {
			curDay = 1; 
			curMonth++; 
			}

		}}

		
	private static boolean isLeapYear(int year) {
	    boolean isLeapYear =  ( year % 400 == 0 || year % 4 == 0 && year % 100 != 0 ); 
	   
		return isLeapYear; 
	}
	

	 
	
	private static int nDaysInMonth(int curMonthonth, int curYearear) {
		int nDays;
		switch (curMonthonth) {
			case 4,6,9,11: 
			nDays = 30;
				break;

			case 2: 
			nDays = isLeapYear(curYear) ? 29 : 28;
		       break;

			case 1,3,5,7,8,10,12: 
			nDays = 31; 
			   break;

			default: 
			nDays = 0; 
			System.out.println("Invalid month") ; 
				break;
		}
		return nDays;
	}
}


		
