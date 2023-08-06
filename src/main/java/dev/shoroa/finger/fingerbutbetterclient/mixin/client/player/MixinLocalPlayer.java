package dev.shoroa.finger.fingerbutbetterclient.mixin.client.player;

import dev.shoroa.finger.fingerbutbetterclient.client.FBBClient;
import dev.shoroa.finger.fingerbutbetterclient.client.event.impl.EventUpdate;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public class MixinLocalPlayer {
    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/AbstractClientPlayer;tick()V", shift = At.Shift.BEFORE))
    public void inject$tick(CallbackInfo ci) {
        FBBClient.BUS.post(new EventUpdate());
    }
}
