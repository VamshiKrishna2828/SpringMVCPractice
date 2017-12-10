package dummy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateFormatTest {

	public static void main(String[] args) throws ParseException {

		String scheduleStartDate = "2017-11-04";
		String scheduleEndDate = "2018-01-6";

		Date requirementStartDate = null;
		Date requirementEndDate = null;
		Date designStartDate = null;
		Date designEndDate = null;
		Date constructionStartDate = null;
		Date constructioEndDate = null;
		Date testingStartDate = null;
		Date testingEndDate = null;
		Date releaseStartDate = null;
		Date releaseEndDate = null;
		
		// RequirementStartDate is ScheduleStartDate and ReleaseEndDate is ScheduleEndDate
		
		requirementStartDate = new SimpleDateFormat("yyyy-MM-dd").parse(scheduleStartDate);

		String requirementStartDay = new SimpleDateFormat("EE").format(requirementStartDate);
		System.out.println(requirementStartDay);

		if (requirementStartDay.equals("Sun")) {
			requirementStartDate = addDays(requirementStartDate, 1);
		}

		else if (requirementStartDay.equals("Sat")) {
			requirementStartDate = addDays(requirementStartDate, 2);
		}
		
		releaseEndDate = new SimpleDateFormat("yyyy-MM-dd").parse(scheduleEndDate);
		System.out.println("releaseEndDate before : "+releaseEndDate);

		// Checking ReleaseEndDate falls on Saturday or Sunday
		if ((new SimpleDateFormat("EE").format(releaseEndDate)).equals("Sun")) {
			releaseEndDate = addDays(releaseEndDate, -2);
		}

		else if ((new SimpleDateFormat("EE").format(releaseEndDate)).equals("Sat")) {
			System.out.println("in release end date");
			releaseEndDate = addDays(releaseEndDate, -1);
		}

		// ReleaseStartDate is 7 days before releaseenddate
		releaseStartDate = addDays(releaseEndDate, -7);
		// Checking ReleaseStartDate falls on Sunday or Saturday
		if ((new SimpleDateFormat("EE").format(releaseStartDate)).equals("Sun")) {
			releaseStartDate = addDays(releaseStartDate, 1);
		}

		else if ((new SimpleDateFormat("EE").format(releaseStartDate)).equals("Sat")) {
			releaseStartDate = addDays(releaseStartDate, 2);
		}

		// Testing End Date is 1 day before ReleaseStartDate
		testingEndDate = addDays(releaseStartDate, -1);

		// Checking TestingEndDate falls on Saturday or Sunday
		if ((new SimpleDateFormat("EE").format(testingEndDate)).equals("Sun")) {
			testingEndDate = addDays(testingEndDate, -2);
		}

		else if ((new SimpleDateFormat("EE").format(testingEndDate)).equals("Sat")) {
			testingEndDate = addDays(testingEndDate, -1);
		}

		/*System.out.println("duration " + TimeUnit.DAYS
				.convert(releaseEndDate.getTime() - requirementStartDate.getTime(), TimeUnit.MILLISECONDS));*/
		long duration = TimeUnit.DAYS.convert(releaseEndDate.getTime() - requirementStartDate.getTime(),
				TimeUnit.MILLISECONDS);

		// TestStartDate is 0.3% in duration of the project before TestEndDate
		testingStartDate = addDays(testingEndDate, -(int) (Math.ceil(duration * 0.3)));

		// Checking TestingStartDate falls on Sunday or Saturday
		if ((new SimpleDateFormat("EE").format(testingStartDate)).equals("Sun")) {
			testingStartDate = addDays(testingStartDate, 1);
		}

		else if ((new SimpleDateFormat("EE").format(testingStartDate)).equals("Sat")) {
			testingStartDate = addDays(testingStartDate, 2);
		}

		// ConstructionEndDate is 1 day before TestingStartDate
		constructioEndDate = addDays(testingStartDate, -1);

		// Checking ConstructionEndDate falls on Saturday or Sunday
		if ((new SimpleDateFormat("EE").format(constructioEndDate)).equals("Sun")) {
			constructioEndDate = addDays(constructioEndDate, -2);
		}

		else if ((new SimpleDateFormat("EE").format(constructioEndDate)).equals("Sat")) {
			constructioEndDate = addDays(constructioEndDate, -1);
		}

		// TestStartDate is 0.2% in duration of the project before TestEndDate
		constructionStartDate = addDays(constructioEndDate, -(int) (Math.ceil(duration * 0.2)));

		// Checking TestingStartDate falls on Sunday or Saturday
		if ((new SimpleDateFormat("EE").format(constructionStartDate)).equals("Sun")) {
			constructionStartDate = addDays(constructionStartDate, 1);
		}

		else if ((new SimpleDateFormat("EE").format(constructionStartDate)).equals("Sat")) {
			constructionStartDate = addDays(constructionStartDate, 2);
		}

		// Design end date is 1 day before Construction start date
		designEndDate = addDays(constructionStartDate, -1);

		// Checking ConstructionEndDate falls on Saturday or Sunday
		if ((new SimpleDateFormat("EE").format(designEndDate)).equals("Sun")) {
			designEndDate = addDays(designEndDate, -2);
		}

		else if ((new SimpleDateFormat("EE").format(designEndDate)).equals("Sat")) {
			designEndDate = addDays(designEndDate, -1);
		}

		// Design Start Date is 0.15% of duration before DesignEndDate
		designStartDate = addDays(designEndDate, -(int) (Math.ceil(duration * 0.15)));

		// Checking TestingStartDate falls on Sunday or Saturday
		if ((new SimpleDateFormat("EE").format(designStartDate)).equals("Sun")) {
			designStartDate = addDays(designStartDate, 1);
		}

		else if ((new SimpleDateFormat("EE").format(designStartDate)).equals("Sat")) {
			designStartDate = addDays(designStartDate, 2);
		}
		
		//Requirement End Date is 1 day before Design Start date
		requirementEndDate = addDays(designStartDate, -1);
		
		// Checking ConstructionEndDate falls on Saturday or Sunday
		if ((new SimpleDateFormat("EE").format(requirementEndDate)).equals("Sun")) {
			requirementEndDate = addDays(requirementEndDate, -2);
		}

		else if ((new SimpleDateFormat("EE").format(requirementEndDate)).equals("Sat")) {
			requirementEndDate = addDays(requirementEndDate, -1);
		}
		
		System.out.println("requirementStartDate : "+requirementStartDate);
		System.out.println("requirementEndDate : "+requirementEndDate);
		System.out.println("designStartDate : "+designStartDate);
		System.out.println("designEndDate : "+designEndDate);
		System.out.println("constructionStartDate : "+constructionStartDate);
		System.out.println("constructioEndDate : "+constructioEndDate);
		System.out.println("testingStartDate : "+testingStartDate);
		System.out.println("testingEndDate : "+testingEndDate);
		System.out.println("releaseStartDate : "+releaseStartDate);
		System.out.println("releaseEndDate : "+releaseEndDate);
		
	}

	public static Date addDays(Date date, int noOfDays) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, noOfDays);
		date = c.getTime();
		return date;
	}

}
