
public class Calendar1 {	
  
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

	int debugDaysCounter = 1; 
	int countSunday = 0; 
    curDay = 1;
	curMonth = 1;
	curYear = 1900; 
    curDayOfWeek = 2; 

	while (curYear < endYear ) { 
		System.out.print(curDayOfWeek+"/"+curMonth+"/"+curYear); 

		if (debugDaysCounter % 7 == 0) 
		System.out.print(" Sunday"); 

		if(curDayOfWeek == 1 && curDay == 1) 
		countSunday++; 

		System.out.println(); 
		advance();

		debugDaysCounter++; 
	}
		System.out.println("During the 20th century, " + countSunday + " Sundays fell on the first day of the month");
		
	

		}
      
		public static void advance() {
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

            if(curMonth > 12) {
				curMonth = 1; 
				curYear++;
			}
		}

		
	private static boolean isLeapYear(int year) {
	    boolean isLeapYear =  ( year % 400 == 0 || year % 4 == 0 && year % 100 != 0 ); 
	   
		return isLeapYear; 
	}
	

	 
	
	private static int nDaysInMonth(int month, int year) {
		int nDays;
		switch (month) {
			case 4,6,9,11: 
			nDays = 30;
				break;

			case 2: 
			nDays = isLeapYear(year) ? 29 : 28;
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


		
