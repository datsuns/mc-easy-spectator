package me.datsuns.easyspectator.neoforge;

import me.datsuns.easyspectator.EasySpectatorCommon;
import me.datsuns.easyspectator.EasySpectatorConfig;
import me.datsuns.easyspectator.neoforge.gui.EasySpectatorConfigScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(EasySpectatorCommon.MOD_ID)
public class EasySpectatorNeoForge {

    public EasySpectatorNeoForge(IEventBus modEventBus, ModContainer modContainer) {
        EasySpectatorConfig.init(FMLPaths.CONFIGDIR.get());

        if (FMLEnvironment.getDist() == Dist.CLIENT) {
            modContainer.registerExtensionPoint(IConfigScreenFactory.class, (container, screen) -> new EasySpectatorConfigScreen(screen));
        }
    }
}
