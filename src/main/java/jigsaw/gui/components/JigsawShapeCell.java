package jigsaw.gui.components;

import jigsaw.gui.util.Constants;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Graphics;

/**
 * The area where the shapes are generated. Based on the JPanel class.
 */
public final class JigsawShapeCell extends JPanel {
    /**
     * The number of rows in the area.
     */
    private static final int ROWS = 3;

    /**
     * The number of columns in the area.
     */
    private static final int COLS = 3;

    /**
     * The color of the inside of the cell.
     */
    private final Color fillColor;
    /**
     * The color of the outline of the cell.
     */
    private final Color outline;

    /**
     * Creates a new JigsawShapeCell.
     *
     * @param outline   The outline color.
     * @param thickness The thickness of the outline.
     * @param fillColor The color to fill the cell with.
     */
    public JigsawShapeCell(Color outline, int thickness, Color fillColor) {
        this.outline = outline;
        this.fillColor = fillColor;
        this.setBorder(BorderFactory.createLineBorder(this.outline, thickness));
    }

    /**
     * Paints the cell.
     *
     * @param g The graphics to use.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                g.setColor(fillColor);
                g.fillRect(
                        i * Constants.CELL_SIZE,
                        j * Constants.CELL_SIZE,
                        Constants.CELL_SIZE,
                        Constants.CELL_SIZE);

                g.setColor(outline);
                g.drawRect(
                        i * Constants.CELL_SIZE,
                        j * Constants.CELL_SIZE,
                        Constants.CELL_SIZE,
                        Constants.CELL_SIZE);
            }
        }
    }
}
