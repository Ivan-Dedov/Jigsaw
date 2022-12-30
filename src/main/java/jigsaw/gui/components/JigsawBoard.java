package jigsaw.gui.components;

import jigsaw.gui.util.Constants;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Graphics;

/**
 * A board to use in the game of Jigsaw. Based on the JPanel class.
 */
public final class JigsawBoard extends JPanel {
    /**
     * The number of tiles until the tint pattern repeats.
     */
    private static final int TINTED_GROUP = 6;
    /**
     * The number of tiles to tint.
     */
    private static final int TINTED_COUNT = 3;

    /**
     * The color of the outline of the board.
     */
    private final Color outline;
    /**
     * The color of the board tile.
     */
    private final Color boardTile;
    /**
     * The color of the board tile when tinted.
     */
    private final Color tintedBoardTile;

    /**
     * Creates a new JigsawBoard.
     *
     * @param outlineColor The color of the outline.
     * @param thickness    The thickness of the outline.
     * @param boardColor         The color of the tile of the board.
     * @param tintedBoardColor   The color of the tile of the board when tinted.
     */
    public JigsawBoard(Color outlineColor, int thickness,
                       Color boardColor, Color tintedBoardColor) {
        this.outline = outlineColor;
        this.boardTile = boardColor;
        this.tintedBoardTile = tintedBoardColor;

        this.setBorder(BorderFactory.createLineBorder(outline, thickness));
    }

    /**
     * Paints the component.
     *
     * @param g The graphics to use.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                if ((i % TINTED_GROUP >= TINTED_COUNT) != (j % TINTED_GROUP >= TINTED_COUNT)) {
                    g.setColor(tintedBoardTile);
                } else {
                    g.setColor(boardTile);
                }

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
