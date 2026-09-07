package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
	
	private static ExtentReports extent;
	private static final String path = System.getProperty("user.dir")+"/test-output/extent-reports/extent-report.html";
	
	public static ExtentReports getInstance() {
		if(extent==null) {
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Pradeep QA");
			reporter.config().setDocumentTitle("Automation report");
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
		return extent;
	}

}
