package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingUtils {

    private static final Logger logger = LogManager.getLogger(LoggingUtils.class);

    public static void logInfo(String message) {
        logger.info(message);
    }

    public static void logError(String message) {
        logger.error(message);
    }

    // New method for logging warnings
    public static void logWarn(String message) {
        logger.warn(message);
    }
}
