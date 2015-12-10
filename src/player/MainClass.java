package player;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Kaspar
 * @version 1.0
 */
public class MainClass {

    FileInputStream fileIn;
    BufferedInputStream bufferIn;

    public Player player;

    public long pauseLoc;

    public long songLen;

    public String fileLoc;

    public void Stop() {
        if (player != null) {
            player.close();

            pauseLoc = 0;
            songLen = 0;

            MainGui.Display.setText("");
        }

    }

    public void Pause() {
        if (player != null) {
            try {
                pauseLoc = fileIn.available();
                player.close();
            } catch (IOException ex) {
            }
        }

    }

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

        new Thread() {
            @Override
            public void run() {
                try {
                    player.play();

                    if (player.isComplete() && MainGui.count == 1) {

                        Play(fileLoc);
                    }
                    if (player.isComplete()) {
                        MainGui.Display.setText("");
                    }
                } catch (JavaLayerException ex) {
                }
            }
        }.start();

    }

}
