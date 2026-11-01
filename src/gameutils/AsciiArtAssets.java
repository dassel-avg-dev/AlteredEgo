package gameutils;

/**
 * Provides pure 7-bit ASCII art banners, character portraits, role titles,
 * and stylized combat impact animations combined with ANSI colors.
 */
public class AsciiArtAssets {

    private AsciiArtAssets() {
        // Utility class
    }

    public static String getGameTitleBanner() {
        return ConsoleTheme.BRIGHT_PURPLE + ConsoleTheme.BOLD
                + "  +========================================================================+\n"
                + "  |   _____  _    _____ _____ ____  _____ ____     _____ ____  ___         |\n"
                + "  |  |  _  || |  |_   _| ____|  _ \\| ____|  _ \\   | ____/ ___|/ _ \\        |\n"
                + "  |  | |_| || |    | | |  _| | |_) |  _| | | | |  |  _|| |  _| | | |       |\n"
                + "  |  |  _  || |___ | | | |___|  _ <| |___| |_| |  | |__| |_| | |_| |       |\n"
                + "  |  |_| |_||_____||_| |_____|_| \\_\\_____|____/   |_____\\____|\\___/        |\n"
                + "  |                                                                        |\n"
                + ConsoleTheme.BRIGHT_CYAN
                + "  |             >>> BY: SHELL SYNDICATE SOFTWARE CO. LTD <<<               |\n"
                + ConsoleTheme.BRIGHT_PURPLE
                + "  +========================================================================+"
                + ConsoleTheme.RESET;
    }

    public static String getCursedConsoleArt() {
        return ConsoleTheme.BRIGHT_CYAN
                + "          +--------------------------------------------------+\n"
                + "          |  +--------------------------------------------+  |\n"
                + "          |  |  " + ConsoleTheme.BRIGHT_RED + ">> CURSED CONSOLE DETECTED:            " + ConsoleTheme.BRIGHT_CYAN + "   |  |\n"
                + "          |  |  " + ConsoleTheme.BRIGHT_PURPLE + "   ABSORBING PLAYER INTO ALTERED EGO <<" + ConsoleTheme.BRIGHT_CYAN + "   |  |\n"
                + "          |  |        .---.          *       .---.        |  |\n"
                + "          |  |       /     \\   >>> === <<<  /     \\       |  |\n"
                + "          |  |       \\     /       *        \\     /       |  |\n"
                + "          |  |        '---'                  '---'        |  |\n"
                + "          |  +--------------------------------------------+  |\n"
                + "          |   [PWR: ON]   (o) (o)       [CH: 00]  [VOL:MAX]  |\n"
                + "          +-----------------------+--+-----------------------+\n"
                + "                                  |  |\n"
                + "                        +---------+--+---------+\n"
                + "                        |  [+]    ____   (A)(B)|\n"
                + "                        |        [____]        |\n"
                + "                        +----------------------+"
                + ConsoleTheme.RESET;
    }

    public static String getEndCreditsBanner() {
        return ConsoleTheme.BRIGHT_PURPLE + ConsoleTheme.BOLD
                + "  +========================================================================+\n"
                + "  |               _____ _   _ _____   _____ _   _ ____                     |\n"
                + "  |              |_   _| | | | ____| | ____| \\ | |  _ \\                    |\n"
                + "  |                | | | |_| |  _|   |  _| |  \\| | | | |                   |\n"
                + "  |                | | |  _  | |___  | |___| |\\  | |_| |                   |\n"
                + "  |                |_| |_| |_|_____| |_____|_| \\_|____/                    |\n"
                + "  +========================================================================+\n"
                + ConsoleTheme.BRIGHT_CYAN
                + "  |                   SHELL SYNDICATE SOFTWARE CO. LTD                     |\n"
                + "  |  +------------------------------------------------------------------+  |\n"
                + "  |  |  DEVELOPMENT TEAM CREDITS:                                       |  |\n"
                + "  |  |    * Dassel Bacaltos                                             |  |\n"
                + "  |  |    * Daven Khylle Famat                                          |  |\n"
                + "  |  |    * Francis Earl Brigoli                                        |  |\n"
                + "  |  |    * Alieyandrew Juhanes Idala                                   |  |\n"
                + "  |  |    * John Fiel Amancio                                           |  |\n"
                + "  |  +------------------------------------------------------------------+  |\n"
                + ConsoleTheme.BRIGHT_PURPLE
                + "  +========================================================================+"
                + ConsoleTheme.RESET;
    }

    public static String getFinalBossBanner() {
        return ConsoleTheme.BRIGHT_PURPLE + ConsoleTheme.BOLD
                + "  +========================================================================+\n"
                + ConsoleTheme.BRIGHT_YELLOW
                + "  |    ___  _   _ __  __    _      _____ ___       ___                     |\n"
                + "  |   / _ \\| | | |  \\/  |  / \\    |__  /|_ _|     / _ \\                    |\n"
                + "  |  | | | | |_| | |\\/| | / _ \\     / /  | |_____| | | |                   |\n"
                + "  |  | |_| |  _  | |  | |/ ___ \\   / /_ _| |_____| |_| |                   |\n"
                + "  |   \\___/|_| |_|_|  |_/_/   \\_\\ /____|___|      \\___/                    |\n"
                + ConsoleTheme.BRIGHT_PURPLE
                + "  |                                                                        |\n"
                + ConsoleTheme.BRIGHT_YELLOW
                + "  |            >>> OHMA ZI-O : DEMON KING OF TIME <<<                      |\n"
                + ConsoleTheme.BRIGHT_PURPLE
                + "  +========================================================================+"
                + ConsoleTheme.RESET;
    }

    public static String getVictoryTrophyArt() {
        return ConsoleTheme.BRIGHT_YELLOW + ConsoleTheme.BOLD
                + "             +========================================+\n"
                + "             |         [ VICTORY / CHAMPION ]         |\n"
                + "             +========================================+\n"
                + "             |               ___________              |\n"
                + "             |              '._==_==_=_.'             |\n"
                + "             |              .-\\:      /-.             |\n"
                + "             |             | (|:.     |) |            |\n"
                + "             |              '-|:.     |-'             |\n"
                + "             |                \\::.    /               |\n"
                + "             |                 '::. .'                |\n"
                + "             |                   ) (                  |\n"
                + "             |                 _.' '._                |\n"
                + "             |                [_______]               |\n"
                + "             +========================================+"
                + ConsoleTheme.RESET;
    }

    public static String getDefeatSkullArt() {
        return ConsoleTheme.BRIGHT_RED + ConsoleTheme.BOLD
                + "             +========================================+\n"
                + "             |        [ DEFEATED / GAME OVER ]        |\n"
                + "             +========================================+\n"
                + "             |                 .-----.                |\n"
                + "             |               .'       '.              |\n"
                + "             |              /  X     X  \\             |\n"
                + "             |             |      ^      |            |\n"
                + "             |              \\   '---'   /             |\n"
                + "             |               '._______.'              |\n"
                + "             |              _ / | | | \\ _             |\n"
                + "             |             (_/  '-+-'  \\_)            |\n"
                + "             +========================================+"
                + ConsoleTheme.RESET;
    }

    public static String getCharacterRole(String name) {
        if (name == null) {
            return "Unknown Fighter";
        }
        return switch (name) {
            case "Cosmic Dassel" -> "Tech Tactician";
            case "Khylle The Reaper" -> "Soul Harvester";
            case "Earl" -> "Agile Striker";
            case "The One John" -> "Heavy Juggernaut";
            case "And Rew" -> "Dragon Caster";
            case "OP Character" -> "Root Admin [OP]";
            case "Kaniel Outis" -> "Mind Corruptor";
            case "Van Berksville", "Van Berskville" -> "Vengeful Berserker";
            case "Asta Clover" -> "Anti-Magic Knight";
            case "JF Void" -> "Void Singularity";
            case "Deidre" -> "Storm Ronin";
            case "Ohma Zi-O" -> "Demon King of Time";
            default -> "Arena Combatant";
        };
    }

    public static String[] getCharacterPortrait(String name) {
        if (name == null) {
            name = "";
        }
        return switch (name) {
            case "Cosmic Dassel" -> new String[]{
                    "    .------.        ",
                    "   / [0=0]  \\       ",
                    "   |  \\__/  |  [$]  ",
                    "  /|  |$$|  |\\ /    ",
                    " / |  |__|  | '     ",
                    "   |  |  |  |       ",
                    "   |  |  |  |       ",
                    "  [__]    [__]      "
            };
            case "Khylle The Reaper" -> new String[]{
                    "    .------.   _    ",
                    "   / /x  x\\ \\ / \\   ",
                    "  | |  ..  | |   |  ",
                    "   \\ \\____/ /   /   ",
                    "   /|      |\\  /    ",
                    "  / |  ||  | \\/     ",
                    "    /  ||  \\ /      ",
                    "   /__/  \\__\\       "
            };
            case "Earl" -> new String[]{
                    "    .======.~~      ",
                    "   |  o  o  |       ",
                    "    \\  --  /        ",
                    "  .--|    |--.      ",
                    " /   |====|   \\     ",
                    "     /   /          ",
                    "    /   /===>>      ",
                    "   [___]            "
            };
            case "The One John" -> new String[]{
                    "     .----.         ",
                    "    / -  - \\        ",
                    "    |  __  |        ",
                    "  ~\\________/~ (_)  ",
                    "   /|      |\\  /    ",
                    "  / |======| \\/     ",
                    "    |  ||  |        ",
                    "   [___][___]       "
            };
            case "And Rew" -> new String[]{
                    "   /\\ .--. /\\       ",
                    "   \\/|o  o|\\/       ",
                    "  ~(  \\__/  )~      ",
                    "  ~( /|><|\\ )~      ",
                    "    / |==| \\        ",
                    "      |  |          ",
                    "     /    \\         ",
                    "    [__] [__]       "
            };
            case "OP Character" -> new String[]{
                    "  +----------+      ",
                    "  |  [X_X]   |      ",
                    "  +----+-----+      ",
                    "   ___/||\\___       ",
                    "  |  [ROOT]  |      ",
                    "  |  |====|  |      ",
                    "     | || |         ",
                    "    [__][__]        "
            };
            case "Kaniel Outis" -> new String[]{
                    "     \\V//V/         ",
                    "    .------.        ",
                    "   /  <O>   \\       ",
                    "   \\  ____  /       ",
                    "   /| /  \\ |\\       ",
                    "  / |/ /\\ \\| \\      ",
                    "    | /  \\ |        ",
                    "   /________\\       "
            };
            case "Van Berksville", "Van Berskville" -> new String[]{
                    "    .------.  /|    ",
                    "   / #    x \\| |    ",
                    "   \\  ____  /| |    ",
                    "   /|      | | |    ",
                    "  / |======| | |    ",
                    "    |  ||  | [+]    ",
                    "    |  ||  |  |     ",
                    "   [___][___]       "
            };
            case "Asta Clover" -> new String[]{
                    "   |\\ .--. /|       ",
                    "   | |o  o| |       ",
                    "    \\ \\__/ /        ",
                    "  /| /|XX|\\ |\\      ",
                    "  ||/ |==| \\||      ",
                    "  +   |  |   +      ",
                    "     /    \\         ",
                    "    [__] [__]       "
            };
            case "JF Void" -> new String[]{
                    "  *  .----.  .      ",
                    " .  /      \\   *    ",
                    "   | ( O )  |       ",
                    " *  \\      / .      ",
                    "   /|\\____/|\\       ",
                    "  / |  ..  | \\      ",
                    "    |  ..  |        ",
                    "   [___][___]       "
            };
            case "Deidre" -> new String[]{
                    "    _======_    /   ",
                    "   /  -  -  \\  /    ",
                    "   \\   __   / /     ",
                    "    /|    |\\ /      ",
                    "   / |====| X       ",
                    "     | || |/ \\      ",
                    "    /  ||  \\        ",
                    "   [___][___]       "
            };
            case "Ohma Zi-O" -> new String[]{
                    "   \\ \\ | / /        ",
                    "  ==| [XII] |==     ",
                    "    \\  ___  /       ",
                    "  /\\/| | | |\\/\\     ",
                    " /  ||=+=+||  \\     ",
                    "    || | | ||       ",
                    "    || | | ||       ",
                    "   [___] [___]      "
            };
            default -> new String[]{
                    "    .------.        ",
                    "   /  o  o  \\       ",
                    "   |  \\__/  |       ",
                    "   /|      |\\       ",
                    "  / |======| \\      ",
                    "    |  ||  |        ",
                    "    |  ||  |        ",
                    "   [___][___]       "
            };
        };
    }

    public static void printAttackAnimation(
            GameCharacter attacker,
            GameCharacter defender,
            int skillIndex,
            String skillName,
            int damage,
            int delay
    ) {
        String attackerName = attacker != null && attacker.getName() != null ? attacker.getName() : "Attacker";
        String defenderName = defender != null && defender.getName() != null ? defender.getName() : "Defender";
        String safeSkillName = (skillName != null && !skillName.isEmpty()) ? skillName : "Attack";
        String atkColor = ConsoleTheme.getCharacterColor(attackerName);
        String defColor = ConsoleTheme.getCharacterColor(defenderName);

        System.out.println();
        if (skillIndex <= 0) {
            String boxTop = ConsoleTheme.GRAY + "  +--------------------------------------------------------------------+" + ConsoleTheme.RESET;
            String strikeLine = "  |  " + atkColor + ConsoleTheme.BOLD + "[" + attackerName + "]" + ConsoleTheme.RESET
                    + ConsoleTheme.BRIGHT_YELLOW + " ===>>> *IMPACT!* >>>=== " + ConsoleTheme.RESET
                    + defColor + ConsoleTheme.BOLD + "[" + defenderName + "]" + ConsoleTheme.RESET
                    + ConsoleTheme.BRIGHT_RED + " (-" + damage + " HP!)" + ConsoleTheme.RESET;
            System.out.println(boxTop);
            ConsoleOutput.printWithDelay(strikeLine, Math.max(1, delay / 3));
            System.out.println(boxTop);
        } else if (skillIndex == 1 || skillIndex == 2) {
            String effectArt = buildSpecialEffectLine(attackerName, skillIndex);
            String border = atkColor + "  +--------------------------------------------------------------------+" + ConsoleTheme.RESET;
            System.out.println(border);
            System.out.println("  |  " + atkColor + ConsoleTheme.BOLD + ">> SPECIAL SKILL: " + safeSkillName.toUpperCase() + " <<" + ConsoleTheme.RESET);
            ConsoleOutput.printWithDelay("  |  " + atkColor + effectArt + ConsoleTheme.RESET, Math.max(1, delay / 3));
            System.out.println("  |  " + atkColor + "[" + attackerName + "]" + ConsoleTheme.RESET
                    + " ===> " + defColor + "[" + defenderName + "]" + ConsoleTheme.RESET
                    + "  " + ConsoleTheme.BRIGHT_RED + ConsoleTheme.BOLD + "[-" + damage + " HP!]" + ConsoleTheme.RESET);
            System.out.println(border);
        } else {
            String border = atkColor + ConsoleTheme.BOLD
                    + "  +====================================================================+" + ConsoleTheme.RESET;
            String innerRule = atkColor
                    + "  |--------------------------------------------------------------------|" + ConsoleTheme.RESET;
            System.out.println(border);
            System.out.println("  |          " + ConsoleTheme.BRIGHT_YELLOW + ConsoleTheme.BOLD
                    + "* * *  ULTIMATE SKILL UNLEASHED  * * *" + ConsoleTheme.RESET + "                    |");
            System.out.println(innerRule);
            ConsoleOutput.printWithDelay("  |  " + atkColor + ConsoleTheme.BOLD
                    + ">>> " + attackerName.toUpperCase() + " : [ " + safeSkillName.toUpperCase() + " ] <<<"
                    + ConsoleTheme.RESET, Math.max(1, delay / 3));
            System.out.println("  |  " + ConsoleTheme.BRIGHT_PURPLE
                    + "#####==================================================>>>>> *BOOM*" + ConsoleTheme.RESET);
            System.out.println("  |  " + ConsoleTheme.WHITE + "TARGET: " + defColor + ConsoleTheme.BOLD + defenderName
                    + ConsoleTheme.RESET + "   >>>   " + ConsoleTheme.BRIGHT_RED + ConsoleTheme.BOLD
                    + "[-" + damage + " HP! CRITICAL IMPACT!]" + ConsoleTheme.RESET);
            System.out.println(border);
        }
    }

    private static String buildSpecialEffectLine(String attackerName, int skillIndex) {
        return switch (attackerName) {
            case "Cosmic Dassel" -> skillIndex == 1
                    ? "[0101] ===> (PUNCH!) ===> [$]"
                    : "[BUG_ERR] ~~~~> [0xFFFF] ~~~~> *CRASH*";
            case "Khylle The Reaper" -> skillIndex == 1
                    ? "===[KICK]===> )) SOUL STRIKE (("
                    : "<o> [FOOD] ~~~> (@) ~~~> *CHOMP*";
            case "Earl" -> skillIndex == 1
                    ? "===>> [KNEE STRIKE] >>=== *CRACK*"
                    : "==>> [KICK 1] ==>> [KICK 2] *FLASH*";
            case "The One John" -> skillIndex == 1
                    ? "/// [UPPERCUT] /// ===> *POW*"
                    : "(( [COUNTERPALM] )) ===> *SHOCKWAVE*";
            case "And Rew" -> skillIndex == 1
                    ? "~(DRAGON FIST)~ ===> >>> *FIRE* <<< *ROAR*"
                    : ">>> [MISSILE] >>> [MISSILE] ===> *BLAST*";
            case "OP Character" -> skillIndex == 1
                    ? "[root@ego]# kill -9 ===> *ONE TAP*"
                    : "[SYSTEM WIPE] |||||||||| ===> *DELETED*";
            case "Kaniel Outis" -> skillIndex == 1
                    ? "<O> ~~~ [IMAGE BURN] ~~~> *SCORCH*"
                    : "((( [SPIRIT COMPRESSION] ))) ===> *CRUSH*";
            case "Van Berksville", "Van Berskville" -> skillIndex == 1
                    ? "---===[======> *HEART STAB*"
                    : "))) GETSUGA SLASH ))) ===> *CLEAVE*";
            case "Asta Clover" -> skillIndex == 1
                    ? "// [ANTI-MAGIC SLASH] // ===> *SEVER*"
                    : "XX [DOUBLE SLASH] XX ===> *CROSS CUT*";
            case "JF Void" -> skillIndex == 1
                    ? "( O ) ===> [VOID CHOP] ===> *RUPTURE*"
                    : "<( O )> ~~~ [VOID DEFLECT] ~~~> *WARP*";
            case "Deidre" -> skillIndex == 1
                    ? "///*** [LIGHTNING CUT] ***/// ===> *ZAP*"
                    : "===/// [THUNDER CLEAVE] ///===> *STORM*";
            case "Ohma Zi-O" -> skillIndex == 1
                    ? "[XII] ~~~> [TEMPORAL STRIKE] ~~~> *TIME HALT*"
                    : "<< [RIFT CRUSH] >> ===> *DIMENSION SHATTER*";
            default -> "===>>> [SPECIAL STRIKE] >>>=== *HIT*";
        };
    }
}
