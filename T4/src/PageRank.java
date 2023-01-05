import java.io.IOException;
import java.util.HashMap;

public class PageRank {

    public HashMap<String, Double> pageRank(String txtRelaciones) throws IOException {
        HashMap<String, Double> ant = new HashMap<String, Double>();
        HashMap<String, Double> nuevo = new HashMap<String, Double>();
        Main.cargarWebs("prueba");
        Main.cargarWebRelacionadas(txtRelaciones);
        Main.cargarRelacionesWebs();
        boolean salir = false;
        int numWebs = Main.webs.obtenerNumWebs();
        Double valorDefault = 1.0 / numWebs;
        for (int i = 0; i< Main.webs.obtenerNumWebs(); i++){
            ant.put(Main.webs.devolverWebPorId(i).obtenerNombre(), valorDefault);
        }
        while (!salir) {
            for (int i = 0; i < numWebs; i++) {
                int numWebsRelacionadas = Main.webs.devolverWebPorId(i).obtenerWAsociadas().obtenerNumWebs();

                if (numWebsRelacionadas > 0){
                    Web webI = Main.webs.devolverWebPorId(i);
                    Double valorARepartir = ant.get(webI.obtenerNombre())/numWebsRelacionadas;
                    for (int ind = 0; ind < numWebsRelacionadas; ind++) {
                        Web webInd = webI.obtenerWAsociadas().devolverWebPorPos(ind);
                        String nomWeb = webInd.obtenerNombre();
                        if (nuevo.get(webInd.obtenerNombre()) != null){
                            Double valor = nuevo.get(webInd.obtenerNombre()) + valorARepartir;
                            nuevo.put(nomWeb, valor);
                        }else{
                            nuevo.put(nomWeb, valorARepartir);
                        }
                   }
                }
            }
            salir = true;
            for (int ind = 0; ind < numWebs; ind++){
                String web = Main.webs.devolverWebPorId(ind).obtenerNombre();
                if (nuevo.get(web)!= null){
                    Double valor = nuevo.get(web)* 0.85 + (1-0.85)/numWebs;
                    nuevo.put(web, valor);
                }else{
                    nuevo.put(web, (1-0.85)/numWebs);
                }
                Double resta = ant.get(web) - nuevo.get(web);
                if (resta > 0.00000001){
                    salir = false;
                    System.out.println("web1:  " +ant.get(web));
                    System.out.println("web2:  " +nuevo.get(web));

                }
            }
            ant = nuevo;
            nuevo = new HashMap<String, Double>();
        }
        return ant;
    }
}