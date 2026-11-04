package me.datsuns.easyspectator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class EasySpectatorCommonTest {

    @BeforeEach
    void setUp() {
        EasySpectatorCommon.setEnabled(true);
        EasySpectatorCommon.setIgnoreSpawnPoint(true);
    }

    @AfterEach
    void tearDown() {
        EasySpectatorCommon.setEnabled(true);
        EasySpectatorCommon.setIgnoreSpawnPoint(true);
    }

    @Test
    void testDefaultValues() {
        assertTrue(EasySpectatorCommon.isEnabled());
        assertTrue(EasySpectatorCommon.isIgnoreSpawnPoint());
    }

    @Test
    void testStateChange() {
        EasySpectatorCommon.setEnabled(false);
        assertFalse(EasySpectatorCommon.isEnabled());

        EasySpectatorCommon.setIgnoreSpawnPoint(false);
        assertFalse(EasySpectatorCommon.isIgnoreSpawnPoint());
    }

    @Test
    void testConfigSaveAndLoad(@TempDir Path tempDir) {
        EasySpectatorConfig.init(tempDir);

        EasySpectatorCommon.setEnabled(false);
        EasySpectatorCommon.setIgnoreSpawnPoint(false);
        EasySpectatorConfig.save();

        // Reset in-memory values
        EasySpectatorCommon.setEnabled(true);
        EasySpectatorCommon.setIgnoreSpawnPoint(true);

        // Load from saved file
        EasySpectatorConfig.load();
        assertFalse(EasySpectatorCommon.isEnabled());
        assertFalse(EasySpectatorCommon.isIgnoreSpawnPoint());
    }
}
