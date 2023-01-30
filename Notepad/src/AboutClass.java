import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.util.jar.JarEntry;

public class AboutClass extends JFrame {
    public AboutClass(){
        setTitle("About");
        setBounds(500, 300, 500, 400);
        setLayout(null);
        ImageIcon notePadIcon = new ImageIcon("E:\\Java\\Projects\\NotePad\\Notepad\\src\\notepad.jpeg");
        Image image = notePadIcon.getImage();

        setIconImage(image);

        String about = "<html>Hi , this is a simple note pad made by me using java swing.<br>." +
                "My name is Mehedi hasan. This is a hobby project.<br> Hope it will encourage me to do such project more </html>";

        JLabel aboutLabel = new JLabel(about);
        aboutLabel.setBounds(100,60, 350, 200);
        aboutLabel.setFont(new Font("San_SERIF", Font.PLAIN, 18));
        add(aboutLabel);

    }

    public static void main(String[] args) {
        new AboutClass().setVisible(true);
    }
}
