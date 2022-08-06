import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DocFileHandler implements Handler{
    private static final String DOC = "doc";
    private Handler handler;
    private String handlerName;
    private Logger logger;

    public DocFileHandler(String handlerName) {
        this.logger = Logger.getLogger("DocFileLogger");
        this.handlerName = handlerName;
    }

    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void process(File file) {
        if(file.getType().equals(DOC)){
            logger.log(Level.INFO, "Process and saving doc file by {}", handlerName);
        } else if (Objects.nonNull(handler)){
            logger.log(Level.INFO, handlerName + " forwards request to " + handler.getHandlerName());
            handler.process(file);
        } else {
            logger.log(Level.WARNING, "File not supported!");
        }
    }

    @Override
    public String getHandlerName() {
        return handlerName;
    }
}
