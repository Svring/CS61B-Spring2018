package byog.lab5;

import org.junit.Test;
import static org.junit.Assert.*;
import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;
import java.util.Random;

//import javax.swing.text.Position;
/* try to call it but failed, so I just comment it out */

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    private static final long SEED = 114514;
    private static final Random RANDOM = new Random(SEED);

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] randomTiles = new TETile[WIDTH][HEIGHT];
        fillWithNothing(randomTiles);
        Position p = new Position(13, 16);
        createHexWorld(randomTiles, p, 3);

        ter.renderFrame(randomTiles);
    }

    public static void fillWithNothing(TETile[][] tiles) {
        int height = tiles[0].length;
        int width = tiles.length;
        for (int x = 0; x < width; x += 1) {
            for (int y = 0; y < height; y += 1) {
                tiles[x][y] = Tileset.NOTHING;
            }
        }
    }

    /**
     * draw a hexworld on the canvas
     * @param world the world to draw on
     * @param p position of lower left cornor of the lower left hex
     * @param s size of each hex
     */
    public static void createHexWorld(TETile[][] world, Position p, int s) {
        int que[] = {3, 4, 5, 4, 3}; 
        for (int i = 0; i < 5; i++) {
            int x = p.x + (s * 2 - 1) * i;
            int y;
            if (i < 3) {
                y = p.y - s * i;
            } else {
                y = p.y - s * (4 - i);
            }
            int n = que[i];
            Position pos = new Position(x, y);
            addHexagonColumn(world, pos, s, n);
        }
    }

    /**
     * draw a column of hex on the world
     * @param world the world to draw on
     * @param p position of the lowest hex of the column
     * @param s size of each hex
     * @param n number of hex of the column
     */
    public static void addHexagonColumn(TETile[][] world, Position p, int s, int n) {
        for (int i = 0; i < n; i++) {
            int x = p.x;
            int y = p.y + (s * 2) * i;
            Position pos = new Position(x, y);
            addHexagon(world, pos, s, randomTile());
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
            world[x][y] = TETile.colorVariant(t, 32, 32, 32, RANDOM);
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
    
    /** Picks a RANDOM tile with a 33% change of being
     *  a wall, 33% chance of being a flower, and 33%
     *  chance of being empty space.
     */
    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(3);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.WATER;
            default: return Tileset.NOTHING;
        }
    }

    /**
     * symbol of the position of lower left cornor of hex
     */
    private static class Position {
        private int x;
        private int y;

        public Position(int px, int py) {
            x = px;
            y = py;
        }
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
