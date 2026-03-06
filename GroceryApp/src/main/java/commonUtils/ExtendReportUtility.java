package commonUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.ConstantClass;

public class ExtendReportUtility 
{
	public static final ExtentReports extentReports = new ExtentReports();

	public synchronized static ExtentReports createExtentReports() 
	{
		ExtentSparkReporter reporter = new ExtentSparkReporter(ConstantClass.ReportPath);
		reporter.config().setReportName(ConstantClass.ReportName);
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo(ConstantClass.ReportSysInfoOrg,ConstantClass.ReportSysInfoOrgName);
		extentReports.setSystemInfo(ConstantClass.ReportSysInfoName,ConstantClass.ReportSysInfoNameVal);
		return extentReports;
	}
	
}
