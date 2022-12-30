package jigsaw.gui.util;

import java.nio.file.Paths;

public final class Constants {
    /**
     * The name of the app.
     */
    public static final String APP_NAME = "Jigsaw";

    /**
     * The name of the app.
     */
    public static final String GAME_OVER = "Game Over";

    /**
     * The width of the board.
     */
    public static final int BOARD_WIDTH = 800;

    /**
     * The height of the board.
     */
    public static final int BOARD_HEIGHT = 475;

    /**
     * The path to the logo of the game.
     */
    public static final String LOGO_PATH =
            Paths.get("src", "main", "resources", "jigsaw.png").toString();

    /**
     * The size of the cell.
     */
    public static final int CELL_SIZE = 50;

    /**
     * The number of rows and columns on the board.
     */
    public static final int BOARD_SIZE = 9;
}
