package dev.shoroa.finger.fingerbutbetterclient.client.module.ui.impl;

import dev.shoroa.finger.fingerbutbetterclient.client.module.ui.HudModule;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class DummyModule extends HudModule {
    public DummyModule() {
        super("Dummy", "Hello I am a dummy!");
        setX(10);
        setY(10);
    }
    @Override
    public void render(GuiGraphics ui, float delta) {
        ui.fill(x(), y(), x()+width(), y()+height(), Integer.MIN_VALUE);
        ui.renderFakeItem(new ItemStack(Items.LIME_WOOL), x()+3, y()+2);
        ui.drawString(mc.font, "Render!", x()+26, y()+height()/2-4, -1);
    }

    @Override
    public void dummy(GuiGraphics ui, float delta) {
        ui.fill(x(), y(), x()+width(), y()+height(), Integer.MIN_VALUE);
        ui.renderFakeItem(new ItemStack(Items.RED_WOOL), x()+3, y()+2);
        ui.drawString(mc.font, "Dummy!", x()+26, y()+height()/2-4, -1);
    }

    @Override
    public int width() {
        return 80;
    }

    @Override
    public int height() {
        return 20;
    }
}
