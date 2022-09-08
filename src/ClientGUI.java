import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue;
import java.util.List;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JList;

public class ClientGUI {
    public void ShowGUI() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setFocusable(true);

        Order lol = new Order("funny", 0);

        JPanel panel = new JPanel();
        JLabel Exit = new JLabel();
        panel.add(Exit);
        Exit.setText("vcerkeerde niffo fnioffo");
        frame.add(panel);
    }

    public void Display() {
        // idk what this is

    }
}
