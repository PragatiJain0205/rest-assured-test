package com.example;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseTestForExtentReport {
static ExtentReports extent ;
static ExtentTest test;

public static void setupReport (){
    ExtentSparkReporter spark =new ExtentSparkReporter("extent-report.html");
    extent = new ExtentReports();
    extent.attachReporter(spark);
}
public static void startTest(String testName) {
    test = extent.createTest(testName);
}
public static void flushReport() {
    extent.flush();
}
    
}



    

