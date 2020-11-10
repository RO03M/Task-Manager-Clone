package labels;

import java.awt.BorderLayout;

import javax.swing.*;

public class Text {
    
    JLabel textLabel;

    public Text(JPanel panel, String message) {
        textLabel = new JLabel(message);
        panel.add(textLabel, BorderLayout.SOUTH);
    }

    public void setText(String text) {
        textLabel.setText(text);
    }

    public String Content() {
        return textLabel.getText();
    }

}
