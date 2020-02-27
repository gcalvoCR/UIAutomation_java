package java.connection;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

public class Baseclass {

    protected ITestContext context;

    @BeforeSuite
    public void setup(ITestContext context, String videoRecording) throws Exception {
        this.context = context;
        context = setParamaters(context, videoRecording);
        testRail = new TestRailService(context);
        runTestRail();
        if (videoRecording.equals("false")) {
            initializeDriver(null, context);
        }
    }

    private ITestContext setParamaters(ITestContext context) {
        GetParams param = new GetParams(context);
        context.setAttribute("auditlogsURL", param.getBaseURL() + "auditLogs");
        context.setAttribute("settingsURL", param.getBaseURL() + "settings");
        context.setAttribute("dashboardURL", param.getBaseURL() + "dashboard");
        context.setAttribute("fedcheckScanURL", param.getBaseURL() + "fedchecks");
        context.setAttribute("aboutURL", param.getBaseURL() + "about");
        context.setAttribute("helpURL", param.getBaseURL() + "help");
        context.setAttribute("campaingsURL", param.getBaseURL() + "campaigns");
        context.setAttribute("visitHistoryURL", param.getBaseURL() + "visitHistory");
        context.setAttribute("nodeURL", param.getNodeURL());
        context.setAttribute("browser", param.getBrowser());
        context.setAttribute("baseURL", param.getBaseURL());
        context.setAttribute("username", param.getUsername());
        context.setAttribute("password", param.getPassword());
        context.setAttribute("videoRecording", videoRecording);
        context.setAttribute("nonAdminUsername", param.getNonAdminUsername());
        context.setAttribute("happyFoxURL",param.getHappyFoxLink());
        context.setAttribute("appName", param.getAppName());

        // params for testRail
        context.setAttribute("suite_id", param.getSuiteId());
        context.setAttribute("testType", param.getTestType());
        context.setAttribute("section", param.getSection());
        context.setAttribute("milestone", param.getMilestone());
        return context;
    }

}
