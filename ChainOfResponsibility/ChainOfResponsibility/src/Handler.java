public interface Handler {
    /**
     * Definimos una interfaz Handler que se utilizara para implementar los diferentes Handlers.
     * */

    public void setHandler(Handler handler); //Define el proximo Handler en la cadena
    public void process(File file); //Intenta procesar el archivo
    public String getHandlerName(); //Metodo para obtener el nombre del Handler (Solo para que el ejemplo sea mas grafico);
}
