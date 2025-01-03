package org.chipmunk.gGMCraft.DiscordBot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import java.io.File;

public class DiscordBot {
    JDA jda;

    public DiscordBot(String token) throws InterruptedException {
        JDABuilder builder = JDABuilder.createDefault(token);
        jda = builder.build();
        jda.awaitReady();
    }

    public void disable() {
        if (jda != null) {
            jda.shutdown();
        }
    }
}
