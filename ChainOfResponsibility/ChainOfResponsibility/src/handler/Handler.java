package handler;


import client.File;

public interface Handler {
    /**
     * Definimos una interfaz handler.Handler que se utilizara para implementar los diferentes Handlers.
     * */

    public void setHandler(Handler handler); //Define el proximo handler.Handler en la cadena
    public void process(File file); //Intenta procesar el archivo
    public String getHandlerName(); //Metodo para obtener el nombre del handler.Handler (Solo para que el ejemplo sea mas grafico);
}
