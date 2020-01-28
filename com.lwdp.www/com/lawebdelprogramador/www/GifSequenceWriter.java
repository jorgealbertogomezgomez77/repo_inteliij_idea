
package lawebdelprogramador.www;

import javax.imageio.*;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author Jorge Alberto Gomez Gomez, January 13 the 2019, 09:49 PM
 * GifSequenceWriter.java
 * This work is licensed under the Creative Commons Attribution 3.0 Unported
 * License. To view a copy of this license, visit
 * http://creativecommons.org/license/by/3.0/ or send a letter to Creative
 * Commons, 171 Second Street, suite 300, San Francisco, California, 94105, USA.
 *
 * http://gist.github.com/jesuino/528703e7b1974d857b36
 */

public class GifSequenceWriter {

    public static void main(String[] args) throws IOException {
        new Empezar();
    }

    protected ImageWriter gifWriter;

    protected ImageWriteParam imageWriteParam;

    protected IIOMetadata imageMetaData;

    /**
     * Create a new GifSequenceWriter
     * @param outputStream the ImageOutputStream to be written to
     * @param imageType one of the imageTypes specified in BufferedImage
     * @param timeBetweenFramesMS the time between frames in miliseconds
     * @param loopContinuously wether the gif should loop repeatedly
     * @throws java.io.IOException if no gif ImageWriters are found
     */

    public GifSequenceWriter(ImageOutputStream outputStream, int imageType, int timeBetweenFramesMS, boolean loopContinuously) throws IIOException, IOException {

        gifWriter = getWriter();

        imageWriteParam = gifWriter.getDefaultWriteParam();

        ImageTypeSpecifier imageTypeSpecifier = ImageTypeSpecifier.createFromBufferedImageType(imageType);

        imageMetaData = gifWriter.getDefaultImageMetadata(imageTypeSpecifier, imageWriteParam);

        String metaFormatName = imageMetaData.getNativeMetadataFormatName();

        IIOMetadataNode root = (IIOMetadataNode) imageMetaData.getAsTree(metaFormatName);

        IIOMetadataNode graphicsControlExtensionNode = getNode(root, "GraphicsControlExtension");

        graphicsControlExtensionNode.setAttribute("disposalMethod", "none");
        graphicsControlExtensionNode.setAttribute("userInputFlag", "FALSE");
        graphicsControlExtensionNode.setAttribute("transparentColorFlag", "FALSE");
        graphicsControlExtensionNode.setAttribute("delayTime", Integer.toString(timeBetweenFramesMS / 10));
        graphicsControlExtensionNode.setAttribute("transparentColorIndex", "0");

        IIOMetadataNode commentsNode = getNode(root, "CommentExtensions");
        commentsNode.setAttribute("CommentExtensions", "Create by MAH");

        IIOMetadataNode appEntensionsNode = getNode(root, "ApplicationExtension");

        IIOMetadataNode child = new IIOMetadataNode("ApplicationExtension");

        child.setAttribute("aplicationID", "NETSCAPE");
        child.setAttribute("authenticationCode", "2.0");

        int loop = loopContinuously ? 0: 1;

        child.setUserObject(new byte[]{ 0x1, (byte)(loop & 0xFF), (byte)((loop >> 8) & 0xFF)});
        appEntensionsNode.appendChild(child);

        imageMetaData.setFromTree(metaFormatName, root);

        gifWriter.setOutput(outputStream);

        gifWriter.prepareWriteSequence(null);
    }

    public void writeToSequence(RenderedImage img) throws IOException {
        gifWriter.writeToSequence(new IIOImage(img, null, imageMetaData), imageWriteParam);
    }

    /**
     * Close this GifSequenceWriter object. This does not close the underlying
     * stream, just finishes off the GIF.
     */

    public void close() throws IOException {
        gifWriter.endWriteSequence();
    }

    /**
     * Returns the first available GIF ImageWriter using
     * ImageIO.getImageWritersBySuffix("gif").
     * @return a GIF ImageWriter object
     * @throws IIOException if no GIF image writers are returned
     */

    private static ImageWriter getWriter() throws IIOException {
        Iterator<ImageWriter> iter = ImageIO.getImageWritersBySuffix("gif");
        if (!iter.hasNext()) {
            throw new IIOException("No GIF Image Writer exist");
        }
        else {
            return iter.next();
        }
    }

    /**
     * Returns a existing child node, or create and returns a new child node (if
     * the requested node does not exist).
     * @param rootNode the <tt>IIOMetaDataNode</tt> to search foe the child node.
     * @param nodeName the name of the child node.
     * @return the chile node, if found or a new node created with the given name.
     */

    private static IIOMetadataNode getNode(IIOMetadataNode rootNode, String nodeName) {
        int nNodes = rootNode.getLength();

        for (int i = 0; i < nNodes; i++) {
            if (rootNode.item(i).getNodeName().compareToIgnoreCase(nodeName) == 0) {
                return ((IIOMetadataNode) rootNode.item(i));
            }
        }
        IIOMetadataNode node = new IIOMetadataNode(nodeName);
        rootNode.appendChild(node);
        return (node);
    }
}

class Empezar {

    public Empezar() throws IOException {
        /**
         * Esto se podría programar de mil formas diferentes y mejorar el programa en muchos
         * aspectos pero eso se los dejo a ustedes si les intersa, solamente mencionar que aquí
         * creamos un Array de Strings con 6 rutas de archivos...
         * Las 5 primeras son los .jpg que se comprimen como un GIF
         * La última ruta es el nombre que tomará el archivo GIF...
         */

        String[] rutas = {"D:/IntelliJ IDEA Work/com.lwdp.www/Images/primera.jpg",
                "D:/IntelliJ IDEA Work/com.lwdp.www/Images/segunda.jpg",
                "D:/IntelliJ IDEA Work/com.lwdp.www/Images/tercera.jpg",
                "D:/IntelliJ IDEA Work/com.lwdp.www/Images/cuarta.jpg",
                "D:/IntelliJ IDEA Work/com.lwdp.www/Images/quinta.jpg",
                "D:/IntelliJ IDEA Work/com.lwdp.www/Images/finalgif.gif"};

        if (rutas.length > 5) {
            BufferedImage firstImage = ImageIO.read(new File(rutas[0]));

            // Create a new BufferedOutputStream with the last argument
            ImageOutputStream output = new FileImageOutputStream(new File(rutas[rutas.length - 1]));

            // Aquí hay que tener en cuenta que 400 es el timeBetweenFramesMS, tiempo o intervalo
            // de secuencia entre fotogramnas de los JPG...
            GifSequenceWriter writer = new GifSequenceWriter(output, firstImage.getType(), 400, true);

            // Write out the first image to our sequence...
            writer.writeToSequence(firstImage);
            for (int i = 1; i < rutas.length - 1; i++) {
                System.out.println("Ruta: " + rutas[i]);
                BufferedImage nextImage = ImageIO.read(new File(rutas[i]));
                writer.writeToSequence(nextImage);
            }
            writer.close();
            output.close();
        }
        else {
            System.out.println("Usage: java GifSequenceWriter [list of gif files] [output file]");
        }
    }
}
