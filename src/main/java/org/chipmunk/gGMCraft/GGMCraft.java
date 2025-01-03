package org.chipmunk.gGMCraft;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.chipmunk.gGMCraft.DiscordBot.DiscordBot;
import org.chipmunk.gGMCraft.Scoreboard.DeafaultScoreboard;

import java.io.*;

public final class GGMCraft extends JavaPlugin {
    public static TextComponent severName = Component.text("G", TextColor.color(237, 24, 70))
            .append(Component.text("G", TextColor.color(0, 166, 81)))
            .append(Component.text("M", TextColor.color(0xFFDE00)));
    public static String dataPath = "plugins/GGMCraft";

    public DiscordBot discordBot;

    @Override
    public void onEnable() {
        // Plugin startup logic

        getLogger().info("GGMCraft : Enable");
        EventManager.registerEvent(getServer().getPluginManager(), this);
        //기본 스코어보드 설정
        DeafaultScoreboard.SetDefaultScoreboard();

        //Create Folder
        String[] splitedPath = dataPath.split("/");
        File folder = new File(splitedPath[0], splitedPath[1]);
        folder.mkdir();
        
        InitManager();
    }

    private void InitManager() {
        PLayerManager.Initailize();
    }

    public static void Debug(String text) {
        getPlugin(GGMCraft.class).getLogger().info(text);
    }

    private void enableDiscordBot() {
        String path = "/DiscordBotToken";
        String token = getTokenFromFile(path);

        getLogger().info(token);
        getLogger().info(path);

        try {
            discordBot = new DiscordBot(token);
        } catch (InterruptedException e) {
            getLogger().info("GGMCraft : 디스코드 봇 실행에 실패하셨습니다");
        }
    }

    private void disableDiscordBot() {
        if (discordBot != null) {
            discordBot.disable();
        }
    }


    private String getTokenFromFile(String filePath) {
        StringBuilder token = new StringBuilder();
        try (InputStream inputStream = getClass().getResourceAsStream(filePath);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                token.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return token.toString();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("GGMCraft : Disable");
    }
}
