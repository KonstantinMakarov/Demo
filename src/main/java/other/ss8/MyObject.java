package other.ss8;


public class MyObject {

    String env;
    String type;
    String port;
    String cmd;
    String headers;

    public MyObject(String env, String type, String port, String cmd, String headers) {
        this.env = env;
        this.type = type;
        this.port = port;
        this.cmd = cmd;
        this.headers = headers;
    }

    public void start(){
        System.out.println("Env: " + env + ", Type: " + type + "" + ", Port: " + port + ", CMD: " + cmd + ", Headers: " + headers);
    }
}
