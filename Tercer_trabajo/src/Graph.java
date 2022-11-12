import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    public boolean estanConectados(String a1, String a2) throws IOException {
        Main.cargarWebs("index-2022-2023");
        Main.cargarWebRelacionadas("pld-arcs-1-N-2022-2023");


        int w1 = Main.webs.word2web(a1);
        int w2 = Main.webs.word2web(a2);
        Queue<Integer> porExaminar = new LinkedList<Integer>();
        for (int i = 0; i <  Main.webs.devolverWebPorId(w1).obtenerWAsociadas().obtenerNumWebs();i++){
            porExaminar.add(Main.webs.devolverWebPorId(w1).obtenerWAsociadas().devolverWebPorPos(i).obtenerId());
        }

        boolean enc = false;
        boolean[] examinados = new boolean[2];

        // COMPLETAR CÓDIGO

        return enc;

    }
}