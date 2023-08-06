package dev.shoroa.finger.fingerbutbetterclient.client.ui.widgets;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import dev.shoroa.finger.fingerbutbetterclient.utils.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;

public abstract class Window {
    private int x, y, width, height;
    private String title;
    private ItemStack icon;

    public Window(int x, int y, int width, int height, String title, ItemStack icon) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.title = title;
        this.icon = icon;
    }

    public abstract void render(GuiGraphics ui, int mx, int my, float delta);
    public abstract void click(int mx, int my, int button);
    
    public final void fill(GuiGraphics ui) {
        RenderUtil.verticalGradient(x()+1, y()+1, width()-2, height()-2, 0xff50c7d9,0xff50d9a9);
        RenderUtil.fill(x(), y()+2, 1, height()-4, 0xff328c7f);
        RenderUtil.fill(x()+width()-1, y()+2, 1, height()-4, 0xff328c7f);
        RenderUtil.fill(x()+2, y(), width()-4, 1, 0xff328c7f);
        RenderUtil.fill(x()+2, y()+height()-1, width()-4, 1, 0xff328c7f);
        RenderUtil.fill(x()+1, y()+1, 1, 1, 0xff328c7f);
        RenderUtil.fill(x()+width()-2, y()+1, 1, 1, 0xff328c7f);
        RenderUtil.fill(x()+1, y()+height()-2, 1, 1, 0xff328c7f);
        RenderUtil.fill(x()+width()-2, y()+height()-2, 1, 1, 0xff328c7f);

        RenderUtil.fill(x()+3,y()+18,width()-6,height()-21,0x20000000);
        ui.drawString(Minecraft.getInstance().font, title(), x()+18, y()+5, -1);
        ui.pose().scale(.8f,.8f,.8f);
        ui.renderItem(icon(),x()+7, y()+6);
        ui.pose().scale(1.8f,1.8f,1.8f);
    }

    public int x() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int y() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int width() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int height() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String title() {
        return title;
    }

    public ItemStack icon() {
        return icon;
    }
}
