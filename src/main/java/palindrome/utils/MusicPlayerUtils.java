package palindrome.utils;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.FileInputStream;
import java.io.IOException;

import static palindrome.utils.ConstantsUtils.*;

public class MusicPlayerUtils {
    public static void start() {
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(PATH_TO_MUSIC_FILE);
                    AdvancedPlayer player = new AdvancedPlayer(fileInputStream);
                    Thread musicThread = new Thread(() -> {
                        try {
                            player.play();
                        } catch (JavaLayerException ex) { ex.printStackTrace(); }
                    });
                    musicThread.start();
                    musicThread.join();
                } catch (JavaLayerException | IOException | InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }
}
