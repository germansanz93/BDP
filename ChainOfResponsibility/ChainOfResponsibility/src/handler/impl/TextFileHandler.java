package handler.impl;

import client.File;
import handler.Handler;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextFileHandler implements Handler {
    private static final String TEXT = "text";
    private Handler handler;
    private String handlerName;
    private Logger logger;

    public TextFileHandler(String handlerName) {
        this.handlerName = handlerName;
    }

    @Override
    public void setHandler(Handler handler) {
        this.logger = Logger.getLogger("TextFileLogger");
        this.handler = handler;
    }

    @Override
    public void process(File file) {
        if(file.getType().equals(TEXT)){
            logger.log(Level.INFO, "Process and saving text file by " + handlerName);
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
