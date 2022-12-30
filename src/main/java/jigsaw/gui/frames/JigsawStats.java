package jigsaw.gui.frames;

import jigsaw.JigsawGame;
import jigsaw.gui.components.JigsawButton;
import jigsaw.gui.components.JigsawLabel;
import jigsaw.gui.themes.Theme;
import jigsaw.gui.util.Constants;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;

/**
 * The frame containing the statistics of the game. Based on the JFrame class.
 */
public final class JigsawStats extends JFrame {
    /**
     * The width of the frame.
     */
    private static final int FRAME_WIDTH = 400;
    /**
     * The height of the frame.
     */
    private static final int FRAME_HEIGHT = 300;

    /**
     * Creates a new JigsawStats frame.
     *
     * @param theme     The design theme to use.
     * @param moveCount The number of moves made by the player.
     * @param covered   The % of tiles covered by the player.
     * @param time      The time the game lasted for.
     */
    public JigsawStats(Theme theme, int moveCount, double covered, String time) {
        setUpFrame();
        createElements(theme, moveCount, covered, time);

        this.setLayout(new BorderLayout());
        this.setVisible(true);
    }

    /**
     * Creates the elements in the frame.
     *
     * @param theme     The design theme to use.
     * @param moveCount The number of moves made by the player.
     * @param covered   The % of tiles covered by the player.
     * @param time      The time the game lasted for.
     */
    private void createElements(Theme theme, int moveCount, double covered, String time) {
        var gameOverLabel = new JigsawLabel(
                Constants.GAME_OVER,
                theme.getTitleColor(),
                theme.getTitleFont());
        gameOverLabel.setBounds(0, 20, 400, 50);

        var timeLabel = new JigsawLabel(
                "Time elapsed: " + time,
                theme.getTextColor(),
                theme.getTextFont());
        timeLabel.setBounds(0, 70, 400, 40);

        var moveLabel = new JigsawLabel(
                "Moves: " + moveCount,
                theme.getTextColor(),
                theme.getTextFont());
        moveLabel.setBounds(0, 110, 400, 40);

        var coveredLabel = new JigsawLabel(
                "Area covered: " + String.format("%.2f", covered) + "%",
                theme.getTextColor(),
                theme.getTextFont());
        coveredLabel.setBounds(0, 155, 400, 40);

        var playAgainButton = new JigsawButton(
                e -> {
                    this.dispose();
                    JigsawGame game = new JigsawGame(theme);
                    game.start();
                },
                "Play Again",
                theme.getButtonColor(),
                theme.getButtonFontColor(),
                theme.getButtonFont());
        playAgainButton.setBounds(25, 200, 150, 50);

        var quitButton = new JigsawButton(
                e -> this.dispose(),
                "Quit",
                theme.getButtonColor(),
                theme.getButtonFontColor(),
                theme.getButtonFont());
        quitButton.setBounds(225, 200, 150, 50);

        var pane = this.getContentPane();
        pane.setBackground(theme.getBackgroundColor());
        pane.add(gameOverLabel, BorderLayout.PAGE_START);
        pane.add(timeLabel, BorderLayout.CENTER);
        pane.add(moveLabel, BorderLayout.CENTER);
        pane.add(coveredLabel, BorderLayout.CENTER);
        pane.add(playAgainButton, BorderLayout.PAGE_END);
        pane.add(quitButton, BorderLayout.PAGE_END);
    }

    /**
     * Sets up the frame.
     */
    private void setUpFrame() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        this.setResizable(false);

        this.setTitle(Constants.GAME_OVER);
        this.setIconImage(new ImageIcon(Constants.LOGO_PATH).getImage());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
