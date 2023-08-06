package dev.shoroa.finger.fingerbutbetterclient.mixin.client.gui;

import com.mojang.authlib.minecraft.client.MinecraftClient;
import com.mojang.brigadier.Message;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(TitleScreen.class)
public abstract class MixinMainMenu {
    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screens/Screen;render(Lnet/minecraft/client/gui/GuiGraphics;IIF)V", shift = At.Shift.BEFORE))
    public void inject$render(GuiGraphics ui, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        Minecraft mc = Minecraft.getInstance();

        ui.fill(4,4,134,40,Integer.MIN_VALUE);
        ui.drawString(mc.font, "Finger Client But Better!", 8, 8, -1);
        ui.drawString(mc.font, "By Shoroa made with <3", 8, 18, -1);
        ui.drawString(mc.font, "v0.1", 8, 28, -1);
    }
}
