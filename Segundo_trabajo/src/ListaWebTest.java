import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;

public class ListaWebTest {

    private ListaWeb l1;
    private Web web1,web2;

    @org.junit.Before
    public void setUp() throws Exception {
        web1=new Web("asdfg.m",0);
        web2=new Web("qwerty.com",1);
        l1=new ListaWeb();
        l1.añadirWeb(web1);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        l1=null;
        web1=null;
        web2=null;
    }

    @org.junit.Test
    public void obtenerNumWebs() {
        assertEquals(l1.obtenerNumWebs(),1);
    }

    @org.junit.Test
    public void añadirWeb() {
        l1.añadirWeb(web2);
        assertEquals(l1.obtenerNumWebs(),2);
    }

    @org.junit.Test
    public void devolverWebPorPos() {
        l1.añadirWeb(web2);
        assertEquals(l1.devolverWebPorPos(0),web1);
        assertEquals(l1.devolverWebPorPos(1),web2);
    }

    @org.junit.Test
    public void quitarWeb() {
        l1.quitarWeb(0);
        assertEquals(l1.obtenerNumWebs(),0);
    }

    @org.junit.Test
    public void obtenerArray() {
        ArrayList<Web> lista=new ArrayList<>();
        lista.add(web1);
        lista.add(web2);
        l1.añadirWeb(web2);
        assertEquals(l1.obtenerArray(),lista);
    }
}