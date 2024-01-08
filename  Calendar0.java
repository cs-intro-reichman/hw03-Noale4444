public class Calendar0 {
	static int year; // year for which we want to construct a calendar
	static boolean isLeapYear; // true if year is a leap year
	static int days; // number of days in the month
	public static void main(String args[]) {
		year = Integer.parseInt(args[0]);
		isLeapYearTest(year);
		nDaysInMonthTest(year);
	}


	private static void isLeapYearTest(int year) {
		String commonOrLeap = "common";
		if (isLeapYear(year)) {
			commonOrLeap = "leap";
		}
		System.out.println(year + " is a " + commonOrLeap + " year");
	}

	private static void nDaysInMonthTest(int year) {
    for(int month = 1; month <= 12; month++){
		System.out.println("Month "+month+" has "+days+" days");
	}	
	}

	public static boolean isLeapYear(int year) {
	 isLeapYear = ((year % 400) == 0) || (((year % 4) == 0)&&((year % 100) != 0));

		return(isLeapYear);
    }  

	public static int nDaysInMonth(int month, int year) {

    switch (month) {
    case 1, 3, 5, 7, 8, 10:
		   days = 31;
		   break; 

    case 4, 6, 9, 11:
		   days = 30;
		   break;

	case 2: 
	      isLeapYear ? days = 28 : days = 29;	   		   
        break; 

	   difult: 
	   days = 0;
	   System.out.println("Invalid month");
	    break;
	
		return  (days);
	    }

	}
} 
	
	