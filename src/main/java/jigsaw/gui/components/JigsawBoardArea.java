package jigsaw.gui.components;

import javax.swing.JLayeredPane;

/**
 * The area to insert the JigsawBoard into. Based on JLayeredPane.
 */
public final class JigsawBoardArea extends JLayeredPane {
    /**
     * Creates a new JigsawBoardArea.
     */
    public JigsawBoardArea() {
        this.setOpaque(false);
    }
}
