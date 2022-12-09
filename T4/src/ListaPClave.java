import java.util.ArrayList;
public class ListaPClave {
    private ArrayList <PClave> lista;


    protected ListaPClave (){

        this.lista = new ArrayList<PClave>();
    }

    protected void añadirPalabra (PClave palabra){
        this.lista.add(palabra);
    }

    protected int obtenerNumPalabras (){
        return this.lista.size();
    }

    protected PClave obtenerPalabraPorPos (int pos){
        return this.lista.get(pos);
    }

    public ArrayList <PClave> obtenerArray(){
        return this.lista;
    }

}
