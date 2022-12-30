package jigsaw.shapes.generators;

import jigsaw.shapes.Block;
import jigsaw.shapes.Grid;
import jigsaw.shapes.JigsawShape;

import java.awt.Color;
import java.util.Random;

/**
 * A class that generates shapes for the game of Jigsaw.
 */
public final class ShapeGenerator implements Generator {

    //region Shapes

    /**
     * The number of shapes that can be generated.
     */
    private static final int SHAPE_COUNT = 31;

    /**
     * The array of shapes that can be generated represented as an array.
     * <p><b>NB!</b> Since some of them have 4 rotations, some have 2 and some only have 1, we're
     * just storing them like this so that the probability of getting any shape is equal.</p>
     */
    private final Block[] shapes = new Block[]{
            new Block(new boolean[][]{
                    {true, true },
                    {true, false},
                    {true, false}}),
            new Block(new boolean[][]{
                    {true, false, false},
                    {true, true,  true }}),
            new Block(new boolean[][]{
                    {false, true},
                    {false, true},
                    {true, true}}),
            new Block(new boolean[][]{
                    {true,  true,  true},
                    {false, false, true}}),

            new Block(new boolean[][]{
                    {true,  true},
                    {false, true},
                    {false, true}}),
            new Block(new boolean[][]{
                    {false, false, true},
                    {true,  true,  true}}),
            new Block(new boolean[][]{
                    {true, false},
                    {true, false},
                    {true, true }}),
            new Block(new boolean[][]{
                    {true, true,  true },
                    {true, false, false}}),

            new Block(new boolean[][]{
                    {true,  false},
                    {true,  true },
                    {false, true }}),
            new Block(new boolean[][]{
                    {false, true, true },
                    {true,  true, false}}),
            new Block(new boolean[][]{
                    {false, true},
                    {true,  true},
                    {true,  false}}),
            new Block(new boolean[][]{
                    {true,  true, false},
                    {false, true, true }}),

            new Block(new boolean[][]{
                    {false, false, true},
                    {false, false, true},
                    {true,  true,  true}}),
            new Block(new boolean[][]{
                    {true, false, false},
                    {true, false, false},
                    {true, true,  true }}),
            new Block(new boolean[][]{
                    {true, true,  true },
                    {true, false, false},
                    {true, false, false}}),
            new Block(new boolean[][]{
                    {true,  true,  true},
                    {false, false, true},
                    {false, false, true}}),

            new Block(new boolean[][]{
                    {false, true, false},
                    {false, true, false},
                    {true,  true, true }}),
            new Block(new boolean[][]{
                    {true,  true, true },
                    {false, true, false},
                    {false, true, false}}),
            new Block(new boolean[][]{
                    {true, false, false},
                    {true, true,  true },
                    {true, false, false}}),
            new Block(new boolean[][]{
                    {false, false, true},
                    {true,  true,  true},
                    {false, false, true}}),

            new Block(new boolean[][]{
                    {true, true, true}}),
            new Block(new boolean[][]{
                    {true},
                    {true},
                    {true}}),
            new Block(new boolean[][]{
                    {true}}),

            new Block(new boolean[][]{
                    {true, true },
                    {true, false}}),
            new Block(new boolean[][]{
                    {true,  true},
                    {false, true}}),
            new Block(new boolean[][]{
                    {false, true},
                    {true,  true}}),
            new Block(new boolean[][]{
                    {true, false},
                    {true, true}}),

            new Block(new boolean[][]{
                    {true, false},
                    {true, true },
                    {true, false}}),
            new Block(new boolean[][]{
                    {true,  true, true },
                    {false, true, false}}),
            new Block(new boolean[][]{
                    {false, true},
                    {true,  true},
                    {false, true}}),
            new Block(new boolean[][]{
                    {false, true, false},
                    {true,  true, true }})
    };

    //endregion

    /**
     * The randomizer to use.
     */
    private final Random randomizer;

    /**
     * The grid to generate the shapes for.
     */
    private final Grid grid;

    //region Theme

    /**
     * The color of the shape to use.
     */
    private final Color shapeColor;

    /**
     * The color of the shape to use when intersecting.
     */
    private final Color shapeColorIntersected;

    /**
     * The color of the outline of the shape to use.
     */
    private final Color outlineColor;

    //endregion

    /**
     * Creates a new ShapeGenerator.
     *
     * @param grid                  The grid to place shapes onto.
     * @param shapeColor            The color of the shape.
     * @param shapeColorIntersected The color of the shape when intersecting.
     * @param outline               The color of the outline of the shape.
     */
    public ShapeGenerator(Grid grid, Color shapeColor, Color shapeColorIntersected, Color outline) {
        this.randomizer = new Random();
        this.grid = grid;
        this.shapeColor = shapeColor;
        this.shapeColorIntersected = shapeColorIntersected;
        this.outlineColor = outline;
    }

    /**
     * {@inheritDoc}
     */
    public JigsawShape get() {
        return new JigsawShape(
                this.grid,
                shapes[randomizer.nextInt(SHAPE_COUNT)],
                shapeColor,
                shapeColorIntersected,
                outlineColor);
    }
}
