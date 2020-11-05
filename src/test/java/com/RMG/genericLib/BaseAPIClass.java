package com.RMG.genericLib;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import static io.restassured.RestAssured.*;
/**
 * 
 * @author Nitheesha
 *
 */
public class BaseAPIClass {
	
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports reports;
	public static ExtentTest test;
	public ConnectoDB dLIb=new ConnectoDB();
	@BeforeSuite
	public void configBS() throws Throwable {
		
		htmlReport=new ExtentHtmlReporter("./ExtentReport.html");
		htmlReport.config().setDocumentTitle("RMG API Testing");
		htmlReport.config().setReportName("RMG YANTRA");
		
		reports=new ExtentReports();
		reports.attachReporter(htmlReport);
		reports.setSystemInfo("Application", "RMG YANTRA");
		reports.setSystemInfo("BaseURI", "http://localhost:8084");
		reports.setSystemInfo("DataBaseInfo", "MySQL");
		reports.setSystemInfo("Platform", "Windows 10");
		reports.setSystemInfo("Reporter", "NitheshGowda");
		
		dLIb.getConnectionToDB();
		
		baseURI="http://localhost:8084/";
	}
	@AfterMethod
	public void configAM(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");
		}else if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
			test.log(Status.FAIL, result.getThrowable());
		}else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, result.getMethod().getMethodName()+" is Skipped");
			test.log(Status.SKIP, result.getThrowable());
		}
	}
	
	@AfterSuite
	public void configAS() throws Throwable {
		reports.flush();
		dLIb.closeDB();
	}

}
