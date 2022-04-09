package base;

public enum Params {

    ENVIRONMENT("environment"),
    GRID("grid"),
    NODE_URI("node-uri"),
    BROWSER("browser"),
    URI("uri"),
    USERNAME("username"),
    PASSWORD("password"),
    WEBDRIVER("WebDriver");

    public String param;

    Params(String param){
        this.param = param;
    }

}
