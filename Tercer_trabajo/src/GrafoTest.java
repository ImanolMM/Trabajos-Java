import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class GrafoTest {

    Grafo g;
    ArrayList <String> arr;
    ArrayList <String> camino;

    @org.junit.Before
    public void setUp() throws Exception {
        g = new Grafo();
        arr = new ArrayList<String>();
        camino = new ArrayList<String>();
    }

    @org.junit.After
    public void tearDown() throws Exception {
        g = new Grafo();
        arr = new ArrayList<>();
    }

    @org.junit.Test
    public void estanConectados() throws IOException {
        // grafo vacío, no hay relaciones
        assertFalse(g.estanConectados("0-00.pl", "0-100.com.cn", "relacionesTest1.txt"));
        // grafo rellenado pero no están relacionados
        assertFalse(g.estanConectados("0-00.pl", "0-100.com.cn", "relacionesTest2.txt"));
        // sí están relacionados
        assertTrue(g.estanConectados("0-00.pl", "0-24.ro", "relacionesTest3.txt"));
        // relaciones que hacen ciclos pero sí están conectados
        assertTrue(g.estanConectados("0-00.pl", "0-24.ro", "relacionesTest4.txt"));
        // relaciones que hacen ciclos pero no están conectados
        assertFalse(g.estanConectados("0-00.pl", "0-24.ro", "relacionesTest5.txt"));

    }

    @org.junit.Test
    public void estanConectados2() throws IOException {
        // grafo vacío, no hay relaciones
        camino = g.estanConectados2("0-00.pl", "0-100.com.cn", "relacionesTest1.txt");
        assertEquals(arr, camino);
        // grafo rellenado pero no están relacionados
        camino = g.estanConectados2("0-00.pl", "0-100.com.cn", "relacionesTest2.txt");
        assertEquals(arr, camino);
        // sí están relacionados
        camino = g.estanConectados2("0-00.pl", "0-24.ro", "relacionesTest3.txt");
        arr.add ("0-00.pl");
        arr.add ("0-100.com.cn");
        arr.add ("0-200.com");
        arr.add ("0-24-sex.de");
        arr.add ("0-24.ro");
        assertEquals(arr,camino);
        // relaciones que hacen ciclos pero sí están conectados
        camino = g.estanConectados2("0-00.pl", "0-24.ro", "relacionesTest4.txt");
        arr = new ArrayList<>();
        arr.add ("0-00.pl");
        arr.add ("0-100.com.cn");
        arr.add ("0-100editions.net");
        arr.add ("0-24-sex.de");
        arr.add ("0-24.ro");
        assertEquals(arr,camino);
    }
}