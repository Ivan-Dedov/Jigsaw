package jigsaw.gui.themes;

import java.awt.Color;
import java.awt.Font;

/**
 * An interface describing a design theme.
 */
public interface Theme {

    //region Colors

    /**
     * Returns the background color of the frames.
     *
     * @return The background color of the frames.
     */
    Color getBackgroundColor();

    /**
     * Retrieves the color of the title of the game.
     *
     * @return The color of the title text.
     */
    Color getTitleColor();

    /**
     * Retrieves the color of the timer in the game.
     *
     * @return The color of the timer text.
     */
    Color getTimerTextColor();

    /**
     * Retrieves the color of the buttons in the game.
     *
     * @return The color of the button text.
     */
    Color getButtonColor();

    /**
     * Retrieves the color of the font of the button text in the game.
     *
     * @return The color of the font on the button.
     */
    Color getButtonFontColor();

    /**
     * Retrieves the color of the outline of the board.
     *
     * @return The color of the board outline.
     */
    Color getBoardOutlineColor();

    /**
     * Retrieves the color of the board.
     *
     * @return The color of the board.
     */
    Color getBoardColor();

    /**
     * Retrieves the color of the board when tinted.
     *
     * @return The color of the board when tinted.
     */
    Color getTintedBoardColor();

    /**
     * Retrieves the color of the text in the game.
     *
     * @return The color of the text.
     */
    Color getTextColor();

    /**
     * Retrieves the color of the shape on the board.
     *
     * @return The color of the shape.
     */
    Color getShapeColor();

    /**
     * Retrieves the color of the shape on the board when intersected with another shape.
     *
     * @return The color of the shape when intersected.
     */
    Color getIntersectedShapeColor();

    /**
     * Retrieves the color of the outline of the shape on the board.
     *
     * @return The color of the outline of the shape.
     */
    Color getShapeOutlineColor();

    //endregion

    //region Fonts

    /**
     * Retrieves the font of the title of the game.
     *
     * @return The font of the title text.
     */
    Font getTitleFont();

    /**
     * Retrieves the font of the timer in the game.
     *
     * @return The font of the timer text.
     */
    Font getTimerFont();

    /**
     * Retrieves the font of the button text in the game.
     *
     * @return The font of the button text.
     */
    Font getButtonFont();

    /**
     * Retrieves the font of the text in the game.
     *
     * @return The font of the text.
     */
    Font getTextFont();

    //endregion

    //region Other

    /**
     * Retrieves the thickness of the outline of the board.
     *
     * @return The thickness of the board outline.
     */
    int getBoardOutlineThickness();

    //endregion

}
