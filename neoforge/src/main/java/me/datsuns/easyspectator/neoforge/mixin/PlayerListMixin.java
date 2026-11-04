package me.datsuns.easyspectator.neoforge.mixin;

import me.datsuns.easyspectator.EasySpectatorCommon;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import net.minecraft.world.level.GameType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerList.class)
public class PlayerListMixin {

    @Inject(method = "respawn", at = @At("HEAD"))
    private void onRespawnHead(ServerPlayer serverPlayer, boolean keepEverything, CallbackInfoReturnable<ServerPlayer> cir) {
        if (!keepEverything && EasySpectatorCommon.isEnabled() && EasySpectatorCommon.isIgnoreSpawnPoint()) {
            serverPlayer.setRespawnPosition(null, false);
        }
    }

    @Inject(method = "respawn", at = @At("RETURN"))
    private void onRespawnReturn(ServerPlayer serverPlayer, boolean keepEverything, CallbackInfoReturnable<ServerPlayer> cir) {
        if (!keepEverything && EasySpectatorCommon.isEnabled()) {
            ServerPlayer newPlayer = cir.getReturnValue();
            if (newPlayer != null) {
                newPlayer.setGameMode(GameType.SPECTATOR);
            }
        }
    }
}
