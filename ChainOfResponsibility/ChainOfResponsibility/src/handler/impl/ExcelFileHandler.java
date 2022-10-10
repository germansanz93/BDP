package handler.impl;

import client.File;
import handler.Handler;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExcelFileHandler implements Handler {
    private static final String EXCEL = "excel";
    private Handler handler;
    private String handlerName;
    private Logger logger;

    @Override
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ExcelFileHandler(String handlerName) {
        this.logger = Logger.getLogger("ExcelFileLogger");
        this.handlerName = handlerName;
    }

    @Override
    public void process(File file) {
        if(file.getType().equals(EXCEL)){
            logger.log(Level.INFO, "Process and saving excel file by " + handlerName);
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
