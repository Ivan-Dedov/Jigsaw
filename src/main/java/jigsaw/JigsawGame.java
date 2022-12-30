package jigsaw;

import jigsaw.gui.frames.JigsawGui;
import jigsaw.gui.themes.Theme;
import jigsaw.shapes.Grid;
import jigsaw.shapes.generators.ShapeGenerator;

/**
 * A game of Jigsaw.
 */
public final class JigsawGame {
    /**
     * The GUI to use.
     */
    private final JigsawGui gui;

    /**
     * Creates a new game of Jigsaw.
     *
     * @param theme The design theme to use when playing.
     */
    public JigsawGame(Theme theme) {
        gui = new JigsawGui(
                theme,
                new ShapeGenerator(
                        new Grid(),
                        theme.getShapeColor(),
                        theme.getIntersectedShapeColor(),
                        theme.getShapeOutlineColor()));
    }

    /**
     * Starts the game.
     */
    public void start() {
        gui.play();
    }
}
