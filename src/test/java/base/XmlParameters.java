package base;

public interface XmlParameters {

        String getEnvironment(); //local or grid
        String getGrid(); //standalone or docker
        String getNodeUri();
        String getBrowser();
        String getUri();
        String getUsername();
        String getPassword();

}

