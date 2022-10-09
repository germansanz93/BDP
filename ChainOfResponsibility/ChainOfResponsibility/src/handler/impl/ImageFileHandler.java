package handler.impl;

import handler.Handler;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import client.File;

public class ImageFileHandler implements Handler {
    private static final String IMG = "img";
    private Handler handler;
    private String handlerName;
    private Logger logger;

    public ImageFileHandler(String handlerName) {
        this.logger = Logger.getLogger("ExcelFileLogger");
        this.handlerName = handlerName;
    }

    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void process(File file) {
        if(file.getType().equals(IMG)){
            logger.log(Level.INFO, "Process and saving img file by " + handlerName);
        } else if (Objects.nonNull(handler)){
            logger.log(Level.INFO, handlerName + " forwards request to " + handler.getHandlerName());
            handler.process(file);
        } else {
            logger.log(Level.WARNING, "client.File not supported!");
        }
    }

    @Override
    public String getHandlerName() {
        return handlerName;
    }
}
