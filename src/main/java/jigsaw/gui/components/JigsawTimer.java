package jigsaw.gui.components;

import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

/**
 * Timer for the game of Jigsaw. Based on the JLabel class.
 */
public final class JigsawTimer extends JLabel {

    //region Timer constants

    /**
     * Update interval, in milliseconds.
     */
    private static final int UPDATE_INTERVAL_MS = 1000;
    /**
     * The minimum number of digits to display in each group.
     */
    private static final int TIME_DIGIT_COUNT = 2;

    //endregion

    /**
     * The inner timer.
     */
    private final Timer timer;
    /**
     * The number of minutes elapsed since the timer was started.
     */
    private long elapsedMinutes = 0;
    /**
     * The number of seconds elapsed since the timer was started.
     */
    private long elapsedSeconds = 0;

    /**
     * Creates a new JigsawTimer.
     *
     * @param color  The color of the text.
     * @param font   The font of the text.
     */
    public JigsawTimer(Color color, Font font) {
        timer = new Timer(
                UPDATE_INTERVAL_MS,
                x -> {
                    elapsedSeconds++;
                    if (elapsedSeconds >= 60) {
                        elapsedMinutes++;
                        elapsedSeconds = 0;
                    }
                    this.repaint();
                });

        this.setForeground(color);
        this.setFont(font);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalAlignment(SwingConstants.CENTER);
    }

    /**
     * Starts the timer.
     */
    public void start() {
        timer.start();
    }

    /**
     * Stops the timer.
     */
    public void stop() {
        timer.stop();
    }

    /**
     * Retrieves the text on the timer.
     *
     * @return The string value on display of the timer.
     */
    @Override
    public String getText() {
        return formatTemporalUnit(elapsedMinutes) + ":" + formatTemporalUnit(elapsedSeconds);
    }

    /**
     * Formats the provided number to fit the rules of a temporal string (i.e. adding extra
     * zeroes).
     *
     * @param value The number to format.
     * @return A string, formatted as a temporal value.
     */
    private static String formatTemporalUnit(long value) {
        var repeatCount = TIME_DIGIT_COUNT - (value + "").length();
        if (repeatCount < 0) {
            return value + "";
        }
        return "0".repeat(repeatCount) + value;
    }
}
