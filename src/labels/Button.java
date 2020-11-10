package labels;

import javax.swing.*;
import java.awt.event.*;

public class Button extends Thread {

    private JButton button;

    public Button(JPanel panel, String buttonMessage, Thread listener) {
        button = new JButton(buttonMessage);
        ActionListener event = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.run();
            }
        };
        button.addActionListener(event);
        panel.add(button);
    }

}
