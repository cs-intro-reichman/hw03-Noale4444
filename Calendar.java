public class Calendar {    
  
    static int curMonth;
    static int curDay;
    static int curYear;
    static int curDayOfWeek; 
    static int nDaysInMonth; 
    static int nDays; 
    

    public static void main(String args[]) { 
        int givenYear = Integer.parseInt(args[0]);
        int debugDaysCounter = 1;
        curDay = 1;
        curMonth = 1;
        curYear = 1900; 
        curDayOfWeek = 2; 

        while (curYear < givenYear || (curYear == givenYear && curMonth <= 12)) { 
            if (curYear == givenYear) 
                System.out.print(curDay+"/"+curMonth+"/"+curYear); 
            
            if (debugDaysCounter % 7 == 0 && curYear == givenYear) 
                System.out.print(" Sunday"); 
            
			if(curYear == givenYear) 	
            System.out.println(); 

            advance();

            debugDaysCounter++; 
        }
    } 
    
    
	public static void advance() {
		if (curDayOfWeek < 7)
			curDayOfWeek++;
		else
			curDayOfWeek = 1;
		
		if (curDay < nDaysInMonth(curMonth, curYear)) 
			curDay++;
		else {
			curDay = 1;
			curMonth++;
			curDayOfWeek = 1;  
		} 
	
		if (curMonth > 12){
			curYear++;
			curMonth = 1;
	}
}
	
    
    private static boolean isLeapYear(int curYear) {
	// #feedback - isLeapYear is redundant, you can return its value directly -
	// return (curYear % 400 == 0 || curYear % 4 == 0 && curYear % 100 != 0);
        boolean isLeapYear =  (curYear % 400 == 0 || curYear % 4 == 0 && curYear % 100 != 0); 
        return isLeapYear; 
    }

    private static int nDaysInMonth(int curMonth, int curYear) {
        int nDays;
        switch (curMonth) {
            case 4, 6, 9, 11: 
                nDays = 30;
                break;

            case 2: 
                nDays = isLeapYear(curYear) ? 29 : 28;
                break;

            case 1, 3, 5, 7, 8, 10, 12: 
                nDays = 31; 
                break;

            default: // #feedback - this case is not supported, so it is better to define the default as 31 days (and remove the related case).
                nDays = 0; 
                break;
        }
        return nDays;
    }
}
