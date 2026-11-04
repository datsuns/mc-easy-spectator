package me.datsuns.easyspectator.fabric;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.datsuns.easyspectator.fabric.gui.EasySpectatorConfigScreen;

public class EasySpectatorModMenu implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return EasySpectatorConfigScreen::new;
    }
}
