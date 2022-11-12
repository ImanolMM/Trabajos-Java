import java.util.ArrayList;
import java.util.Iterator;

public class Web implements Comparable <Web>{
    private ListaPClave pAsociadas;
    private ListaWeb wAsociadas;
    private String nombreWeb;
    private int id;

    public Web (String nombreWeb, int id){
        this.pAsociadas = new ListaPClave();
        this.wAsociadas = new ListaWeb();
        this.nombreWeb = nombreWeb;
        this.id = id;
    }
    public String obtenerNombre (){ //

        return this.nombreWeb;
    }

    public int obtenerId (){ //
        return this.id;
    }

    public ListaWeb obtenerWAsociadas(){ //método para pruebas
        return this.wAsociadas;
    }

    public ListaPClave obtenerPAsociadas(){ //método para pruebas
        return this.pAsociadas;
    }

    public void añadirWebRelacioanada(Web web) {
        this.wAsociadas.añadirWeb(web);
    }

    public ArrayList <String> buscarCombinaciones (){

        ArrayList <String> combinaciones = new ArrayList<String>();
        int i,d = 0;

        for (i = 0; i != d-1; i++){
            for (d = i+1; d <= this.nombreWeb.length(); d++){
                combinaciones.add(this.nombreWeb.substring(i,d));
            }
        }
        return combinaciones;
    }

    public void añadirPalabraRelacionada (PClave palabra){
        this.pAsociadas.añadirPalabra(palabra);
    }

    public String obtenerPalabraPorPos(int pos){
        return this.pAsociadas.obtenerPalabraPorPos(pos).obtenerNombrePalabra();
    }

    public int compareTo (Web web){
        return this.obtenerNombre().compareTo(web.obtenerNombre());
    }

    public Web obtenerWebDeWasociadas (int id){ //devuelve null si no tiene nada en su lista
        if (this.wAsociadas.obtenerNumWebs() > 0){
            return this.wAsociadas.devolverWebPorPos(id);
        }
        else{
            return null;
        }
    }

    public ArrayList <PClave> obtenerPalabrasAsociadas (){
        return this.pAsociadas.obtenerArray();
    }

}
