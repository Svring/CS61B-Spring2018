package proj2.byog.lab6;

import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import proj0.StdDraw;
import java.awt.Font;

@SuppressWarnings("unused")
public class MemoryGame {
    private int width;
    private int height;
    private int round;
    private Random rand;
    private boolean gameOver;
    private boolean playerTurn;
    private static final char[] CHARACTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final String[] ENCOURAGEMENT = {"You can do this!", "I believe in you!",
                                                   "You got this!", "You're a star!", "Go Bears!",
                                                   "Too easy for you!", "Wow, so impressive!"};

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter a seed");
            return;
        }

        int seed = Integer.parseInt(args[0]);
        MemoryGame game = new MemoryGame(40, 40, seed);
        game.startGame();
    }

    public MemoryGame(int width, int height, int seed) {
        /* Sets up StdDraw so that it has a width by height grid of 16 by 16 squares as its canvas
         * Also sets up the scale so the top left is (0,0) and the bottom right is (width, height)
         */
        this.width = width;
        this.height = height;
        StdDraw.setCanvasSize(this.width * 16, this.height * 16);
        Font font = new Font("Monaco", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.setXscale(0, this.width);
        StdDraw.setYscale(0, this.height);
        StdDraw.clear(Color.BLACK);
        StdDraw.enableDoubleBuffering();

        //Initialize random number generator
        rand = new Random(seed);
    }

    public String generateRandomString(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s += CHARACTERS[rand.nextInt(26)];
        }
        return s;
    }

    public void drawFrame(String s) {
        StdDraw.clear();

        if (!gameOver) {
            Font smallFont = new Font("Manaco", Font.BOLD, 20);
            StdDraw.setFont(smallFont);
            StdDraw.setPenColor(StdDraw.PINK);
            StdDraw.line(0, height - 2, width, height - 2);
            StdDraw.textLeft(1, height - 1, "Round" + round);
            StdDraw.textRight(width - 1, height - 1, "Hello world!");
            StdDraw.text(width / 2, height - 1, playerTurn ? "Type" : "Watch");
        }

        Font font = new Font("Bold", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.setPenColor(StdDraw.PINK);
        StdDraw.text(width / 2, height / 2, s);
        StdDraw.show();
    }

    public void flashSequence(String letters) {
        char[] C = letters.toCharArray();
        for (int i = 0; i < letters.length(); i++) {
            StdDraw.pause(500);
            String s = String.valueOf(C[i]);
            drawFrame(s);
            StdDraw.pause(1000);
            drawFrame("");
        }
    }

    public String solicitNCharsInput(int n) {
        String s = "";
        drawFrame(s);
        while (s.length() < n) {
            if (!StdDraw.hasNextKeyTyped()) {
                continue;
            }
            char key = StdDraw.nextKeyTyped();
            s += String.valueOf(key);
            drawFrame(s);
        }
        StdDraw.pause(1000);
        return s;
    }

    public void startGame() {
        gameOver = false;
        playerTurn = false;
        round = 1;
        while (!gameOver) {
            playerTurn = false;
            drawFrame("Round: " + round);
            StdDraw.pause(1000);

            String roundString = generateRandomString(round);
            flashSequence(roundString);

            playerTurn = true;
            String input = solicitNCharsInput(round);

            if (input.equals(roundString)) {
                drawFrame("Well done");
                StdDraw.pause(1500);
                round++;
            } else {
                gameOver = true;
                drawFrame("Sorry...Wrong answer at round " + round);
                StdDraw.pause(1500);
            }
        }
    }

}
