package jigsaw.gui.frames;

import jigsaw.gui.components.*;
import jigsaw.gui.themes.Theme;
import jigsaw.gui.util.Constants;
import jigsaw.shapes.generators.Generator;
import jigsaw.shapes.JigsawShape;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;

/**
 * A GUI for the Jigsaw game.
 */
public class JigsawGui extends JFrame {
    /**
     * The width of the frame.
     */
    private static final int FRAME_WIDTH = 800;
    /**
     * The height of the frame.
     */
    private static final int FRAME_HEIGHT = 800;

    /**
     * The design theme to use.
     */
    private final Theme theme;

    /**
     * The shape generator to use.
     */
    private final Generator generator;

    /**
     * The board area of the frame.
     */
    private JigsawBoardArea boardArea;

    /**
     * The timer of the frame.
     */
    private JigsawTimer timer;

    /**
     * The number of moves made by the player.
     */
    private int moveCount;

    /**
     * The number of tiles covered with shapes.
     */
    private int tilesCovered;

    /**
     * The current shape that the player can move.
     */
    private JigsawShape currentShape;

    /**
     * Creates a new JigsawGui.
     *
     * @param theme     The theme to use.
     * @param generator The shape generator to use.
     */
    public JigsawGui(Theme theme, Generator generator) {
        this.theme = theme;
        this.generator = generator;
        this.moveCount = 0;
        this.tilesCovered = 0;

        setUpFrame();
        createElements();

        this.setLayout(new BorderLayout());
        this.setVisible(true);
    }

    /**
     * Sets up the frame.
     */
    private void setUpFrame() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        this.setResizable(false);

        this.setTitle(Constants.APP_NAME);
        this.setIconImage(new ImageIcon(Constants.LOGO_PATH).getImage());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Creates the elements on the frame and places them.
     */
    private void createElements() {
        timer = new JigsawTimer(
                theme.getTimerTextColor(),
                theme.getTimerFont());
        timer.setBounds(200, 60, 400, 50);

        boardArea = new JigsawBoardArea();
        boardArea.setBounds(0, 125, 800, 500);

        var titleLabel = new JigsawLabel(
                Constants.APP_NAME,
                theme.getTitleColor(),
                theme.getTitleFont());
        titleLabel.setBounds(200, 10, 400, 50);

        var nextTurnButton = new JigsawButton(
                e -> {
                    currentShape.lockIn();
                    if (move()) {
                        moveCount++;
                    }
                },
                "Next Turn",
                theme.getButtonColor(),
                theme.getButtonFontColor(),
                theme.getButtonFont());
        nextTurnButton.setBounds(100, 700, 200, 50);

        var endButton = new JigsawButton(
                e -> endGame(),
                "End Game",
                theme.getButtonColor(),
                theme.getButtonFontColor(),
                theme.getButtonFont());
        endButton.setBounds(500, 700, 200, 50);

        var board = new JigsawBoard(
                theme.getBoardOutlineColor(),
                theme.getBoardOutlineThickness(),
                theme.getBoardColor(),
                theme.getTintedBoardColor());
        board.setBounds(25, 25, 450, 450);

        var generatorCell = new JigsawShapeCell(
                theme.getBoardOutlineColor(),
                theme.getBoardOutlineThickness(),
                theme.getBoardColor());
        generatorCell.setBounds(525, 25, 150, 150);

        boardArea.add(board, 0, 0);
        boardArea.add(generatorCell, 0, 0);

        var pane = this.getContentPane();
        pane.setBackground(theme.getBackgroundColor());
        pane.add(titleLabel, BorderLayout.PAGE_START);
        pane.add(timer, BorderLayout.PAGE_START);
        pane.add(boardArea, BorderLayout.CENTER);
        pane.add(nextTurnButton, BorderLayout.PAGE_END);
        pane.add(endButton, BorderLayout.PAGE_END);
    }

    /**
     * Starts the game.
     */
    public void play() {
        timer.start();
        move();
    }

    /**
     * Creates a new shape if the previous one was placed.
     *
     * @return true, if a new move was commenced; false, otherwise.
     */
    private boolean move() {
        if (currentShape != null && currentShape.canMove()) {
            return false;
        }

        if (currentShape != null) {
            tilesCovered += currentShape.getTileCount();
        }
        currentShape = generator.get();
        boardArea.add(currentShape, 2, 0);
        return true;
    }

    /**
     * Ends the game.
     */
    private void endGame() {
        timer.stop();
        this.dispose();

        var stats = new JigsawStats(
                theme,
                moveCount,
                (double) tilesCovered / (Constants.BOARD_SIZE * Constants.BOARD_SIZE) * 100,
                timer.getText());
        stats.setVisible(true);
    }
}
