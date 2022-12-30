import jigsaw.shapes.Block;
import jigsaw.shapes.Grid;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests the Grid class.
 */
public final class GridTest {
    /**
     * Assures that a block gets correctly placed on an empty grid.
     */
    @Test
    public void gridPlaceTest() {
        var grid = new Grid();

        Assertions.assertTrue(
                grid.tryPlace(0, 0,
                        new Block(new boolean[][]{
                                {false, true},
                                {true, true}
                        })));

        Assertions.assertFalse(grid.intersects(0, 0));
        Assertions.assertTrue(grid.intersects(0, 1));
        Assertions.assertTrue(grid.intersects(1, 0));
        Assertions.assertTrue(grid.intersects(1, 1));
    }

    /**
     * Assures that the block can be placed even if its outline intersects existing blocks, but the
     * cells themselves don't intersect them.
     */
    @Test
    public void gridPlaceWithPartialIntersectionTest() {
        var grid = new Grid();

        // 0 0 0 0
        // 0 0 0 1
        // 0 1 0 1
        // 0 1 1 1
        Assertions.assertTrue(
                grid.tryPlace(1, 1,
                        new Block(new boolean[][]{
                                {false, false, true},
                                {true, false, true},
                                {true, true, true}
                        })));

        // 2 0 2 2
        // 2 2 2 1
        // 2 1 2 1
        // 0 1 1 1
        Assertions.assertTrue(
                grid.tryPlace(0, 0,
                        new Block(new boolean[][]{
                                {true, false, true, true},
                                {true, true, true, false},
                                {true, false, true, false}
                        })));

        Assertions.assertTrue(grid.intersects(0, 0));
        Assertions.assertFalse(grid.intersects(0, 1));
        Assertions.assertTrue(grid.intersects(0, 2));
        Assertions.assertTrue(grid.intersects(0, 3));
        Assertions.assertTrue(grid.intersects(1, 0));
        Assertions.assertTrue(grid.intersects(1, 1));
        Assertions.assertTrue(grid.intersects(1, 2));
        Assertions.assertTrue(grid.intersects(1, 3));
        Assertions.assertTrue(grid.intersects(2, 0));
        Assertions.assertTrue(grid.intersects(2, 1));
        Assertions.assertTrue(grid.intersects(2, 2));
        Assertions.assertTrue(grid.intersects(2, 3));
        Assertions.assertFalse(grid.intersects(3, 0));
        Assertions.assertTrue(grid.intersects(3, 1));
        Assertions.assertTrue(grid.intersects(3, 2));
        Assertions.assertTrue(grid.intersects(3, 3));
    }

    /**
     * Assures that the {@link Grid#tryPlace} method does not place a block if there are
     * intersections.
     */
    @Test
    public void gridCannotPlaceTest() {
        var grid = new Grid();

        // 0 0 1
        // 1 0 1
        // 1 1 1
        Assertions.assertTrue(
                grid.tryPlace(0, 0,
                        new Block(new boolean[][]{
                                {false, false, true},
                                {true, false, true},
                                {true, true, true}
                        })));

        // 2 2 1
        // ! 2 1
        // 1 1 1
        Assertions.assertFalse(
                grid.tryPlace(0, 0,
                        new Block(new boolean[][]{
                                {true, true},
                                {true, true}
                        })));

        // 0 0 1
        // 1 0 1
        // 1 1 1
        Assertions.assertFalse(grid.intersects(0, 0));
        Assertions.assertFalse(grid.intersects(0, 1));
        Assertions.assertTrue(grid.intersects(0, 2));
        Assertions.assertTrue(grid.intersects(1, 0));
        Assertions.assertFalse(grid.intersects(1, 1));
        Assertions.assertTrue(grid.intersects(1, 2));
        Assertions.assertTrue(grid.intersects(2, 0));
        Assertions.assertTrue(grid.intersects(2, 1));
        Assertions.assertTrue(grid.intersects(2, 2));
    }
}
