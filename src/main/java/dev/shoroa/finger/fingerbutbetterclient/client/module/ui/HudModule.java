package dev.shoroa.finger.fingerbutbetterclient.client.module.ui;

import dev.shoroa.finger.fingerbutbetterclient.client.event.impl.EventRender2D;
import dev.shoroa.finger.fingerbutbetterclient.client.module.Module;
import io.github.nevalackin.homoBus.Listener;
import io.github.nevalackin.homoBus.annotations.EventLink;
import net.minecraft.client.gui.GuiGraphics;

public abstract class HudModule extends Module {
    private int x=0,y=0,width=0,height=0;
    public HudModule(String name, String description) {
        super(name, description);
    }

    public abstract void render(GuiGraphics ui, float delta);
    public abstract void dummy(GuiGraphics ui, float delta);

    public boolean hovered(int mx, int my) {
        return mx >= x() && my >= y() && mx < x()+width() && my < y()+height();
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
}
