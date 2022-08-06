import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        File file = null;
        Handler textHandler = new TextFileHandler("Text Handler");
        Handler docHandler = new DocFileHandler("Doc Handler");
        Handler excelHandler = new ExcelFileHandler("Excel Handler");
        Handler audioHandler = new AudioFileHandler("Audio Handler");
        Handler videoHandler = new VideoFileHandler("Video Handler");
        Handler imageHandler = new ImageFileHandler("Image Handler");

        textHandler.setHandler(docHandler);
        docHandler.setHandler(excelHandler);
        excelHandler.setHandler(audioHandler);
        audioHandler.setHandler(videoHandler);
        videoHandler.setHandler(imageHandler);

        file = new File("Abc.mp3", "audio", "/home/user/audio");
        textHandler.process(file);
        file = new File("Abc.jpg", "video", "/home/user/video");
        textHandler.process(file);
        file = new File("Abc.doc", "doc", "/home/user/doc");
        textHandler.process(file);
        file = new File("Abc.bat", "bat", "/home/user/bat");
        textHandler.process(file);
    }
}
