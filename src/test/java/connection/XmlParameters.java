package connection;

public interface XmlParameters {

        String getUri();
        String getBrowser();
        String getUsername();
        String getPassword();
        String getType(); //Selenium grid or docker
        String getNodeUri();

}

