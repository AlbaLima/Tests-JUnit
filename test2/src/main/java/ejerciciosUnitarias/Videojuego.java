package ejerciciosUnitarias;

/**
*
* Clase videojuego
*
* Contiene la informacion sobre un videojuego
*
* @author DiscoDurodeRoer
*/
public class Videojuego implements Entregable {
	 
	   //Constantes
	 
	   /**
	    * Horas estimadas por defecto
	    */
	   private final static int HORAS_ESTIMADAS_DEF=100;
	 
	   /**
	    * Constante que indica que un objeto es mayor que otro
	    */
	   public final static int MAYOR=1;
	 
	   /**
	    * Constante que indica que un objeto es menor que otro
	    */
	   public final static int MENOR=-1;
	 
	   /**
	    * Constante que indica que un objeto es igual que otro
	    */
	   public final static int IGUAL=0;
	 
	   //Atributos
	 
	   /**
	    * Titulo del videojuego
	    */
	   private String titulo;
	 
	   /**
	    * Horas estimadas del videojuego
	    */
	   private int horasEstimadas;
	 
	   /**
	    * Indica si esta o no entregado el videojuego
	    */
	   private boolean entregado;
	 
	   /**
	    * Genero del videojuego
	    */
	   private String genero;
	 
	   /**
	    * Compañia del videojuego
	    */
	   private String compagnia;
	 
	   //Metodos publicos
	 
	   /**
	    * Devuelve el titulo del videojuego
	    * @return titulo del videojuego
	    */
	   public String getTitulo() {
	       return titulo;
	   }
	 
	   /**
	    * Modifica el titulo del videojuego
	    * @param titulo a cambiar
	    */
	   public void setTitulo(String titulo) {
	       this.titulo = titulo;
	   }
	 
	   /**
	    * Devuelve el numero de paginas del videojuego
	    * @return numero de paginas del videojuego
	    */
	   public int getHorasEstimadas() {
	       return horasEstimadas;
	   }
	 
	   /**
	    * Modifica el numero de paginas del videojuego
	    * @param horasEstimadas
	    */
	   public void setHorasEstimadas(int horasEstimadas) {
	       this.horasEstimadas = horasEstimadas;
	   }
	 
	   /**
	    * Devuelve el genero del videojuego
	    * @return genero del videojuego
	    */
	   public String getGenero() {
	       return genero;
	   }
	 
	   /**
	    * Modifica el genero del videojuego
	    * @param genero a cambiar
	    */
	   public void setGenero(String genero) {
	       this.genero = genero;
	   }
	 
	   /**
	    * Devuelve el compagnia del videojuego
	    * @return compagnia del videojuego
	    */
	   public String getcompagnia() {
	       return compagnia;
	   }
	 
	   /**
	    * Modifica el compagnia del videojuego
	    * @param compagnia a cambiar
	    */
	   public void setcompagnia(String compagnia) {
	       this.compagnia = compagnia;
	   }
	 
	   /**
	    * Cambia el estado de entregado a true
	    */
	   public void entregar() {
	       entregado=true;
	   }
	 
	   /**
	    * Cambia el estado de entregado a false
	    */
	   public void devolver() {
	       entregado=false;
	   }
	 
	   /**
	    * Indica el estado de entregado
	    * @return 
	    */
	   public boolean isEntregado() {
	       if(entregado){
	           return true;
	       }
	       return false;
	   }
	 
	   /**
	    * Compara dos videojuegos segun el numero de paginas
	    * @return codigo numerico
	    * <ul>
	    * <li>1: El videojuego 1 es mayor que el videojuego 2</li>
	    * <li>0: Los videojuegos son iguales</li>
	    * <li>-1: El videojuego 1 es menor que el videojuego 2</li></ul>
	    */
	   public int compareTo(Object a) {
	       int estado=MENOR;
	 
	       //Hacemos un casting de objetos para usar el metodo get
	       Videojuego ref=(Videojuego)a;
	       if (horasEstimadas>ref.getHorasEstimadas()){
	           estado=MAYOR;
	       }else if(horasEstimadas==ref.getHorasEstimadas()){
	           estado=IGUAL;
	       }
	 
	       return estado;
	   }
	 
	   /**
	    * Muestra informacion del videojuego
	    * @return cadena con toda la informacion del videojuego
	    */
	   @Override
	   public String toString(){
	       return "Informacion del videojuego: \n" +
	               "\tTitulo: "+titulo+"\n" +
	               "\tHoras estimadas: "+horasEstimadas+"\n" +
	               "\tGenero: "+genero+"\n" +
	               "\tcompañia: "+compagnia;
	   }
	 
	   /**
	    * Indica si dos videojuegos son iguales, siendo el titulo y compañia iguales
	    * @param a videojuego a comparar
	    * @return true si son iguales y false si son distintos
	    */
	   public boolean equals(Videojuego a){
	       if (titulo.equalsIgnoreCase(a.getTitulo()) && compagnia.equalsIgnoreCase(a.getcompagnia())){
	           return true;
	       }
	       return false;
	   }
	 
	   //Constructor
	 
	   /**
	    * Constructo por defecto
	    */
	   public Videojuego(){
	       this("",HORAS_ESTIMADAS_DEF, "", "");
	   }
	 
	   /**
	    * Constructor con 2 parametros
	    * @param titulo del videojuego
	    * @param compagnia del videojuego
	    */
	   public Videojuego(String titulo, String compagnia){
	       this(titulo,HORAS_ESTIMADAS_DEF, "", compagnia);
	   }
	 
	   /**
	    * Constructor con 4 parametros
	    * @param titulo del videojuego
	    * @param horasEstimadas
	    * @param genero del videojuego
	    * @param compañia del videojuego
	    */
	   public Videojuego(String titulo, int horasEstimadas, String genero, String compagnia){
	       this.titulo=titulo;
	       this.horasEstimadas=horasEstimadas;
	       this.genero=genero;
	       this.compagnia =compagnia;
	       this.entregado=false;
	   }
}
