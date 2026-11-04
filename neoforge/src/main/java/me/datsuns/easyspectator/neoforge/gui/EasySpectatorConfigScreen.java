package me.datsuns.easyspectator.neoforge.gui;

import me.datsuns.easyspectator.EasySpectatorCommon;
import me.datsuns.easyspectator.EasySpectatorConfig;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.CycleButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;

public class EasySpectatorConfigScreen extends Screen {
    private final Screen lastScreen;
    private boolean tempEnabled;
    private boolean tempIgnoreSpawnPoint;

    public EasySpectatorConfigScreen(Screen lastScreen) {
        super(Component.translatable("gui.mc_easy_spectator.config.title"));
        this.lastScreen = lastScreen;
        this.tempEnabled = EasySpectatorCommon.isEnabled();
        this.tempIgnoreSpawnPoint = EasySpectatorCommon.isIgnoreSpawnPoint();
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int startY = this.height / 4;

        CycleButton<Boolean> enabledButton = CycleButton.onOffBuilder(this.tempEnabled)
                .create(centerX - 120, startY, 240, 20, Component.translatable("gui.mc_easy_spectator.config.enabled"), (button, value) -> {
                    this.tempEnabled = value;
                });
        this.addRenderableWidget(enabledButton);

        CycleButton<Boolean> ignoreSpawnButton = CycleButton.onOffBuilder(this.tempIgnoreSpawnPoint)
                .create(centerX - 120, startY + 30, 240, 20, Component.translatable("gui.mc_easy_spectator.config.ignore_spawn_point"), (button, value) -> {
                    this.tempIgnoreSpawnPoint = value;
                });
        this.addRenderableWidget(ignoreSpawnButton);

        this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, button -> {
            EasySpectatorCommon.setEnabled(this.tempEnabled);
            EasySpectatorCommon.setIgnoreSpawnPoint(this.tempIgnoreSpawnPoint);
            EasySpectatorConfig.save();
            if (this.minecraft != null && this.minecraft.gui != null) {
                this.minecraft.gui.setScreen(this.lastScreen);
            }
        }).bounds(centerX - 105, startY + 80, 100, 20).build());

        this.addRenderableWidget(Button.builder(CommonComponents.GUI_CANCEL, button -> {
            if (this.minecraft != null && this.minecraft.gui != null) {
                this.minecraft.gui.setScreen(this.lastScreen);
            }
        }).bounds(centerX + 5, startY + 80, 100, 20).build());
    }

    @Override
    public void onClose() {
        if (this.minecraft != null && this.minecraft.gui != null) {
            this.minecraft.gui.setScreen(this.lastScreen);
        }
    }
}
