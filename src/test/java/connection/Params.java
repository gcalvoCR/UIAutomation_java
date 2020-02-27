package connection;

public enum Params {

    BROWSER("browser"),
    URI("uri"),
    TYPE("type"),
    NODE_URI("node-uri"),
    USERNAME("username"),
    PASSWORD("password");

    String param;

    Params(String param){
        this.param = param;
    }

}
