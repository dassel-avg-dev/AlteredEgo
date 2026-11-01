package gameutils;

import java.util.List;

/**
 * Renders full 7-bit ASCII arcade cabinets, character select tables, portrait galleries,
 * split-screen battle HUDs, 2x2 tactical skill decks, VS splash screens, and Arcade tower maps.
 */
public class BattleHudRenderer {

    private static final int BOX_INNER_WIDTH = 76; // 78 total columns (+ ... +)
    private static final int COL_WIDTH = 37;       // 37 + 1 (divider) + 38 = 76
    private static final int RIGHT_COL_WIDTH = 38;

    private BattleHudRenderer() {
        // Utility class
    }

    // ==================== 1. Game Mode Menu ====================

    public static void renderGameModeMenu() {
        String topBorder = ConsoleTheme.BRIGHT_PURPLE + "+============================================================================+" + ConsoleTheme.RESET;
        String midBorder = ConsoleTheme.PURPLE + "+----------------------------------------------------------------------------+" + ConsoleTheme.RESET;
        String subBorder = ConsoleTheme.GRAY + "|" + "-".repeat(BOX_INNER_WIDTH) + "|" + ConsoleTheme.RESET;

        System.out.println();
        System.out.println(topBorder);
        printBoxRow(ConsoleTheme.centerVisible(
                ConsoleTheme.BOLD + ConsoleTheme.BRIGHT_CYAN + ">>>  SELECT ARCADE BATTLE MODE  <<<" + ConsoleTheme.RESET,
                BOX_INNER_WIDTH));
        System.out.println(midBorder);

        printBoxRow("  " + ConsoleTheme.BRIGHT_GREEN + ConsoleTheme.BOLD + "[1] PLAYER VS PLAYER (LOCAL VERSUS)" + ConsoleTheme.RESET
                + ConsoleTheme.GRAY + "        -- Best-of-3 Duel" + ConsoleTheme.RESET);
        printBoxRow("      " + ConsoleTheme.WHITE + "Two challengers enter the terminal arena. Only one walks out." + ConsoleTheme.RESET);
        System.out.println(subBorder);

        printBoxRow("  " + ConsoleTheme.BRIGHT_CYAN + ConsoleTheme.BOLD + "[2] PLAYER VS COMPUTER (AI DUEL)" + ConsoleTheme.RESET
                + ConsoleTheme.GRAY + "           -- Best-of-3 Tactical AI" + ConsoleTheme.RESET);
        printBoxRow("      " + ConsoleTheme.WHITE + "Test your skills against an unpredictable Altered Ego AI." + ConsoleTheme.RESET);
        System.out.println(subBorder);

        printBoxRow("  " + ConsoleTheme.BRIGHT_YELLOW + ConsoleTheme.BOLD + "[3] ARCADE MODE (THE GAUNTLET)" + ConsoleTheme.RESET
                + ConsoleTheme.GRAY + "             -- 5-Stage Tower + Hidden Boss" + ConsoleTheme.RESET);
        printBoxRow("      " + ConsoleTheme.WHITE + "Survive all 5 Altered Egos in a row to awaken the Time Rift King!" + ConsoleTheme.RESET);
        System.out.println(subBorder);

        printBoxRow("  " + ConsoleTheme.BRIGHT_PURPLE + ConsoleTheme.BOLD + "[4] RANDOM FATE (MYSTERY MODE)" + ConsoleTheme.RESET
                + ConsoleTheme.GRAY + "             -- Let the Cursed Console Decide" + ConsoleTheme.RESET);
        printBoxRow("      " + ConsoleTheme.WHITE + "Spins the wheel of fate and drops you into a random battle mode." + ConsoleTheme.RESET);

        System.out.println(topBorder);
    }

    // ==================== 2. Character Select Screen ====================

    public static void renderCharacterSelectScreen(boolean isEnemy, boolean isPVP, String headerTitle) {
        String title = (headerTitle != null && !headerTitle.isBlank())
                ? headerTitle
                : (isEnemy
                    ? (isPVP ? "PLAYER 2: CHOOSE YOUR ALTERED EGO" : "SELECT YOUR ENEMY OPPONENT")
                    : (isPVP ? "PLAYER 1: CHOOSE YOUR CHAMPION" : "CHOOSE YOUR HERO FIGHTER"));

        GameCharacter[] roster = new GameCharacter[5];
        for (int i = 1; i <= 5; i++) {
            roster[i - 1] = isEnemy ? Enemy.createByChoice(i) : Player.createByChoice(i);
        }

        String borderColor = isEnemy ? ConsoleTheme.BRIGHT_RED : ConsoleTheme.BRIGHT_CYAN;
        String topBorder = borderColor + "+============================================================================+" + ConsoleTheme.RESET;
        String tableSep  = borderColor + "+----+--------------------+------------------+-------+-------+---------------+" + ConsoleTheme.RESET;

        System.out.println();
        System.out.println(topBorder);
        printBoxRow(ConsoleTheme.centerVisible(
                ConsoleTheme.BOLD + ConsoleTheme.BRIGHT_YELLOW + "[ " + title + " ]" + ConsoleTheme.RESET,
                BOX_INNER_WIDTH), borderColor);
        System.out.println(tableSep);

        // Table Header
        String headerRow = borderColor + "|" + ConsoleTheme.RESET
                + ConsoleTheme.centerVisible(ConsoleTheme.BOLD + "#" + ConsoleTheme.RESET, 4)
                + borderColor + "|" + ConsoleTheme.RESET
                + " " + ConsoleTheme.padRightVisible(ConsoleTheme.BOLD + "Fighter Name" + ConsoleTheme.RESET, 19)
                + borderColor + "|" + ConsoleTheme.RESET
                + " " + ConsoleTheme.padRightVisible(ConsoleTheme.BOLD + "Archetype" + ConsoleTheme.RESET, 17)
                + borderColor + "|" + ConsoleTheme.RESET
                + ConsoleTheme.centerVisible(ConsoleTheme.BOLD + "HP" + ConsoleTheme.RESET, 7)
                + borderColor + "|" + ConsoleTheme.RESET
                + ConsoleTheme.centerVisible(ConsoleTheme.BOLD + "MP" + ConsoleTheme.RESET, 7)
                + borderColor + "|" + ConsoleTheme.RESET
                + " " + ConsoleTheme.padRightVisible(ConsoleTheme.BOLD + "Ultimate" + ConsoleTheme.RESET, 14)
                + borderColor + "|" + ConsoleTheme.RESET;
        System.out.println(headerRow);
        System.out.println(tableSep);

        for (int i = 0; i < 5; i++) {
            GameCharacter c = roster[i];
            String charColor = ConsoleTheme.getCharacterColor(c.getName());
            String role = truncatePlain(AsciiArtAssets.getCharacterRole(c.getName()), 16);
            String ult = truncatePlain(c.getSkillThreeName(), 13);

            String row = borderColor + "|" + ConsoleTheme.RESET
                    + ConsoleTheme.centerVisible(ConsoleTheme.BRIGHT_YELLOW + "[" + (i + 1) + "]" + ConsoleTheme.RESET, 4)
                    + borderColor + "|" + ConsoleTheme.RESET
                    + " " + ConsoleTheme.padRightVisible(charColor + ConsoleTheme.BOLD + truncatePlain(c.getName(), 18) + ConsoleTheme.RESET, 19)
                    + borderColor + "|" + ConsoleTheme.RESET
                    + " " + ConsoleTheme.padRightVisible(ConsoleTheme.WHITE + role + ConsoleTheme.RESET, 17)
                    + borderColor + "|" + ConsoleTheme.RESET
                    + ConsoleTheme.centerVisible(ConsoleTheme.BRIGHT_GREEN + c.getMaxHitpoints() + ConsoleTheme.RESET, 7)
                    + borderColor + "|" + ConsoleTheme.RESET
                    + ConsoleTheme.centerVisible(ConsoleTheme.BRIGHT_CYAN + c.getMaxMana() + ConsoleTheme.RESET, 7)
                    + borderColor + "|" + ConsoleTheme.RESET
                    + " " + ConsoleTheme.padRightVisible(ConsoleTheme.BRIGHT_PURPLE + ult + ConsoleTheme.RESET, 14)
                    + borderColor + "|" + ConsoleTheme.RESET;
            System.out.println(row);
        }

        System.out.println(tableSep);
        String randomRow = "  " + ConsoleTheme.BRIGHT_YELLOW + "[6] RANDOM FIGHTER" + ConsoleTheme.RESET
                + ConsoleTheme.GRAY + "  -- Let fate pick your fighter!"
                + (!isEnemy ? "  (Secret: [0] Admin Override)" : "") + ConsoleTheme.RESET;
        printBoxRow(randomRow, borderColor);
        System.out.println(topBorder);

        // Mini ASCII Portrait Gallery (all 5 fighters side-by-side, 14 chars per slot)
        renderPortraitGallery(roster, borderColor);
    }

    private static void renderPortraitGallery(GameCharacter[] roster, String borderColor) {
        String galleryTop = borderColor + "+--------------+--------------+--------------+--------------+--------------+" + ConsoleTheme.RESET;
        System.out.println(galleryTop);

        // Fighter names row
        StringBuilder nameRow = new StringBuilder(borderColor + "|" + ConsoleTheme.RESET);
        for (int i = 0; i < 5; i++) {
            String name = "[" + (i + 1) + "] " + shortFighterName(roster[i].getName());
            String color = ConsoleTheme.getCharacterColor(roster[i].getName());
            nameRow.append(ConsoleTheme.centerVisible(color + ConsoleTheme.BOLD + truncatePlain(name, 12) + ConsoleTheme.RESET, 14))
                   .append(borderColor).append("|").append(ConsoleTheme.RESET);
        }
        System.out.println(nameRow);
        System.out.println(galleryTop);

        // Render middle 5 lines of each portrait (lines 1..5 of the 8-line portrait) for a compact gallery
        String[][] portraits = new String[5][];
        for (int i = 0; i < 5; i++) {
            portraits[i] = AsciiArtAssets.getCharacterPortrait(roster[i].getName());
        }

        for (int lineIdx = 0; lineIdx < 8; lineIdx++) {
            StringBuilder artRow = new StringBuilder(borderColor + "|" + ConsoleTheme.RESET);
            for (int i = 0; i < 5; i++) {
                String rawLine = (portraits[i] != null && lineIdx < portraits[i].length) ? portraits[i][lineIdx] : "";
                String trimmed = centerCropPlain(rawLine, 12);
                String color = ConsoleTheme.getCharacterColor(roster[i].getName());
                artRow.append(" ")
                      .append(color).append(ConsoleTheme.padRightVisible(trimmed, 12)).append(ConsoleTheme.RESET)
                      .append(" ")
                      .append(borderColor).append("|").append(ConsoleTheme.RESET);
            }
            System.out.println(artRow);
        }

        System.out.println(galleryTop);
    }

    // ==================== 3. VS Splash Screen ====================

    public static void renderVsSplashScreen(GameCharacter left, GameCharacter right, boolean isCounterpart) {
        if (left == null || right == null) {
            return;
        }

        String leftColor = ConsoleTheme.getCharacterColor(left.getName());
        String rightColor = ConsoleTheme.getCharacterColor(right.getName());
        String leftRole = AsciiArtAssets.getCharacterRole(left.getName());
        String rightRole = AsciiArtAssets.getCharacterRole(right.getName());
        String[] leftPortrait = AsciiArtAssets.getCharacterPortrait(left.getName());
        String[] rightPortrait = AsciiArtAssets.getCharacterPortrait(right.getName());

        String topBorder = ConsoleTheme.BRIGHT_YELLOW + "+============================================================================+" + ConsoleTheme.RESET;
        String midBorder = ConsoleTheme.YELLOW + "+----------------------------------------------------------------------------+" + ConsoleTheme.RESET;

        System.out.println();
        if (isCounterpart) {
            System.out.println(ConsoleTheme.BRIGHT_RED + ConsoleTheme.BOLD
                    + "  +--- [!] FATAL MIRROR ENCOUNTER: ALTERED EGO COUNTERPART DETECTED [!] ---+"
                    + ConsoleTheme.RESET);
        }

        System.out.println(topBorder);
        String headerTitle = isCounterpart
                ? ConsoleTheme.BRIGHT_RED + ConsoleTheme.BOLD + ">>>  ALTERED EGO CLASH: MIRROR TIMELINE FRACTURE  <<<" + ConsoleTheme.RESET
                : ConsoleTheme.BRIGHT_YELLOW + ConsoleTheme.BOLD + ">>>  STAGE MATCHUP: THE BATTLE BEGINS  <<<" + ConsoleTheme.RESET;
        printBoxRow(ConsoleTheme.centerVisible(headerTitle, BOX_INNER_WIDTH), ConsoleTheme.BRIGHT_YELLOW);
        System.out.println(midBorder);

        // Fighter names & roles
        String leftNameCell = ConsoleTheme.centerVisible(leftColor + ConsoleTheme.BOLD + left.getName() + ConsoleTheme.RESET, 30);
        String rightNameCell = ConsoleTheme.centerVisible(rightColor + ConsoleTheme.BOLD + right.getName() + ConsoleTheme.RESET, 30);
        String vsBadge = ConsoleTheme.centerVisible(ConsoleTheme.BRIGHT_RED + ConsoleTheme.BOLD + "//  VS  //" + ConsoleTheme.RESET, 16);
        printBoxRow(leftNameCell + vsBadge + rightNameCell, ConsoleTheme.BRIGHT_YELLOW);

        String leftRoleCell = ConsoleTheme.centerVisible(ConsoleTheme.GRAY + "[" + truncatePlain(leftRole, 26) + "]" + ConsoleTheme.RESET, 30);
        String rightRoleCell = ConsoleTheme.centerVisible(ConsoleTheme.GRAY + "[" + truncatePlain(rightRole, 26) + "]" + ConsoleTheme.RESET, 30);
        String vsSpark = ConsoleTheme.centerVisible(ConsoleTheme.BRIGHT_YELLOW + "============" + ConsoleTheme.RESET, 16);
        printBoxRow(leftRoleCell + vsSpark + rightRoleCell, ConsoleTheme.BRIGHT_YELLOW);
        System.out.println(midBorder);

        String[] vsCenterArt = {
                "      //      ",
                "     //       ",
                "  \\ // /      ",
                " -- V S --    ",
                "  / // \\      ",
                "   //         ",
                "  //          ",
                "              "
        };

        for (int i = 0; i < 8; i++) {
            String lLine = (leftPortrait != null && i < leftPortrait.length) ? leftPortrait[i] : "";
            String rLine = (rightPortrait != null && i < rightPortrait.length) ? rightPortrait[i] : "";
            String lFormatted = ConsoleTheme.centerVisible(leftColor + lLine + ConsoleTheme.RESET, 30);
            String cFormatted = ConsoleTheme.centerVisible(ConsoleTheme.BRIGHT_YELLOW + ConsoleTheme.BOLD + vsCenterArt[i] + ConsoleTheme.RESET, 16);
            String rFormatted = ConsoleTheme.centerVisible(rightColor + rLine + ConsoleTheme.RESET, 30);
            printBoxRow(lFormatted + cFormatted + rFormatted, ConsoleTheme.BRIGHT_YELLOW);
        }

        System.out.println(midBorder);
        String leftStats = ConsoleTheme.centerVisible(
                ConsoleTheme.BRIGHT_GREEN + "HP: " + left.getMaxHitpoints() + ConsoleTheme.RESET
                        + "  " + ConsoleTheme.BRIGHT_CYAN + "MP: " + left.getMaxMana() + ConsoleTheme.RESET
                        + "  " + ConsoleTheme.BRIGHT_PURPLE + "ULT: " + truncatePlain(left.getSkillThreeName(), 11) + ConsoleTheme.RESET,
                35);
        String rightStats = ConsoleTheme.centerVisible(
                ConsoleTheme.BRIGHT_GREEN + "HP: " + right.getMaxHitpoints() + ConsoleTheme.RESET
                        + "  " + ConsoleTheme.BRIGHT_CYAN + "MP: " + right.getMaxMana() + ConsoleTheme.RESET
                        + "  " + ConsoleTheme.BRIGHT_PURPLE + "ULT: " + truncatePlain(right.getSkillThreeName(), 11) + ConsoleTheme.RESET,
                35);
        printBoxRow(leftStats + ConsoleTheme.centerVisible(ConsoleTheme.GRAY + "<>" + ConsoleTheme.RESET, 6) + rightStats, ConsoleTheme.BRIGHT_YELLOW);
        System.out.println(topBorder);
    }

    // ==================== 4. Split-Screen Battle HUD ====================

    public static void renderSplitBattleHud(
            String modeLabel,
            int roundNum,
            int turnNum,
            GameCharacter left,
            String leftLabel,
            GameCharacter right,
            String rightLabel,
            int leftWins,
            int rightWins,
            boolean showRoundScore
    ) {
        if (left == null || right == null) {
            return;
        }

        String topBorder = ConsoleTheme.BRIGHT_CYAN + "+============================================================================+" + ConsoleTheme.RESET;
        String splitBorder = ConsoleTheme.CYAN + "+-------------------------------------+--------------------------------------+" + ConsoleTheme.RESET;

        System.out.println();
        System.out.println(topBorder);

        String modeText = ConsoleTheme.BOLD + ConsoleTheme.BRIGHT_PURPLE + "[" + (modeLabel != null ? modeLabel : "BATTLE") + "]" + ConsoleTheme.RESET;
        String roundTurnText = ConsoleTheme.BOLD + ConsoleTheme.BRIGHT_YELLOW + "ROUND " + roundNum + " - TURN " + turnNum + ConsoleTheme.RESET;

        if (showRoundScore) {
            String scorePips = ConsoleTheme.BRIGHT_GREEN + buildWinPips(leftWins, 2) + ConsoleTheme.RESET
                    + ConsoleTheme.GRAY + " vs " + ConsoleTheme.RESET
                    + ConsoleTheme.BRIGHT_RED + buildWinPips(rightWins, 2) + ConsoleTheme.RESET;
            String headerLine = " " + ConsoleTheme.padRightVisible(modeText, 24)
                    + ConsoleTheme.centerVisible(roundTurnText, 24)
                    + ConsoleTheme.padRightVisible("   SCORE: " + scorePips, 27);
            printBoxRow(headerLine, ConsoleTheme.BRIGHT_CYAN);
        } else {
            String headerLine = " " + ConsoleTheme.padRightVisible(modeText, 30)
                    + ConsoleTheme.padRightVisible(roundTurnText, 45);
            printBoxRow(headerLine, ConsoleTheme.BRIGHT_CYAN);
        }

        System.out.println(splitBorder);

        String leftColor = ConsoleTheme.getCharacterColor(left.getName());
        String rightColor = ConsoleTheme.getCharacterColor(right.getName());

        // Fighter Label + Name
        String leftTitle = " " + ConsoleTheme.GRAY + "[" + leftLabel + "] " + ConsoleTheme.RESET
                + leftColor + ConsoleTheme.BOLD + truncatePlain(left.getName(), 22) + ConsoleTheme.RESET;
        String rightTitle = " " + ConsoleTheme.GRAY + "[" + rightLabel + "] " + ConsoleTheme.RESET
                + rightColor + ConsoleTheme.BOLD + truncatePlain(right.getName(), 22) + ConsoleTheme.RESET;
        printSplitRow(leftTitle, rightTitle, ConsoleTheme.CYAN);

        // Archetype / Role row
        String leftRole = " " + ConsoleTheme.DIM + truncatePlain(AsciiArtAssets.getCharacterRole(left.getName()), 35) + ConsoleTheme.RESET;
        String rightRole = " " + ConsoleTheme.DIM + truncatePlain(AsciiArtAssets.getCharacterRole(right.getName()), 36) + ConsoleTheme.RESET;
        printSplitRow(leftRole, rightRole, ConsoleTheme.CYAN);
        System.out.println(splitBorder);

        // 8-line side-by-side ASCII portraits
        String[] leftPortrait = AsciiArtAssets.getCharacterPortrait(left.getName());
        String[] rightPortrait = AsciiArtAssets.getCharacterPortrait(right.getName());
        for (int i = 0; i < 8; i++) {
            String lArt = (leftPortrait != null && i < leftPortrait.length) ? leftPortrait[i] : "";
            String rArt = (rightPortrait != null && i < rightPortrait.length) ? rightPortrait[i] : "";
            String lCell = ConsoleTheme.centerVisible(leftColor + lArt + ConsoleTheme.RESET, COL_WIDTH);
            String rCell = ConsoleTheme.centerVisible(rightColor + rArt + ConsoleTheme.RESET, RIGHT_COL_WIDTH);
            printSplitRow(lCell, rCell, ConsoleTheme.CYAN);
        }

        System.out.println(splitBorder);

        // HP Bars
        String leftHp = " " + ConsoleTheme.BOLD + "HP: " + ConsoleTheme.RESET
                + ConsoleTheme.buildHpBar(left.getHitpoints(), left.getMaxHitpoints(), 14);
        String rightHp = " " + ConsoleTheme.BOLD + "HP: " + ConsoleTheme.RESET
                + ConsoleTheme.buildHpBar(right.getHitpoints(), right.getMaxHitpoints(), 14);
        printSplitRow(leftHp, rightHp, ConsoleTheme.CYAN);

        // MP Bars
        String leftMp = " " + ConsoleTheme.BOLD + "MP: " + ConsoleTheme.RESET
                + ConsoleTheme.buildMpBar(left.getMana(), left.getMaxMana(), 14);
        String rightMp = " " + ConsoleTheme.BOLD + "MP: " + ConsoleTheme.RESET
                + ConsoleTheme.buildMpBar(right.getMana(), right.getMaxMana(), 14);
        printSplitRow(leftMp, rightMp, ConsoleTheme.CYAN);

        // Cooldown Badges
        String leftCd = " " + ConsoleTheme.BOLD + "CD: " + ConsoleTheme.RESET + buildCompactCooldownSummary(left);
        String rightCd = " " + ConsoleTheme.BOLD + "CD: " + ConsoleTheme.RESET + buildCompactCooldownSummary(right);
        printSplitRow(leftCd, rightCd, ConsoleTheme.CYAN);

        System.out.println(topBorder);
    }

    private static String buildCompactCooldownSummary(GameCharacter c) {
        String s1 = ConsoleTheme.formatSkillStatusBadge(c.getSkillOneCooldown(), c.isSkillOneUsable());
        String s2 = ConsoleTheme.formatSkillStatusBadge(c.getSkillTwoCooldown(), c.isSkillTwoUsable());
        String s3 = ConsoleTheme.formatSkillStatusBadge(c.getSkillThreeCooldown(), c.isSkillThreeUsable());
        return "S1:" + s1 + " S2:" + s2 + " S3:" + s3;
    }

    private static String buildWinPips(int wins, int targetWins) {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < targetWins; i++) {
            sb.append(i < wins ? "* " : ". ");
        }
        sb.append("]");
        return sb.toString();
    }

    // ==================== 5. 2x2 Tactical Skill Deck Grid ====================

    public static void renderSkillDeckGrid(GameCharacter character) {
        if (character == null) {
            return;
        }

        String charColor = ConsoleTheme.getCharacterColor(character.getName());
        String border = ConsoleTheme.BRIGHT_PURPLE + "+-------------------------------------+--------------------------------------+" + ConsoleTheme.RESET;
        String topBorder = ConsoleTheme.BRIGHT_PURPLE + "+============================================================================+" + ConsoleTheme.RESET;

        System.out.println();
        System.out.println(topBorder);
        String title = ConsoleTheme.BOLD + charColor + character.getName().toUpperCase() + ConsoleTheme.RESET
                + ConsoleTheme.BOLD + ConsoleTheme.WHITE + " :: TACTICAL SKILL DECK" + ConsoleTheme.RESET
                + ConsoleTheme.GRAY + "  (HP: " + character.getHitpoints() + "/" + character.getMaxHitpoints()
                + " | MP: " + character.getMana() + "/" + character.getMaxMana() + ")" + ConsoleTheme.RESET;
        printBoxRow(ConsoleTheme.centerVisible(title, BOX_INNER_WIDTH), ConsoleTheme.BRIGHT_PURPLE);
        System.out.println(border);

        // Top Row: [0] Basic Attack  |  [1] Skill One
        renderSkillPairRow(character, 0, 1);
        System.out.println(border);

        // Bottom Row: [2] Skill Two  |  [3] * Skill Three (ULT)
        renderSkillPairRow(character, 2, 3);
        System.out.println(topBorder);
    }

    private static void renderSkillPairRow(GameCharacter c, int leftIdx, int rightIdx) {
        String[] leftLines = buildSkillCardLines(c, leftIdx, COL_WIDTH);
        String[] rightLines = buildSkillCardLines(c, rightIdx, RIGHT_COL_WIDTH);

        for (int i = 0; i < 3; i++) {
            printSplitRow(leftLines[i], rightLines[i], ConsoleTheme.BRIGHT_PURPLE);
        }
    }

    private static String[] buildSkillCardLines(GameCharacter c, int skillIdx, int width) {
        String name;
        int cd;
        int mpCost;
        boolean enoughMana;
        String keyColor;

        switch (skillIdx) {
            case 0 -> {
                name = "Basic Attack";
                cd = 0;
                mpCost = 0;
                enoughMana = true;
                keyColor = ConsoleTheme.WHITE;
            }
            case 1 -> {
                name = c.getSkillOneName();
                cd = c.getSkillOneCooldown();
                mpCost = c.getSkillOneManaUsage();
                enoughMana = c.isSkillOneUsable();
                keyColor = ConsoleTheme.BRIGHT_CYAN;
            }
            case 2 -> {
                name = c.getSkillTwoName();
                cd = c.getSkillTwoCooldown();
                mpCost = c.getSkillTwoManaUsage();
                enoughMana = c.isSkillTwoUsable();
                keyColor = ConsoleTheme.BRIGHT_YELLOW;
            }
            default -> {
                name = "* " + c.getSkillThreeName() + " (ULT)";
                cd = c.getSkillThreeCooldown();
                mpCost = c.getSkillThreeManaUsage();
                enoughMana = c.isSkillThreeUsable();
                keyColor = ConsoleTheme.BRIGHT_PURPLE;
            }
        }

        String prefix = "[" + skillIdx + "] ";
        int maxNameLen = width - 2 - prefix.length();
        String displayTitle = " " + keyColor + ConsoleTheme.BOLD + prefix + truncatePlain(name, maxNameLen) + ConsoleTheme.RESET;

        String dmgLine = "   " + ConsoleTheme.RED + "DMG: " + ConsoleTheme.WHITE + c.getDamageRange(skillIdx) + ConsoleTheme.RESET;

        String mpText = mpCost <= 0 ? "FREE" : mpCost + " MP";
        String badge = ConsoleTheme.formatSkillStatusBadge(cd, enoughMana);
        String costStatusLine = "   " + ConsoleTheme.CYAN + "COST: " + ConsoleTheme.WHITE + ConsoleTheme.padRightVisible(mpText, 7)
                + ConsoleTheme.RESET + " " + badge;

        return new String[]{
                ConsoleTheme.padRightVisible(displayTitle, width),
                ConsoleTheme.padRightVisible(dmgLine, width),
                ConsoleTheme.padRightVisible(costStatusLine, width)
        };
    }

    // ==================== 6. Arcade Tower Map ====================

    public static void renderArcadeTower(int currentStage, int totalWins, List<Enemy> remainingEnemies, Enemy currentOpponent) {
        String topBorder = ConsoleTheme.BRIGHT_YELLOW + "+============================================================================+" + ConsoleTheme.RESET;
        String midBorder = ConsoleTheme.YELLOW + "+----------------------------------------------------------------------------+" + ConsoleTheme.RESET;

        System.out.println();
        System.out.println(topBorder);
        printBoxRow(ConsoleTheme.centerVisible(
                ConsoleTheme.BOLD + ConsoleTheme.BRIGHT_YELLOW + ">>>  ARCADE GAUNTLET TOWER  --  WINS: " + totalWins + " / 5  <<<" + ConsoleTheme.RESET,
                BOX_INNER_WIDTH), ConsoleTheme.BRIGHT_YELLOW);
        System.out.println(midBorder);

        // Render from Stage 6 (Top of Tower) down to Stage 1
        String bossStatus;
        if (currentStage == 6) {
            bossStatus = ConsoleTheme.BRIGHT_RED + ConsoleTheme.BOLD + "[>> FIGHTING <<]" + ConsoleTheme.RESET;
        } else if (totalWins >= 5) {
            bossStatus = ConsoleTheme.BRIGHT_YELLOW + ConsoleTheme.BOLD + "[!! AWAKENED !!]" + ConsoleTheme.RESET;
        } else {
            bossStatus = ConsoleTheme.GRAY + "[ ] SEALED RIFT " + ConsoleTheme.RESET;
        }
        String stage6Line = "  " + ConsoleTheme.BRIGHT_PURPLE + ConsoleTheme.BOLD + "[STAGE 6: TIME RIFT BOSS]" + ConsoleTheme.RESET
                + "  Ohma Zi-O (Demon King of Time)   " + bossStatus;
        printBoxRow(stage6Line, ConsoleTheme.BRIGHT_YELLOW);
        printBoxRow(ConsoleTheme.GRAY + "             ||                     ||                     ||" + ConsoleTheme.RESET, ConsoleTheme.BRIGHT_YELLOW);

        for (int stage = 5; stage >= 1; stage--) {
            String statusBadge;
            String stageOpponentDesc;

            if (stage < currentStage || (stage <= totalWins)) {
                statusBadge = ConsoleTheme.BRIGHT_GREEN + ConsoleTheme.BOLD + "[X] CLEARED     " + ConsoleTheme.RESET;
                stageOpponentDesc = ConsoleTheme.GRAY + "Altered Ego Defeated" + ConsoleTheme.RESET;
            } else if (stage == currentStage) {
                statusBadge = ConsoleTheme.BRIGHT_YELLOW + ConsoleTheme.BOLD + "[>> FIGHTING <<]" + ConsoleTheme.RESET;
                String oppName = currentOpponent != null ? currentOpponent.getName() : "Challenger";
                String oppColor = ConsoleTheme.getCharacterColor(oppName);
                stageOpponentDesc = oppColor + ConsoleTheme.BOLD + oppName + ConsoleTheme.RESET
                        + ConsoleTheme.GRAY + " (" + truncatePlain(AsciiArtAssets.getCharacterRole(oppName), 18) + ")" + ConsoleTheme.RESET;
            } else {
                statusBadge = ConsoleTheme.GRAY + "[ ] LOCKED      " + ConsoleTheme.RESET;
                int remainingCount = remainingEnemies != null ? remainingEnemies.size() : (6 - currentStage);
                stageOpponentDesc = ConsoleTheme.GRAY + "Mystery Altered Ego (" + remainingCount + " remaining in pool)" + ConsoleTheme.RESET;
            }

            String row = "  " + ConsoleTheme.BRIGHT_CYAN + "[STAGE " + stage + "]" + ConsoleTheme.RESET
                    + "  " + ConsoleTheme.padRightVisible(stageOpponentDesc, 44)
                    + " " + statusBadge;
            printBoxRow(row, ConsoleTheme.BRIGHT_YELLOW);
        }

        System.out.println(topBorder);
    }

    // ==================== 7. Match Result Screen ====================

    public static void renderMatchResultScreen(GameCharacter f1, GameCharacter f2, int f1Wins, int f2Wins, boolean playerWonMatch) {
        System.out.println();
        if (playerWonMatch) {
            System.out.println(AsciiArtAssets.getVictoryTrophyArt());
        } else {
            System.out.println(AsciiArtAssets.getDefeatSkullArt());
        }

        String borderColor = playerWonMatch ? ConsoleTheme.BRIGHT_GREEN : ConsoleTheme.BRIGHT_RED;
        String topBorder = borderColor + "+============================================================================+" + ConsoleTheme.RESET;
        String midBorder = borderColor + "+----------------------------------------------------------------------------+" + ConsoleTheme.RESET;

        System.out.println(topBorder);
        String banner = playerWonMatch
                ? ConsoleTheme.BRIGHT_GREEN + ConsoleTheme.BOLD + ">>>  VICTORY! MATCH COMPLETE  <<<" + ConsoleTheme.RESET
                : ConsoleTheme.BRIGHT_RED + ConsoleTheme.BOLD + ">>>  DEFEAT! MATCH COMPLETE  <<<" + ConsoleTheme.RESET;
        printBoxRow(ConsoleTheme.centerVisible(banner, BOX_INNER_WIDTH), borderColor);
        System.out.println(midBorder);

        if (f1 != null && f2 != null) {
            String f1Color = ConsoleTheme.getCharacterColor(f1.getName());
            String f2Color = ConsoleTheme.getCharacterColor(f2.getName());

            String scoreRow1 = "   " + ConsoleTheme.padRightVisible(f1Color + ConsoleTheme.BOLD + f1.getName() + ConsoleTheme.RESET, 28)
                    + "Rounds Won: " + ConsoleTheme.BRIGHT_YELLOW + ConsoleTheme.BOLD + f1Wins + ConsoleTheme.RESET
                    + "   " + buildWinPips(f1Wins, Math.max(2, Math.max(f1Wins, f2Wins)));
            String scoreRow2 = "   " + ConsoleTheme.padRightVisible(f2Color + ConsoleTheme.BOLD + f2.getName() + ConsoleTheme.RESET, 28)
                    + "Rounds Won: " + ConsoleTheme.BRIGHT_YELLOW + ConsoleTheme.BOLD + f2Wins + ConsoleTheme.RESET
                    + "   " + buildWinPips(f2Wins, Math.max(2, Math.max(f1Wins, f2Wins)));

            printBoxRow(scoreRow1, borderColor);
            printBoxRow(scoreRow2, borderColor);
            System.out.println(midBorder);

            String championLine;
            if (f1Wins > f2Wins) {
                championLine = ConsoleTheme.BRIGHT_YELLOW + ConsoleTheme.BOLD + "* GRAND WINNER: " + f1.getName().toUpperCase() + " *" + ConsoleTheme.RESET;
            } else if (f2Wins > f1Wins) {
                championLine = ConsoleTheme.BRIGHT_YELLOW + ConsoleTheme.BOLD + "* GRAND WINNER: " + f2.getName().toUpperCase() + " *" + ConsoleTheme.RESET;
            } else {
                championLine = ConsoleTheme.BRIGHT_CYAN + ConsoleTheme.BOLD + "* MATCH RESULT: DRAW! *" + ConsoleTheme.RESET;
            }
            printBoxRow(ConsoleTheme.centerVisible(championLine, BOX_INNER_WIDTH), borderColor);
        }

        System.out.println(topBorder);
    }

    // ==================== Internal Box Helpers ====================

    private static void printBoxRow(String content) {
        printBoxRow(content, ConsoleTheme.BRIGHT_PURPLE);
    }

    private static void printBoxRow(String content, String borderColor) {
        String padded = ConsoleTheme.padRightVisible(content, BOX_INNER_WIDTH);
        System.out.println(borderColor + "|" + ConsoleTheme.RESET + padded + borderColor + "|" + ConsoleTheme.RESET);
    }

    private static void printSplitRow(String leftCell, String rightCell, String borderColor) {
        String lPadded = ConsoleTheme.padRightVisible(leftCell, COL_WIDTH);
        String rPadded = ConsoleTheme.padRightVisible(rightCell, RIGHT_COL_WIDTH);
        System.out.println(borderColor + "|" + ConsoleTheme.RESET
                + lPadded
                + borderColor + "|" + ConsoleTheme.RESET
                + rPadded
                + borderColor + "|" + ConsoleTheme.RESET);
    }

    private static String truncatePlain(String text, int maxLen) {
        if (text == null) {
            return "";
        }
        String plain = ConsoleTheme.stripAnsi(text);
        if (plain.length() <= maxLen) {
            return plain;
        }
        if (maxLen <= 3) {
            return plain.substring(0, Math.max(0, maxLen));
        }
        return plain.substring(0, maxLen - 2) + "..";
    }

    private static String centerCropPlain(String text, int width) {
        if (text == null) {
            return " ".repeat(width);
        }
        String plain = ConsoleTheme.stripAnsi(text);
        if (plain.length() <= width) {
            int padLeft = (width - plain.length()) / 2;
            int padRight = width - plain.length() - padLeft;
            return " ".repeat(padLeft) + plain + " ".repeat(padRight);
        }
        int start = (plain.length() - width) / 2;
        return plain.substring(start, start + width);
    }

    private static String shortFighterName(String fullName) {
        if (fullName == null) {
            return "";
        }
        return switch (fullName) {
            case "Cosmic Dassel" -> "Dassel";
            case "Khylle The Reaper" -> "Khylle";
            case "The One John" -> "John";
            case "Kaniel Outis" -> "Kaniel";
            case "Van Berksville", "Van Berskville" -> "Van";
            case "Asta Clover" -> "Asta";
            default -> fullName;
        };
    }
}
