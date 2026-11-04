package me.datsuns.easyspectator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class EasySpectatorConfig {
    private static File configFile;

    public static void init(Path configDir) {
        configFile = configDir.resolve("mc_easy_spectator.properties").toFile();
        load();
    }

    public static void load() {
        if (configFile == null || !configFile.exists()) {
            save();
            return;
        }

        Properties props = new Properties();
        try (FileReader reader = new FileReader(configFile)) {
            props.load(reader);
            boolean enabled = Boolean.parseBoolean(props.getProperty("enabled", "true"));
            boolean ignoreSpawnPoint = Boolean.parseBoolean(props.getProperty("ignoreSpawnPoint", "true"));
            EasySpectatorCommon.setEnabled(enabled);
            EasySpectatorCommon.setIgnoreSpawnPoint(ignoreSpawnPoint);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        if (configFile == null) return;

        Properties props = new Properties();
        props.setProperty("enabled", String.valueOf(EasySpectatorCommon.isEnabled()));
        props.setProperty("ignoreSpawnPoint", String.valueOf(EasySpectatorCommon.isIgnoreSpawnPoint()));

        try {
            if (configFile.getParentFile() != null && !configFile.getParentFile().exists()) {
                configFile.getParentFile().mkdirs();
            }
            try (FileWriter writer = new FileWriter(configFile)) {
                props.store(writer, "Easy Spectator Mod Configuration");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
