package jigsaw.gui.themes;

import java.awt.Color;
import java.awt.Font;

/**
 * A default design theme.
 */
public final class DarkTheme implements Theme {

    //region Constants

    private static final Color BACKGROUND_COLOR = new Color(27, 0, 68);
    private static final Color TITLE_COLOR = new Color(214, 197, 240);
    private static final Color TIMER_TEXT_COLOR = new Color(214, 197, 240);
    private static final Color BUTTON_COLOR = new Color(87, 39, 163);
    private static final Color BUTTON_FONT_COLOR = new Color(214, 197, 240);
    private static final Color BOARD_OUTLINE_COLOR = new Color(214, 197, 240);
    private static final Color BOARD_COLOR = new Color(145, 83, 244);
    private static final Color BOARD_TINTED_COLOR = new Color(87, 39, 163);
    private static final Color TEXT_COLOR = new Color(214, 197, 240);
    private static final Color SHAPE_COLOR = new Color(226, 207, 255);
    private static final Color SHAPE_COLOR_INTERSECTED = new Color(242, 107, 138);
    private static final Color SHAPE_OUTLINE_COLOR = new Color(158, 144, 178);

    private static final Font TITLE_FONT = new Font("Lucida Console", Font.BOLD, 36);
    private static final Font TIMER_FONT = new Font("Trebuchet MS", Font.PLAIN, 20);
    private static final Font BUTTON_FONT = new Font("Lucida Console", Font.BOLD, 12);
    private static final Font TEXT_FONT = new Font("Lucida Console", Font.PLAIN, 16);

    private static final int OUTLINE_THICKNESS = 3;

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
