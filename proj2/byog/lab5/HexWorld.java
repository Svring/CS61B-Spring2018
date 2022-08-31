package byog.lab5;

import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

import javax.swing.text.Position;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    /**
     * symbol of the position of lower left cornor of hex
     */
    private static class Position {
        public int x;
        public int y;

        public Position(int px, int py) {
            x = px;
            y = py;
        }
    }

    /**
     * draw a hex on the world
     * @param world the world to draw on
     * @param p position of lower left cornor of the hex
     * @param s size of hex
     * @param t tile to draw
     */
    public static void addHexagon(TETile[][] world, Position p, int s, TETile t) {
        if (s < 2) {
            throw new IllegalArgumentException("size less than two, can't generate hex.");
        }
        for (int y = 0; y < s * 2; y++) {
            int thisRowWidth = hexRowWidth(s, y);
            int thisRowStartx = p.x + hexOffSet(s, y);
            int thisRowStarty = p.y + y;
            Position thisRowPosition = new Position(thisRowStartx, thisRowStarty);
            addRow(world, thisRowPosition, thisRowWidth, t);
        }
    }

    /**
     * add a row to the world
     * @param world the world to draw on
     * @param p positon of lower left cornor of the row
     * @param width the width of the row
     * @param t the tile to draw
     */
    public static void addRow(TETile[][] world, Position p, int width, TETile t) {
        for (int i = 0; i < width; i++) {
            int x = p.x + i;
            int y = p.y;
            world[x][y] = t;
        }
    }

    /**
     * compute the width of each row of certain size
     * @param s size of hex
     * @param i row number, 0 as the start
     * @return width of the row
     */
    private static int hexRowWidth(int s, int i) {
        if (i >= s) {
            return hexRowWidth(s, s * 2 - i - 1);
        }
        return s + i * 2;
    }

    /**
     * compute the offset of each row of certain size
     * @param s size of hex
     * @param i row number, 0 as the start
     * @return offset of the row
     */
    private static int hexOffSet(int s, int i) {
        if (i >= s) {
            return hexOffSet(s, s * 2 - i - 1);
        }
        return -i;
    }


    @Test
    public void testHexRowWidth() {
        assertEquals(3, hexRowWidth(3, 5));
        assertEquals(5, hexRowWidth(3, 4));
        assertEquals(7, hexRowWidth(3, 3));
        assertEquals(7, hexRowWidth(3, 2));
        assertEquals(5, hexRowWidth(3, 1));
        assertEquals(3, hexRowWidth(3, 0));
        assertEquals(2, hexRowWidth(2, 0));
        assertEquals(4, hexRowWidth(2, 1));
        assertEquals(4, hexRowWidth(2, 2));
        assertEquals(2, hexRowWidth(2, 3));
    }

    @Test
    public void testHexRowOffset() {
        assertEquals(0, hexOffSet(3, 5));
        assertEquals(-1, hexOffSet(3, 4));
        assertEquals(-2, hexOffSet(3, 3));
        assertEquals(-2, hexOffSet(3, 2));
        assertEquals(-1, hexOffSet(3, 1));
        assertEquals(0, hexOffSet(3, 0));
        assertEquals(0, hexOffSet(2, 0));
        assertEquals(-1, hexOffSet(2, 1));
        assertEquals(-1, hexOffSet(2, 2));
        assertEquals(0, hexOffSet(2, 3));
    }

}
