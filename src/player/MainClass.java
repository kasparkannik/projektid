package mediaplayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * @author Kaspar
 * @version 1.0
 */
public class MainClass {

    FileInputStream fileIn;
    BufferedInputStream bufferIn;

    /**
     * Player on üks osa javazoom.jl libraryst, saab edastada MPEG audiofaile
     */
    public Player player;

    /**
     * Muutuja pauseLoc, mida kasutatakse Stop, Pause, Resume meetodites,
     * arvutamaks kui palju on muusika kestnud
     */
    public long pauseLoc;

    /**
     * Muutuja songLen, mida kasutatakse Stop, Play, Resume meetoditeks, mis
     * arvutab loo pikkuse
     */
    public long songLen;

    /**
     * Muutuja fileLoc, mida kasutatakse Resume, Play meetodis, mis näitab ära
     * faili asukoha
     */
    public String fileLoc;

    private int volume;

    /**
     * Stop meetodi kirjeldus
     */
    public void Stop() {
        if (player != null) {
            player.close();
//Viib programmi uuesti algseisu tagasi
            pauseLoc = 0;
            songLen = 0;
//Kustutab ekraanilt laulu nime
            MainGui.Display.setText("");
        }
    }

    /**
     * Pause meetodi kirjeldus
     */
    public void Pause() {
        if (player != null) {
            try {
                pauseLoc = fileIn.available();
                player.close();
            } catch (IOException ex) {
            }
        }
    }

    /**
     * Resume meetodi funktsioon. Jätkab lugu kohast, kust lugu pausile pandi
     */
    public void Resume() {
        try {
            fileIn = new FileInputStream(fileLoc);
            bufferIn = new BufferedInputStream(fileIn);

            player = new Player(bufferIn);
            fileIn.skip(songLen - pauseLoc);
        } catch (FileNotFoundException | JavaLayerException ex) {
        } catch (IOException ex) {
        }

        new Thread() {
            @Override
            public void run() {
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                }
            }
        }.start();
    }

    /**
     * Play meetodi defineerimine
     *
     * @param path, faili asukoht arvutis
     */
    public void Play(String path) {
        try {

            fileIn = new FileInputStream(path);
            bufferIn = new BufferedInputStream(fileIn);

            player = new Player(bufferIn);

            songLen = fileIn.available();

            fileLoc = path + "";
        } catch (FileNotFoundException | JavaLayerException ex) {
        } catch (IOException ex) {
        }
        /**
         * Uus thread, et muusikat saaks kuulata tagataustal
         */
        new Thread() {
            @Override
            public void run() {
                try {
                    player.play();

// Kui lugu on lõppenud ja loop on "on" siis taasesitatakse fail 
                    if (player.isComplete() && MainGui.count == 1) {

                        Play(fileLoc);
                    }
// Loo lõppedes, kustutab ekraanilt nime
                    if (player.isComplete()) {
                        MainGui.Display.setText("");
                    }
                } catch (JavaLayerException ex) {
                }
            }
        }.start();
    }
}
