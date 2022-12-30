package jigsaw.gui.components;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;

/**
 * A label used in the game of Jigsaw. Based on the JLabel class.
 */
public final class JigsawLabel extends JLabel {
    /**
     * Creates a new JigsawLabel.
     *
     * @param text   The text to put on the label.
     * @param color  The color to use for the text.
     * @param font   The font to use for the text.
     */
    public JigsawLabel(String text, Color color, Font font) {
        this.setText(text);
        this.setFont(font);
        this.setForeground(color);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
    }
}
