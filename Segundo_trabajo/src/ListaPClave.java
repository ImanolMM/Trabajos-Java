import java.util.ArrayList;
public class ListaPClave extends UnorderedCircularLinkedList<PClave>{

    public ListaPClave (){
        last = null;
        descr = "";
        count = 0;
    }

    public void añadirPalabra (PClave palabra){
        this.addToRear(palabra);
    }

    public int obtenerNumPalabras (){
        return this.count;
    }
    public void quitarPalabra (String nom){
        Node <PClave> act = last;
        Node <PClave> ant = last;
        boolean quitado = false;

        if (last != null){
            act = act.next;
            if (act==last && act.data.obtenerNombrePalabra().equals(nom)){
                last=null;
                count=0;
            }
            else{
                while (act != last && !quitado){
                    if (act.data.obtenerNombrePalabra().equals(nom)){
                        if (act == last){
                            ant.next = act.next;
                            last = ant;
                        }else{
                            ant.next = act.next;
                        }
                    }else{
                        ant = act;
                        act = act.next;
                    }
                }
            }
        }
    }
    public PClave obtenerPalabraPorPos (int pos){
        //precondición: la posición es válida
        Node <PClave> act = last.next;
            for (int i = pos ; pos != 0; pos --){
                act = act.next;
            }
            return act.data;
    }

    public ArrayList <PClave> obtenerArray(){
        ArrayList <PClave> lista = new ArrayList<PClave>();
        Node <PClave> act = last.next;
        for (int i = 1; i <= count; i++){
            lista.add (act.data);
            act = act.next;
        }
        return lista;
    }

}
