
import java.util.Date;
import java.util.*;
import java.util.Scanner;

public class Time {

	public static void main(String[] args) {
		Time t = new Time();
		t.month();
		t.year();
		t.date();
		t.mon_days(month);
		/*
		 * System.out.println(days); System.out.println(month);
		 * System.out.println(year); System.out.println(dd);
		 */

		Scanner scan = new Scanner(System.in);
		// String s = scan.next();
		System.out.println("Enter the number");
		int i = scan.nextInt();
		// System.out.println(i);

		if (i > 0) {
			t.positive_number(i);
		} else if (i == 0) {
			t.zero_number(i);
		} else if (i < 0) {
			t.negative_number(i);
		}

	}
	
	public static int isLeapYear(int month) {
		boolean temp;
		temp = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
		if (temp) {
			return dd + 1;
		}else {
			return dd ;
		}
		}

	public void positive_number(int number) {
		int nextMonth;
		String answer;
		int val;
		int temp;
		int n = number;// input number
		
		while (n >= mon_days(month)) {
			nextMonth = month + 1;
			val = mon_days(nextMonth);
			temp = n - val;
			n = temp;
			month++;
			// System.out.println(month);
			if (dd == 31 && month == 12) {
				reset();
		}
		if (n <= mon_days(month)) {
			dd = dd + n;
			if (dd > 30) {
				month++;
				dd = dd - mon_days(month);
			
			}
			}
		}
		answer = dd + "/" + month + "/" + year;
		System.out.println(answer);
	}

	public void zero_number(int number) {
		String answer;
		
		answer = dd + "/" + month + "/" + year;
		System.out.println(answer);

	}

	public void negative_number(int number) {
		int lastMonth;
		String answer;
		int val;
		int temp;
		int n = number;// input number
		//System.out.println(n);
		
		while (n <= -mon_days(month)) {
			lastMonth = month - 1;
			val = mon_days(lastMonth);
			temp = n + val;
			n = temp;
			month--;
		  // System.out.println(month);
		}
		if (n >= -mon_days(month)) {
			lastMonth = month - 1;
			val = dd + n;
			dd = val;
			//System.out.println(dd);
			if (val <= 0) {
				month--;
				dd = mon_days(lastMonth) + val;

			}
			
		}
		answer = dd + "/" + month + "/" + year;
		System.out.println(answer);

	}

	public void reset() {
		year = year + 1;
		month = 1;
		dd = 1;
	}
	
	public int mon_days(int n) {
		int temp;
		Hashtable<Integer, Integer> mon = new Hashtable<Integer, Integer>();
		mon.put(1, 31);
		mon.put(2, 28);
		mon.put(3, 31);
		mon.put(4, 30);
		mon.put(5, 31);
		mon.put(6, 30);
		mon.put(7, 31);
		mon.put(8, 31);
		mon.put(9, 30);
		mon.put(10, 31);
		mon.put(11, 30);
		mon.put(12, 31);
		if(n == 2) {
			temp = isLeapYear(year);
			//days = mon.get(n);
			return temp;
		}
		days = mon.get(n);
		return days;
	}

	public int month() {
		Date date = new Date();
		month = 1 + date.getMonth();
		return month;
	}

	public int year() {
		Date date = new Date();
		year = 1900 + date.getYear();
		return year;
	}

	public int date() {
		Date date = new Date();
		dd = date.getDate();
		return dd;
	}

	private static int month;
	private static int year;
	private static int dd;
	private static int days;
}
