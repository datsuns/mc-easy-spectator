package me.datsuns.easyspectator.fabric;

import me.datsuns.easyspectator.EasySpectatorConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class EasySpectatorFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        EasySpectatorConfig.init(FabricLoader.getInstance().getConfigDir());
    }
}
