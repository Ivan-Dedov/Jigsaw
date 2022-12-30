package jigsaw.gui.components;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

/**
 * The button to use in the game of Jigsaw. Based on the JButton class.
 */
public final class JigsawButton extends JButton {
    /**
     * Creates a new JigsawButton.
     *
     * @param actionListener The action listener to use on the button.
     * @param text           The text of the button.
     * @param bgColor        The color of the button.
     * @param fgColor        The color of the text.
     * @param font           The font of the text.
     */
    public JigsawButton(ActionListener actionListener, String text,
                        Color bgColor, Color fgColor, Font font) {
        this.setBackground(bgColor);
        this.setText(text);
        this.setFont(font);
        this.setForeground(fgColor);
        this.addActionListener(actionListener);
        this.setFocusable(false);
    }
}
