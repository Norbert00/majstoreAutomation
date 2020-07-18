package gui.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OwnLogger {

    private Logger logger;

    public OwnLogger() {
        this.logger = LogManager.getLogger();
    }

    public void setLoggerInfo(String newInfo) {
        logger.info(newInfo);
    }
}
