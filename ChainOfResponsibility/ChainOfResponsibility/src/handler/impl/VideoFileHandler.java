package handler.impl;

import client.File;
import handler.Handler;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VideoFileHandler implements Handler {
    private static final String VIDEO = "video";
    private Handler handler;
    private String handlerName;
    private Logger logger;

    public VideoFileHandler(String handlerName) {
        this.logger = Logger.getLogger("VideoFileLogger");
        this.handlerName = handlerName;
    }

    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void process(File file) {
        if(file.getType().equals(VIDEO)){
            logger.log(Level.INFO, "Process and saving video file by {}", handlerName);
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
