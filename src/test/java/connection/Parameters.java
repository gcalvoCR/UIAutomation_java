package connection;

import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import java.util.Map;

public class Parameters implements XmlParameters{


    private Map<String, String> parameters;

    public Parameters(ITestContext context) {
        XmlSuite suite = context.getSuite().getXmlSuite();
        parameters = suite.getParameters();
    }

    @Override
    public String getEnvironment() {
        return parameters.get(Params.ENVIRONMENT.param);
    }

    @Override
    public String getGrid() {
        return parameters.get(Params.GRID.param);
    }

    @Override
    public String getNodeUri() { return parameters.get(Params.NODE_URI.param); }

    @Override
    public String getBrowser() {
        return parameters.get(Params.BROWSER.param);
    }

    @Override
    public String getUri() {
        return parameters.get(Params.URI.param);
    }

    @Override
    public String getUsername() {
        return parameters.get(Params.USERNAME.param);
    }

    @Override
    public String getPassword() {
        return parameters.get(Params.PASSWORD.param);
    }

}
