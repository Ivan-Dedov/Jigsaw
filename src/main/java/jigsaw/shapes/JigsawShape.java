package jigsaw.shapes;

import jigsaw.gui.util.Constants;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * A shape in the game of Jigsaw. Based on the JPanel class.
 */
public final class JigsawShape extends JPanel {

    //region Grid constants

    /**
     * The top left position of where the shapes spawn.
     */
    private static final Point DEFAULT_POSITION = new Point(525, 25);
    /**
     * The top left position of the grid.
     */
    private static final Point GRID_TOP_LEFT = new Point(25, 25);
    /**
     * The bottom right position of the grid.
     */
    private static final Point GRID_BOTTOM_RIGHT = new Point(
            (int) (GRID_TOP_LEFT.getX()) + Constants.CELL_SIZE * Constants.BOARD_SIZE,
            (int) (GRID_TOP_LEFT.getY()) + Constants.CELL_SIZE * Constants.BOARD_SIZE);

    //endregion

    /**
     * The shape that should be displayed.
     */
    private final Block shape;

    /**
     * The color of the shape.
     */
    private final Color shapeColor;
    /**
     * The color of the shape when intersected.
     */
    private final Color intersectedShapeColor;
    /**
     * The color of the outline of the shape.
     */
    private final Color outlineColor;

    /**
     * The grid upon which the shape will be placed.
     */
    private final Grid grid;

    /**
     * The current location of the shape.
     */
    private Point location;

    /**
     * The state of the shape: movable or not.
     */
    private boolean canMove;

    /**
     * Creates a new JigsawShape.
     *
     * @param grid                  The grid to place the shape on.
     * @param shape                 The shape we're working with.
     * @param shapeColor            The color of the shape.
     * @param shapeIntersectedColor The color of the shape when intersecting with other shapes.
     * @param outlineColor          The color of the outline of the shape.
     */
    public JigsawShape(Grid grid, Block shape,
                       Color shapeColor, Color shapeIntersectedColor, Color outlineColor) {
        this.shape = shape;
        this.grid = grid;
        this.location = DEFAULT_POSITION;
        this.canMove = true;
        this.shapeColor = shapeColor;
        this.intersectedShapeColor = shapeIntersectedColor;
        this.outlineColor = outlineColor;

        this.setOpaque(false);
        this.setBounds(0, 0, Constants.BOARD_WIDTH, Constants.BOARD_HEIGHT);

        this.addMouseListener(new JigsawMouseListener());
        this.addMouseMotionListener(new JigsawDragListener());
    }

    /**
     * Determines whether the shape is movable by the player.
     *
     * @return true, if it is; false, otherwise.
     */
    public boolean canMove() {
        return canMove;
    }

    public void lockIn() {
        var x = getCorrespondingGridCellIndex(
                (int) (GRID_TOP_LEFT.getX()),
                (int) (location.getX()));
        var y = getCorrespondingGridCellIndex(
                (int) (GRID_TOP_LEFT.getY()),
                (int) (location.getY()));

        if (location != DEFAULT_POSITION && grid.tryPlace(y, x, shape)) {
            canMove = false;
        }
    }

    /**
     * Paints the component.
     *
     * @param g The graphics to use.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < shape.getHeight(); i++) {
            for (int j = 0; j < shape.getWidth(); j++) {
                if (shape.at(i, j)) {
                    var x = getCorrespondingGridCellIndex(
                            (int) GRID_TOP_LEFT.getX(),
                            (int) location.getX() + j * Constants.CELL_SIZE);
                    var y = getCorrespondingGridCellIndex(
                            (int) GRID_TOP_LEFT.getY(),
                            (int) location.getY() + i * Constants.CELL_SIZE);

                    g.setColor(getColorBasedOnState(x, y));

                    g.fillRect(
                            (int) location.getX() + j * Constants.CELL_SIZE,
                            (int) location.getY() + i * Constants.CELL_SIZE,
                            Constants.CELL_SIZE,
                            Constants.CELL_SIZE);

                    g.setColor(outlineColor);
                    g.drawRect(
                            (int) location.getX() + j * Constants.CELL_SIZE,
                            (int) location.getY() + i * Constants.CELL_SIZE,
                            Constants.CELL_SIZE,
                            Constants.CELL_SIZE);
                }
            }
        }
    }

    /**
     * Returns the color that the shape should be based on its state and coordinates.
     *
     * @param x The row of the cell.
     * @param y The column of the cell.
     * @return The color to shade the shape into.
     */
    private Color getColorBasedOnState(int x, int y) {
        if (canMove) {
            if (grid.intersects(y, x) && isWithinGrid(location)) {
                return intersectedShapeColor;
            } else {
                return shapeColor;
            }
        } else {
            return shapeColor.darker();
        }
    }

    /**
     * Calculates the bottom right position of the given shape.
     *
     * @param point The top left point.
     * @return The bottom right point.
     */
    private Point getBottomRightPoint(Point point) {
        return new Point(
                (int) (point.getX()) + Constants.CELL_SIZE * (shape.getWidth() - 1),
                (int) (point.getY()) + Constants.CELL_SIZE * (shape.getHeight() - 1));
    }

    /**
     * Retrieves the closest grid intersection point to the given point.
     *
     * @param origin The point from which to start measuring coordinates.
     * @param pos    The coordinate of the point.
     * @return The integer coordinate of the closest grid intersection point.
     */
    private int getOptimalPoint(int origin, int pos) {
        return origin + Constants.CELL_SIZE * getCorrespondingGridCellIndex(origin, pos);
    }

    /**
     * Retrieves the index of the closest grid intersection point to the given point.
     *
     * @param origin The point from which to start measuring coordinates.
     * @param pos    The coordinate of the point.
     * @return The integer index of the closest grid intersection point.
     */
    private int getCorrespondingGridCellIndex(int origin, int pos) {
        int i = 0;
        while (i < Constants.BOARD_SIZE && Constants.CELL_SIZE * (i + 1) <= pos - origin) {
            i++;
        }
        return Math.min(i, Constants.BOARD_SIZE - 1);
    }

    /**
     * Retrieves the closest cell to snap to.
     *
     * @param point The top left point from which to measure distance.
     * @return The top left point of the closest cell.
     */
    private Point getClosestCell(Point point) {
        return new Point(
                getOptimalPoint((int) GRID_TOP_LEFT.getX(), (int) point.getX()),
                getOptimalPoint((int) GRID_TOP_LEFT.getY(), (int) point.getY()));
    }

    /**
     * Checks that the given shape is within the grid.
     *
     * @param topLeft The top left point.
     * @return true, if the shape is within the grid; false, otherwise.
     */
    private boolean isWithinGrid(Point topLeft) {
        var bottomRight = getBottomRightPoint(topLeft);
        return topLeft.getX() >= GRID_TOP_LEFT.getX()
                && topLeft.getY() >= GRID_TOP_LEFT.getY()
                && bottomRight.getX() <= GRID_BOTTOM_RIGHT.getX()
                && bottomRight.getY() <= GRID_BOTTOM_RIGHT.getY();
    }

    public int getTileCount() {
        int count = 0;
        for (int i = 0; i < shape.getHeight(); i++) {
            for (int j = 0; j < shape.getWidth(); j++) {
                if (shape.at(i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    //region Helper classes

    /**
     * A listener that checks for mouse presses.
     */
    private final class JigsawMouseListener extends MouseAdapter {
        public void mouseReleased(MouseEvent e) {
            var topLeft = location;

            // If the mouse is outside the snapping region, move it to the default space.
            if (!isWithinGrid(topLeft)) {
                location = DEFAULT_POSITION;
                repaint();
            }
        }
    }

    /**
     * A listener that handles dragging the shape.
     */
    private final class JigsawDragListener extends MouseMotionAdapter {
        public void mouseDragged(MouseEvent e) {
            if (!canMove) {
                return;
            }

            var topLeft = e.getPoint();
            var bottomRight = getBottomRightPoint(topLeft);

            // Moving the block only if it is inside the boundary.
            if (getBounds().contains(topLeft) && getBounds().contains(bottomRight)) {
                // Snapping the block if it is on the grid.
                location = isWithinGrid(topLeft)
                        ? getClosestCell(topLeft)
                        : topLeft;
            }
            repaint();
        }
    }

    //endregion
}
