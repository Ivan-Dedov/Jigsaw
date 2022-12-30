package jigsaw.gui.themes;

import java.awt.Color;
import java.awt.Font;

/**
 * A default design theme.
 */
public final class LightTheme implements Theme {

    //region Constants

    private static final Color BACKGROUND_COLOR = Color.WHITE;
    private static final Color TITLE_COLOR = Color.BLACK;
    private static final Color TIMER_TEXT_COLOR = Color.BLACK;
    private static final Color BUTTON_COLOR = new Color(173, 216, 230);
    private static final Color BUTTON_FONT_COLOR = Color.BLACK;
    private static final Color BOARD_OUTLINE_COLOR = Color.BLACK;
    private static final Color BOARD_COLOR = Color.WHITE;
    private static final Color BOARD_TINTED_COLOR = Color.LIGHT_GRAY;
    private static final Color TEXT_COLOR = Color.BLACK;
    private static final Color SHAPE_COLOR = Color.BLUE;
    private static final Color SHAPE_COLOR_INTERSECTED = Color.RED;
    private static final Color SHAPE_OUTLINE_COLOR = Color.BLACK;

    private static final Font TITLE_FONT = new Font("Arial", Font.BOLD, 36);
    private static final Font TIMER_FONT = new Font("Verdana", Font.PLAIN, 20);
    private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, 18);
    private static final Font TEXT_FONT = new Font("Arial", Font.PLAIN, 16);

    private static final int OUTLINE_THICKNESS = 5;

    //endregion

    //region Access methods

    /**
     * {@inheritDoc}
     */
    @Override
    public Color getBackgroundColor() {
        return BACKGROUND_COLOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color getTitleColor() {
        return TITLE_COLOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Font getTitleFont() {
        return TITLE_FONT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color getTimerTextColor() {
        return TIMER_TEXT_COLOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Font getTimerFont() {
        return TIMER_FONT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color getButtonColor() {
        return BUTTON_COLOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color getButtonFontColor() {
        return BUTTON_FONT_COLOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Font getButtonFont() {
        return BUTTON_FONT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color getBoardOutlineColor() {
        return BOARD_OUTLINE_COLOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getBoardOutlineThickness() {
        return OUTLINE_THICKNESS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color getBoardColor() {
        return BOARD_COLOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color getTintedBoardColor() {
        return BOARD_TINTED_COLOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color getTextColor() {
        return TEXT_COLOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Font getTextFont() {
        return TEXT_FONT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color getShapeColor() {
        return SHAPE_COLOR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color getIntersectedShapeColor() {
        return SHAPE_COLOR_INTERSECTED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color getShapeOutlineColor() {
        return SHAPE_OUTLINE_COLOR;
    }

    //endregion
}
