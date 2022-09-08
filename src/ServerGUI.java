import javax.swing.*;

public class ServerGUI {

    public void ShowGUI() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setFocusable(true);

        JPanel panel = new JPanel();
        JLabel Exit = new JLabel();
        panel.add(Exit);
        Exit.setText("Bestel pizza niffo");
        frame.add(panel);
    }
}