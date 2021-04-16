package test_web_site;

import java.awt.Desktop;
import java.net.URI;

public class example_5 {
    public static void main(String[] args) throws Exception {
        Desktop direccion = Desktop.getDesktop();
        direccion.browse(new URI("http://maps.google.com/maps/search/"));
    }
}
