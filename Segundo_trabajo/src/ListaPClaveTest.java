import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ListaPClaveTest {

    private ListaPClave l1;
    private PClave p1,p2;

    @Before
    public void setUp() throws Exception {
        l1=new ListaPClave();
        p1=new PClave("hola");
        p2=new PClave("adiós");
        l1.añadirPalabra(p1);
    }

    @After
    public void tearDown() throws Exception {
        l1=null;
        p1=null;
        p2=null;
    }

    @Test
    public void añadirPalabra() {
        l1.añadirPalabra(p2);
        assertEquals(l1.obtenerNumPalabras(),2);
    }

    @Test
    public void obtenerNumPalabras() {
        assertEquals(l1.obtenerNumPalabras(),1);
    }

    @Test
    public void quitarPalabra() {
        l1.quitarPalabra("hola");
        assertEquals(l1.obtenerNumPalabras(),0);
    }

    @Test
    public void obtenerPalabraPorPos() {
        l1.añadirPalabra(p2);
        assertEquals(l1.obtenerPalabraPorPos(0),p1);
        assertEquals(l1.obtenerPalabraPorPos(1),p2);
    }

    @Test
    public void obtenerArray() {
        ArrayList<PClave> lista=new ArrayList<>();
        lista.add(p1);
        lista.add(p2);
        l1.añadirPalabra(p2);
        assertEquals(l1.obtenerArray(),lista);
    }
}