package dev.shoroa.finger.fingerbutbetterclient.client.ui.mods;

import dev.shoroa.finger.fingerbutbetterclient.client.ui.mods.menu.widgets.MenuWindow;
import dev.shoroa.finger.fingerbutbetterclient.client.ui.widgets.Window;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModMenuScreen extends Screen {
    private MenuWindow mainWindow;
    protected ModMenuScreen() {
        super(Component.empty());
    }

    @Override
    protected void init() {
        int menuWidth = 400;
        int menuHeight = 220;

        mainWindow = new MenuWindow(width/2-menuWidth/2, height/2-menuHeight/2,menuWidth,menuHeight,"Finger Client Mod Menu", new ItemStack(Items.COMMAND_BLOCK));
        super.init();
    }

    @Override
    public void render(GuiGraphics guiGraphics, int i, int j, float f) {
        mainWindow.render(guiGraphics,i,j,f);
        super.render(guiGraphics, i, j, f);
    }

    @Override
    public boolean mouseClicked(double d, double e, int i) {
        mainWindow.click((int)d,(int)e,i);
        return super.mouseClicked(d, e, i);
    }
}
