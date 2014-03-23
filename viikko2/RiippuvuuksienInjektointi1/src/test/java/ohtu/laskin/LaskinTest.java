package ohtu.laskin;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LaskinTest {

    @Test
    public void yksiSummaOikein() {
        IOStub io = new IOStub(1, 3, -9999); 	// parametrien määrää ei ole asetettu
        new Laskin(io).suorita();

        assertEquals("summa: 4\n", io.outputs.get(2));
    }
}

class IOStub implements IO {

    int[] inputs;			// inputseja array
    int mones;				// laskuri
    ArrayList<String> outputs;		// monestko

    public IOStub(int... inputs) {		// voidaan syöttää ennalta määrittelemätön määrä parametreja
	    this.inputs = inputs;		// kaikki menevät inputs taulukkoon
	    this.outputs = new ArrayList<String>();		// tyhjä lista Stringeistä
    }

    @Override
    public int nextInt() {
        return inputs[mones++];		// laskuri kasvaa
    }

    @Override
    public void print(String m) {
        outputs.add(m);		// lista kasvaa kun halutaan printata
    }
}

/*

Käytetään ohtu.laskin Laskinta, sille syötetään IOStub joka sisältää valmiiksi
syötteen, jonka jälkeen testataan tuleeko vastaukseksi haluttu määrä. Input 
laskuri laskee mitä syötetään.

*/