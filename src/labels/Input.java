package labels;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Input {

    private JTextField field;

    public Input(JPanel panel, int size) {
        field = new JTextField(size);
        Listener();
        panel.add(field);
    }

    public Input(JPanel panel, int size, boolean integer) {
        field = new JTextField(size);
        if (integer) Listener();
        panel.add(field);
    }

    private void Listener() {
        field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                
            }
            @Override
            public void keyReleased(KeyEvent e) {
                NumCheck(field.getText());
            }
        });
    }

    public void NumCheck(String text) {
        String onlyNum = text.replaceAll("[^0-9.]", "");
        field.setText(onlyNum);
    }

    public String getText() {
        return field.getText();
    }

    public void setText(String text) {
        field.setText(text);
    }
}
