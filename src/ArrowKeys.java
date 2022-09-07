import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class ArrowKeys {
    boolean ExitApp = false;

    public ArrowKeys() {

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setFocusable(true);

        JPanel panel = new JPanel();
        JLabel Exit = new JLabel();
        panel.add(Exit);
        Exit.setText("Let Me Out: 0");

        frame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // Auto-generated method
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_UP) {
                    Exit.setText("Exiting application");
                    ExitApp = true;
                    System.out.println(ExitApp);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Auto-generated method
            }
        });
        frame.add(panel);
    }
}