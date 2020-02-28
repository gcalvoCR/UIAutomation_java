package connection;

public enum Params {

    ENVIRONMENT("environment"),
    GRID("grid"),
    NODE_URI("node-uri"),
    BROWSER("browser"),
    URI("uri"),
    USERNAME("username"),
    PASSWORD("password");

    String param;

    Params(String param){
        this.param = param;
    }

}
