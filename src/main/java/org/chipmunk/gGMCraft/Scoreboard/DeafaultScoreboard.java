package org.chipmunk.gGMCraft.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.jetbrains.annotations.NotNull;

public class DeafaultScoreboard {
    public void GetScoreBoard(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
    }

    public void ResetScoreBoard(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

    }

    public static void SetDefaultScoreboard() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        Objective objective = CreateOnNotExist(scoreboard, "GGM타운");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
    }

    private static @NotNull Objective CreateOnNotExist(Scoreboard scoreboard, String string) {
        Objective objective = scoreboard.getObjective(string);
        if (objective == null) {
            objective = scoreboard.registerNewObjective(string, Criteria.AIR, "3", RenderType.HEARTS);

        }
        return objective;
    }
}
