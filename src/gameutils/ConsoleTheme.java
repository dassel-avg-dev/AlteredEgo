package gameutils;

/**
 * Provides ANSI color escape constants, character theme colors,
 * and visible-width text formatting utilities using pure 7-bit ASCII.
 */
public class ConsoleTheme {

    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String DIM = "\u001B[2m";
    public static final String RED = "\u001B[31m";
    public static final String BRIGHT_RED = "\u001B[91m";
    public static final String GREEN = "\u001B[32m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    public static final String BLUE = "\u001B[34m";
    public static final String BRIGHT_BLUE = "\u001B[94m";
    public static final String PURPLE = "\u001B[35m";
    public static final String BRIGHT_PURPLE = "\u001B[95m";
    public static final String CYAN = "\u001B[36m";
    public static final String BRIGHT_CYAN = "\u001B[96m";
    public static final String WHITE = "\u001B[97m";
    public static final String GRAY = "\u001B[90m";

    private ConsoleTheme() {
        // Utility class
    }

    public static String getCharacterColor(String name) {
        if (name == null) {
            return WHITE;
        }
        return switch (name) {
            case "Cosmic Dassel" -> BRIGHT_GREEN;
            case "Khylle The Reaper" -> BRIGHT_RED;
            case "Earl" -> BRIGHT_YELLOW;
            case "The One John" -> WHITE;
            case "And Rew" -> BRIGHT_CYAN;
            case "OP Character" -> BRIGHT_PURPLE;
            case "Kaniel Outis" -> PURPLE;
            case "Van Berksville", "Van Berskville" -> RED;
            case "Asta Clover" -> YELLOW;
            case "JF Void" -> BLUE;
            case "Deidre" -> CYAN;
            case "Ohma Zi-O" -> BRIGHT_YELLOW;
            default -> WHITE;
        };
    }

    public static String stripAnsi(String text) {
        if (text == null) {
            return "";
        }
        return text.replaceAll("\u001B\\[[;\\d]*m", "");
    }

    public static int visibleLength(String text) {
        return stripAnsi(text).length();
    }

    public static String padRightVisible(String text, int targetWidth) {
        if (text == null) {
            text = "";
        }
        if (targetWidth <= 0) {
            return "";
        }
        int visLen = visibleLength(text);
        if (visLen == targetWidth) {
            return text;
        }
        if (visLen > targetWidth) {
            String plain = stripAnsi(text);
            return plain.substring(0, targetWidth);
        }
        return text + " ".repeat(targetWidth - visLen);
    }

    public static String centerVisible(String text, int targetWidth) {
        if (text == null) {
            text = "";
        }
        if (targetWidth <= 0) {
            return "";
        }
        int visLen = visibleLength(text);
        if (visLen >= targetWidth) {
            return padRightVisible(text, targetWidth);
        }
        int totalPadding = targetWidth - visLen;
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;
        return " ".repeat(leftPadding) + text + " ".repeat(rightPadding);
    }

    public static String buildHpBar(int current, int max, int barWidth) {
        max = Math.max(1, max);
        barWidth = Math.max(1, barWidth);
        int clampedCurrent = Math.max(0, Math.min(current, max));
        double ratio = (double) clampedCurrent / max;
        int filled = (int) Math.round(((double) Math.max(0, current) / max) * barWidth);
        filled = Math.max(0, Math.min(barWidth, filled));

        String color;
        if (ratio > 0.60) {
            color = BRIGHT_GREEN;
        } else if (ratio >= 0.30) {
            color = BRIGHT_YELLOW;
        } else {
            color = BRIGHT_RED;
        }

        return "[" + color + "#".repeat(filled) + GRAY + ".".repeat(Math.max(0, barWidth - filled)) + RESET
                + "] " + color + current + "/" + max + RESET;
    }

    public static String buildMpBar(int current, int max, int barWidth) {
        max = Math.max(1, max);
        barWidth = Math.max(1, barWidth);
        int filled = (int) Math.round(((double) Math.max(0, current) / max) * barWidth);
        filled = Math.max(0, Math.min(barWidth, filled));

        return "[" + BRIGHT_CYAN + "=".repeat(filled) + GRAY + ".".repeat(Math.max(0, barWidth - filled)) + RESET
                + "] " + BRIGHT_CYAN + current + "/" + max + RESET;
    }

    public static String formatSkillStatusBadge(int cooldown, boolean enoughMana) {
        if (cooldown > 0) {
            return YELLOW + "[CD:" + cooldown + "T]" + RESET;
        } else if (!enoughMana) {
            return BRIGHT_RED + "[NO MP]" + RESET;
        } else {
            return BRIGHT_GREEN + "[READY]" + RESET;
        }
    }
}
