import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class HashWebTest1 {

    private static Web web1;
    private static Web web2;
    private static Web web3;

    private static Web web4;
    private static  Web web5;
    private static Web webmismo;
    private static HashWeb lista1;
    private static HashWeb lista2;
    private static HashWeb lista3;



    @Before
    public void setUp() throws DosWebsConMismoIdException {
        //inicializaciones
        web1 = new Web("aaaaaaa", 1);
        webmismo=new Web("dfghjk",1);
        web2 = new Web("bbbbbbb", 2);
        web3 = new Web("ccccccc", 3);
        web4=new Web("abbbbbb",4);
        web5=new Web("bcccccc",5);
        lista1 = new HashWeb();
        lista2 = new HashWeb();
        lista3=new HashWeb();




        //añadir las webs
        lista1.añadirWebAHash(web1.obtenerNombre(),web1.obtenerId());
        lista1.añadirWebAHash(web2.obtenerNombre(),web2.obtenerId());
        lista1.añadirWebAHash(web3.obtenerNombre(),web3.obtenerId());
        lista1.añadirWebAHash(web4.obtenerNombre(),web4.obtenerId());
        lista1.añadirWebAHash(web5.obtenerNombre(),web5.obtenerId());
        lista2.añadirWebAHash(web1.obtenerNombre(),web1.obtenerId());
        lista2.añadirWebAHash(web2.obtenerNombre(),web2.obtenerId());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void id2String() {
        //id al principio
        assertEquals("aaaaaaa",lista1.id2String(web1.obtenerId()));
        //caso simple
        assertEquals("bbbbbbb",lista1.id2String(web2.obtenerId()));
        //id al final
        assertEquals("ccccccc",lista1.id2String(web3.obtenerId()));


    }

    @Test
    public void obtenerNumWebs() {
        //caso simple
        assertEquals(3,lista1.obtenerNumWebs());
        //0 si no hay webs
        assertEquals(0,lista3.obtenerNumWebs());
    }

    @Test
    public void añadirWeb() {
        //lanza excepcion si tienen mismo id
        assertThrows(DosWebsConMismoIdException.class,
                ()->{
                    lista1.añadirWebAHash(webmismo.obtenerNombre(),webmismo.obtenerId());
                });
        //el resto de casos se obvian ya que es una llamada a add

    }

    @Test
    public void devolverWebPorId() {
        //caso simple
        assertEquals(web2.obtenerNombre(),lista1.devolverWebPorId(2).obtenerNombre());
        //que sea la primera web
        assertEquals(web1.obtenerNombre(),lista1.devolverWebPorId(1).obtenerNombre());
        //que sea la ultima
        assertEquals(web3.obtenerNombre(),lista1.devolverWebPorId(3).obtenerNombre());
        //que no coincida con la pos
        assertNotEquals(web3,lista2.devolverWebPorId(2));
    }

    @Test
    public void quitarWeb() {
        //caso simple
    }

    @Test
    public void devolverArrayOrdenado() {
        ArrayList<Web> ordenado=lista1.devolverArrayOrdenado();

        assertEquals("aaaaaaa",ordenado.get(0).obtenerNombre());//primer elemento

        assertEquals("abbbbbb",ordenado.get(1).obtenerNombre());//segundo elemento

        assertEquals("bcccccc",ordenado.get(3).obtenerNombre());//elemento en la cuarta posicion

        assertEquals("ccccccc",ordenado.get(4).obtenerNombre());//ultimo elemento



        //caso simple

    }
}