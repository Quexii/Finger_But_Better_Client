package dev.shoroa.finger.fingerbutbetterclient.client.ui.mods.menu.widgets;

import dev.shoroa.finger.fingerbutbetterclient.client.ui.widgets.Window;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;

public class MenuWindow extends Window {
    public MenuWindow(int x, int y, int width, int height, String title, ItemStack icon) {
        super(x, y, width, height, title, icon);
    }

    @Override
    public void render(GuiGraphics ui, int mx, int my, float delta) {
        fill(ui);
    }

    @Override
    public void click(int mx, int my, int button) {

    }
}
