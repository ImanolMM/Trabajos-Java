import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo {

    public boolean estanConectados(String a1, String a2) throws IOException {
        Main.cargarWebs("index-2022-2023.txt");
        Main.cargarWebRelacionadas("pld-arcs-1-N-2022-2023.txt");
        Main.cargarRelacionesWebs();


        int w1 = Main.webs.word2web(a1);
        int w2 = Main.webs.word2web(a2);
        Queue<Integer> porExaminar = new LinkedList<Integer>();

        for (int i = 0; i < Main.webs.devolverWebPorId(w1).obtenerWAsociadas().obtenerNumWebs(); i++){
            Web web = Main.webs.devolverWebPorId(w1).obtenerWAsociadas().devolverWebPorPos(i);
            if (web != null) {
                porExaminar.add(web.obtenerId());

            }
        }
        boolean enc = false;
        boolean[] examinados = new boolean[Main.webs.obtenerNumWebs()];

        while (!enc && !porExaminar.isEmpty()) {

            int elementoSacado = porExaminar.poll();
            if (examinados [elementoSacado] == false){
                if (elementoSacado != w2){
                    for (int i = 0; i < Main.webs.devolverWebPorId(elementoSacado).obtenerWAsociadas().obtenerNumWebs(); i++){
                        Web web = Main.webs.devolverWebPorId(elementoSacado).obtenerWAsociadas().devolverWebPorPos(i);
                        if (web != null) {
                            porExaminar.add(web.obtenerId());
                        }
                    }
                    examinados [elementoSacado] = true;
                }else{
                    enc = true;
                }
            }
        }
        return enc;
    }
}