package jigsaw;

import jigsaw.gui.themes.*;

public class Main {
    public static void main(String[] args) {
        JigsawGame game = new JigsawGame(getTheme(args));
        game.start();
    }

    private static Theme getTheme(String[] args) {
        if (args == null || args.length <= 0 || args[0].equals("0")) {
            return new LightTheme();
        }
        if (args[0].equals("1")) {
            return new DarkTheme();
        }
        if (args[0].equals("2")) {
            return new CodeTheme();
        }
        return new LightTheme();
    }
}
