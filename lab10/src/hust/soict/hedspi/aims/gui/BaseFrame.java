package hust.soict.hedspi.aims.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.net.URL;

public class BaseFrame extends JFrame {
    String urlBg = "https://plcschneider.com/wp-content/uploads/2020/10/lap-trinh-huong-doi-tuong-oop.png";

    public BaseFrame() {
        setLayout(null);
        setSize(600, 450);
        setContentPane(new JComponent() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                try {
                    g.drawImage(
                            ImageIO.read(new URL(urlBg)).getScaledInstance(600, 450, 1), 0, 0, this
                    );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - 600)) / 2;
        int y = (int) ((dimension.getHeight() - 400)) / 2;
        setLocation(x, y);
        setVisible(true);
    }
}
