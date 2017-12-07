package com.techdiggity.gateway;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel2 extends JPanel {

	private static final long serialVersionUID = 5336341560509304886L;
	private BufferedImage image;

    public ImagePanel2() {
        try {
            //image = ImageIO.read(ImagePanel2.class.getResource("/resources/images/planetbackground.jpg"));
        	image = ImageIO.read(ImagePanel2.class.getResource("/com/techdiggity/gateway/images/middle.gif"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return image == null ? new Dimension(100, 100): new Dimension(image.getWidth(), image.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
