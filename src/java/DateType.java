
public class DateType {

	int dMonth;
	int dDay;
	int dYear;
	
	public int getDate() {
		return dDay;
	}
	
	public int getMonth() {
		return dMonth;
	}
	
	public int getYear() {
		return dYear;
	}
	
	public void printDate(){
		System.out.println(dMonth+"-"+dDay+"-"+dYear);
	}
	
	public DateType(int dMonth, int dDay, int dYear) {
		setDate(dMonth, dDay, dYear);
	}
	
	public void setDate(int dMonth, int dDay, int dYear) {
		if(dYear <= 0) {
			this.dYear = 1900;
		} else {
			this.dYear = dYear;
		}
		
		if(dMonth <= 0 || dMonth > 12) {
			this.dMonth = 1;
		} else {
			this.dMonth = dMonth;
		}
		
		if(!isValid(dDay)) {
			this.dDay = 1;
		} else {
			this.dDay = dDay;
		}
		
	}

	private boolean isValid(int dDay) {
		boolean valid = true;
		if(dDay > 31 || dDay < 0) {
			return false;
		}
		if((this.dMonth == 4 || this.dMonth == 6 || this.dMonth == 9 || this.dMonth == 11) && dDay > 30) {
			return false;
		}
		if(this.dMonth == 2) {
			return (dDay > 29 || (dDay == 29 && !isLeapYear(this.dYear)))?false:true;
		}
		return valid;
	}

	private boolean isLeapYear(int dYear) {
		if(dYear % 400 == 0) {
			return true;
		} else if (dYear % 100 == 0) {
			return false;
		} else if(dYear % 4 == 0) {
			return true;
		}
		return false;
	}
	
	public static void main (String[] args) {
		DateType date = new DateType(2, 28,1901);
		date.printDate();
	}
}
