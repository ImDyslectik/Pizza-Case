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

        JPanel panel = new JPanel();
        JLabel Exit = new JLabel();
        panel.add(Exit);
        Exit.setText("vcerkeerde niffo fnioffo");
        frame.add(panel);
    }

    public void Display() {
        Order person = new Order("James");
        Order person2 = new Order("Lana");
        Order person3 = new Order("Melissa");
        Order person4 = new Order("Ryan");
        Order person5 = new Order("Liana");

        // LinkedList<Ingredients> toppings = new LinkedList<Ingredients>();

    }
}
