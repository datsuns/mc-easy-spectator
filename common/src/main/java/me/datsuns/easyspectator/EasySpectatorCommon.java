package me.datsuns.easyspectator;

public class EasySpectatorCommon {
    public static final String MOD_ID = "mc_easy_spectator";
    public static final String MOD_NAME = "Easy Spectator";

    private static boolean enabled = true;
    private static boolean ignoreSpawnPoint = true;

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean value) {
        enabled = value;
    }

    public static boolean isIgnoreSpawnPoint() {
        return ignoreSpawnPoint;
    }

    public static void setIgnoreSpawnPoint(boolean value) {
        ignoreSpawnPoint = value;
    }
}
