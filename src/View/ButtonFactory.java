package View;

import javax.swing.*;
import java.awt.*;

public class ButtonFactory {
    public JButton createButton() {
        JButton button = new JButton("-");
        button.setFont(new Font("Arial", Font.BOLD, 60));
        button.setFocusPainted(false);
        return button;
    }
}
