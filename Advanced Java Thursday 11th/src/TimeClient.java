
import java.rmi.*;
import java.util.*;

public class TimeClient {

    public static void main(String [] args) {
        try {
            TimeService server = 
                 (TimeService) Naming.lookup("rmi://localhost/TimeServer");
            System.out.println(server.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

