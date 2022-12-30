import jigsaw.shapes.Block;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for the Block class.
 */
public final class BlockTest {
    /**
     * Assures that the height of the block (measured vertically) is calculated correctly.
     */
    @Test
    public void blockHeightTest() {
        var block = new Block(new boolean[][]{
                {true, false, false},
                {true, true, true}
        });

        Assertions.assertEquals(2, block.getHeight());
    }

    /**
     * Assures that the width of the block (measured horizontally) is calculated correctly.
     */
    @Test
    public void blockWidthTest() {
        var block = new Block(new boolean[][]{
                {true, false, false},
                {true, true, true}
        });

        Assertions.assertEquals(3, block.getWidth());
    }

    /**
     * Assures that the {@link Block#at} method works correctly and correctly determines, whether
     * the block has an occupied cell in the provided row and column, or not.
     */
    @Test
    public void getCellInBlockTest() {
        var block = new Block(new boolean[][]{
                {true, false, false},
                {false, true, true}
        });

        Assertions.assertTrue(block.at(0, 0));
        Assertions.assertFalse(block.at(0, 1));
        Assertions.assertFalse(block.at(0, 2));
        Assertions.assertFalse(block.at(1, 0));
        Assertions.assertTrue(block.at(1, 1));
        Assertions.assertTrue(block.at(1, 2));
    }
}
