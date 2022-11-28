import java.io.IOException;
import java.util.*;

public class Grafo {

    public boolean estanConectados(String a1, String a2, String txtRelaciones) throws IOException {
        Main.cargarWebs("index-2022-2023");
        Main.cargarWebRelacionadas(txtRelaciones);
        Main.cargarRelacionesWebs();


        int w1 = Main.webs.word2web(a1);
        int w2 = Main.webs.word2web(a2);
        Queue<Integer> porExaminar = new LinkedList<Integer>();
        boolean enc = false;
        boolean[] examinados = new boolean[Main.webs.obtenerNumWebs()];
        examinados [w1] = true;

        porExaminar.add (w1);

        while (!enc && !porExaminar.isEmpty()) {

            int elementoSacado = porExaminar.poll();
            if (elementoSacado != w2) {
                examinados[elementoSacado] = true;
                for (int i = 0; i < Main.webs.devolverWebPorId(elementoSacado).obtenerWAsociadas().obtenerNumWebs(); i++) {
                    Web web = Main.webs.devolverWebPorId(elementoSacado).obtenerWAsociadas().devolverWebPorPos(i);
                    if (web != null && examinados [web.obtenerId()]==false) {
                        porExaminar.add(web.obtenerId());
                    }
                }
            }else{
                enc = true;
            }
        }
        return enc;
    }
    public ArrayList <String> estanConectados2(String a1, String a2, String txtRelaciones) throws IOException {
        Main.cargarWebs("index-2022-2023");
        Main.cargarWebRelacionadas(txtRelaciones);
        Main.cargarRelacionesWebs();

        int w1 = Main.webs.word2web(a1);
        int w2 = Main.webs.word2web(a2);
        Queue<Integer> porExaminar = new LinkedList<Integer>();
        HashMap<Integer,Integer> relaciones = new HashMap<Integer, Integer>();
        ArrayList <String> conexiones = new ArrayList<String>();
        Stack <String> camino = new Stack<String>();
        boolean enc = false;
        boolean[] examinados = new boolean[Main.webs.obtenerNumWebs()];
        relaciones.put(w1,null);

        porExaminar.add (w1);
        int elementoSacado = 0;
        while (!enc && !porExaminar.isEmpty()) {

            elementoSacado = porExaminar.poll();
            if (elementoSacado != w2){
                examinados [elementoSacado] = true;
                for (int i = 0; i < Main.webs.devolverWebPorId(elementoSacado).obtenerWAsociadas().obtenerNumWebs(); i++){
                    Web web = Main.webs.devolverWebPorId(elementoSacado).obtenerWAsociadas().devolverWebPorPos(i);
                    if (web != null && examinados[Main.webs.devolverWebPorId(web.obtenerId()).obtenerId()] == false) {
                        porExaminar.add(web.obtenerId());
                        if (relaciones.get(web.obtenerId()) == null && web.obtenerId() != w1) {
                            relaciones.put(web.obtenerId(),elementoSacado);
                        }
                    }
                }
                }else{
                    enc = true;
                }
            }
        if (enc){
            camino.add (Main.webs.devolverWebPorId(elementoSacado).obtenerNombre());
            Integer i = elementoSacado;
            while (relaciones.get(i) != null){
                camino.add (Main.webs.devolverWebPorId(relaciones.get (i)).obtenerNombre());
                i = relaciones.get (i);
            }
            int limite = camino.size();
            for (int ind = 0; ind < limite; ind++){
                conexiones.add(camino.pop());
            }
        }
        return conexiones;
    }
}