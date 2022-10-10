import client.File;
import handler.impl.AudioFileHandler;
import handler.impl.DocFileHandler;
import handler.impl.ExcelFileHandler;
import handler.Handler;
import handler.impl.ImageFileHandler;
import handler.impl.TextFileHandler;
import handler.impl.VideoFileHandler;

public class Main {
    public static void main(String[] args) {
        File file = null;
        Handler textHandler = new TextFileHandler("Text handler.Handler");
        Handler docHandler = new DocFileHandler("Doc handler.Handler");
        Handler excelHandler = new ExcelFileHandler("Excel handler.Handler");
        Handler audioHandler = new AudioFileHandler("Audio handler.Handler");
        Handler videoHandler = new VideoFileHandler("Video handler.Handler");
        Handler imageHandler = new ImageFileHandler("Image handler.Handler");

        textHandler.setHandler(docHandler);
        docHandler.setHandler(excelHandler);
        excelHandler.setHandler(audioHandler);
        audioHandler.setHandler(videoHandler);
        videoHandler.setHandler(imageHandler);

//        file = new File("Abc.mp3", "audio", "/home/user/audio");
//        textHandler.process(file);
        file = new File("Abc.jpg", "img", "/home/user/image");
        textHandler.process(file);
//        file = new File("Abc.doc", "doc", "/home/user/doc");
//        textHandler.process(file);
//        file = new File("Abc.bat", "bat", "/home/user/bat");
//        textHandler.process(file);
    }
}
