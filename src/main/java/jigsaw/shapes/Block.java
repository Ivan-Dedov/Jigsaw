package jigsaw.shapes;

/**
 * A block in the Jigsaw game.
 */
public final class Block {
    /**
     * The block's insides: the boolean array describing the shape. Element is true, if the cell is
     * occupied; false, otherwise.
     */
    private final boolean[][] shape;

    /**
     * Creates a new Block.
     *
     * @param shape The block represents as a 2D boolean array.
     */
    public Block(boolean[][] shape) {
        this.shape = shape;
    }

    /**
     * Retrieves the width of the shape.
     *
     * @return The width of the shape.
     */
    public int getWidth() {
        return shape[0].length;
    }

    /**
     * Retrieves the height of the shape.
     *
     * @return The height of the shape.
     */
    public int getHeight() {
        return shape.length;
    }

    /**
     * Determines whether the cell at the provided row and column are occupied.
     *
     * @param row    The row.
     * @param column The column.
     * @return true, if the block has a cell at that position; false, otherwise.
     */
    public boolean at(int row, int column) {
        return shape[row][column];
    }
}
