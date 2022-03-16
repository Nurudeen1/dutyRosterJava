//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.*;
import java.sql.SQLException;
public class Log4j {
    static Logger log = Logger.getLogger(Log4j.class.getName());
    public static void main(String[] args) {
    log.info("Hello World");
    log.info("Hey");
    log.error("kknknknknk", new RuntimeException("jljkjlj"));
    }
}
