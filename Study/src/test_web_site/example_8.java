package test_web_site;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class example_8 {
    public static void main(String[] args) {
        String url = "https://facebook.com";

        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            }
            catch (IOException | URISyntaxException e) {
                // Todo Auto-generated catch block.
                e.printStackTrace();
            }
        }
        else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            }
            catch (IOException e) {
                // Todo Auto-generated catch block.
                e.printStackTrace();
            }
        }
    }
}
