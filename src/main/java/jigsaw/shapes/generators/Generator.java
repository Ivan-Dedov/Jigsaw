package jigsaw.shapes.generators;

import jigsaw.shapes.JigsawShape;

/**
 * An interface for generating shapes.
 */
public interface Generator {
    /**
     * Generates a new JigsawShape.
     *
     * @return The generated shape.
     */
    JigsawShape get();
}
