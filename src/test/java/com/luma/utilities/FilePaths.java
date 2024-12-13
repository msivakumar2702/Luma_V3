package com.luma.utilities;

public class FilePaths {

    private static final String PROJECT_DIR = System.getProperty("user.dir");
    
    // Paths for test data files
    public static final String CUSTOMER_DETAILS_EXCEL = PROJECT_DIR + "/testData/CustomerDetails.xlsx";
    public static final String PRODUCT_DETAILS_EXCEL = PROJECT_DIR + "/testData/ProductDetails.xlsx";

    // Paths for resource files
    public static final String AD_BLOCKER_EXTENSION = PROJECT_DIR + "/src/test/resources/CRX_ext/ublockExt.crx";
    public static final String TEST_DATA_PROPERTIES = PROJECT_DIR + "/src/test/resources/config.properties";

    // Paths for logs and reports
    public static final String LOG_FILE = PROJECT_DIR + "/logs/testLogs.log";
    public static final String REPORT_DIRECTORY = PROJECT_DIR + "/reports/";

    // Paths for Extent Reports
    public static final String EXTENT_REPORT_DIRECTORY = PROJECT_DIR + "/reports/";
    
    // You can also add a default report file name if required
    public static final String EXTENT_REPORT_FILE_NAME = "Test-Report.html";


    // Screenshot directory
    
    public static final String SCREENSHOT_DIRECTORY = PROJECT_DIR + "/screenshots/";
}
