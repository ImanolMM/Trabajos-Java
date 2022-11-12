import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    public boolean estanConectados(String a1, String a2) throws IOException {
        Main.cargarWebs("index-2022-2023");
        Main.cargarWebRelacionadas("pld-arcs-1-N-2022-2023");
        Queue<Integer> porExaminar = new LinkedList<Integer>();

        int pos1 ;
        int pos2 ;
        boolean enc = false;
        boolean[] examinados = new boolean[2];

        // COMPLETAR CÓDIGO

        return enc;

    }
}