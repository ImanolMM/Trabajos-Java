import java.io.IOException;
import java.util.HashMap;

public class PageRank {
    public HashMap<String, Double> pageRank(String txtRelaciones) throws IOException {
        HashMap<String, Double> hashMap = new HashMap<String, Double>();
        Main.cargarWebs("index-2022-2023");
        Main.cargarWebRelacionadas(txtRelaciones);
        Main.cargarRelacionesWebs();
        for (int asd = 0; asd < 6; asd++) {
            HashMap<String, Double> rangos = new HashMap<String, Double>();
            int numWebs = Main.webs.obtenerNumWebs();
            if (hashMap.get(Main.webs.devolverWebPorId(1).obtenerNombre()) == null) {
                for (int i = 0; i < numWebs; i++) {
                    int numWebsRelacionadas = Main.webs.devolverWebPorId(i).obtenerWAsociadas().obtenerNumWebs();
                    for (int ind = 0; ind < numWebsRelacionadas; ind++) {
                        Web web = Main.webs.devolverWebPorId(i).obtenerWAsociadas().devolverWebPorPos(ind);
                        String nomWeb = web.obtenerNombre();
                        if (hashMap.get(web.obtenerNombre()) != null) {
                            Double valor = hashMap.get(web.obtenerNombre()) + ((1.0 / numWebs) / numWebsRelacionadas);
                            hashMap.put(nomWeb, valor);
                        } else {
                            Double valor = ((1.0 / numWebs) / numWebsRelacionadas);
                            hashMap.put(nomWeb, valor);
                        }
                    }

                }
                for (int i = 0; i < numWebs; i++) {
                    Web web = Main.webs.devolverWebPorId(i);
                    String nomWeb = web.obtenerNombre();
                    if (hashMap.get(web.obtenerNombre()) != null) {
                        Double valor = (1 - 0.85) / numWebs + 0.85 * hashMap.get(web.obtenerNombre());
                        hashMap.put(nomWeb, valor);
                    }else{
                        Double valor = (1 - 0.85) / numWebs;
                        hashMap.put(nomWeb, valor);
                    }
                }
            } else {
                for (int i = 0; i < numWebs; i++) {
                    int numWebsRelacionadas = Main.webs.devolverWebPorId(i).obtenerWAsociadas().obtenerNumWebs();
                    if (numWebsRelacionadas == 0){
                        hashMap.put(Main.webs.devolverWebPorId(i).obtenerNombre(), 0.0);
                    }else {
                        for (int ind = 0; ind < numWebsRelacionadas; ind++) {
                            Web webI = Main.webs.devolverWebPorId(i);
                            Web webInd = webI.obtenerWAsociadas().devolverWebPorPos(ind);
                            String nomWeb = webInd.obtenerNombre();
                            Double valor = hashMap.get(webInd.obtenerNombre()) + hashMap.get(webI.obtenerNombre()) / numWebsRelacionadas;
                            hashMap.put(nomWeb, valor);
                            hashMap.put(webI.obtenerNombre(), 0.0);
                        }
                    }
                }
                for (int i = 0; i < numWebs; i++) {
                    Web web = Main.webs.devolverWebPorId(i);
                    String nomWeb = web.obtenerNombre();
                    Double valor = (1 - 0.85) / numWebs + 0.85 * hashMap.get(web.obtenerNombre());
                    hashMap.put(nomWeb, valor);
                }
            }
        }
        return hashMap;
    }
}
