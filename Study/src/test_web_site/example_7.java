package test_web_site;

import java.awt.*;
import java.net.URI;

public class example_7 {
    public static void main(String[] args) throws Exception {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new URI("http://www.example.com"));
        }
    }
}
