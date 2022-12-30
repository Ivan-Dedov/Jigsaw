package jigsaw.shapes;

import jigsaw.gui.util.Constants;

/**
 * A grid for the game of Jigsaw.
 */
public final class Grid {
    /**
     * The grid containing the information about placed cells.
     */
    private final boolean[][] grid;

    /**
     * Creates a new Grid.
     */
    public Grid() {
        grid = new boolean[Constants.BOARD_SIZE][Constants.BOARD_SIZE];

        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                grid[i][j] = false;
            }
        }
    }

    /**
     * Checks if the given coordinates already have a placed shape.
     *
     * @param row The row to check.
     * @param col The column to check.
     * @return true, if the element already contains a shape placed in it; false, otherwise.
     */
    public boolean intersects(int row, int col) {
        return grid[row][col];
    }

    /**
     * Tries tu place a shape onto the grid.
     *
     * @param row   The index of the row of the top left point of the shape.
     * @param col   The index of the column of the top left point of the shape.
     * @param shape The shape to place.
     * @return true, if shape was placed; false, otherwise.
     */
    public boolean tryPlace(int row, int col, Block shape) {
        boolean canPlace = true;
        for (int i = 0; canPlace && i < shape.getHeight(); i++) {
            for (int j = 0; canPlace && j < shape.getWidth(); j++) {
                if (grid[row + i][col + j] && shape.at(i, j)) {
                    canPlace = false;
                }
            }
        }

        if (canPlace) {
            place(row, col, shape);
        }
        return canPlace;
    }

    /**
     * Places a shape.
     *
     * @param row   The index of the row of the top left point of the shape.
     * @param col   The index of the column of the top left point of the shape.
     * @param shape The shape to place.
     */
    private void place(int row, int col, Block shape) {
        for (int i = 0; i < shape.getHeight(); i++) {
            for (int j = 0; j < shape.getWidth(); j++) {
                grid[row + i][col + j] |= shape.at(i, j);
            }
        }
    }
}
