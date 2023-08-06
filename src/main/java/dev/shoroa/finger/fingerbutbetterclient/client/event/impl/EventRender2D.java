package dev.shoroa.finger.fingerbutbetterclient.client.event.impl;

import dev.shoroa.finger.fingerbutbetterclient.client.event.Event;
import net.minecraft.client.gui.GuiGraphics;

public class EventRender2D extends Event {
    public final GuiGraphics ui;
    public final float delta;

    public EventRender2D(GuiGraphics ui, float delta) {
        this.ui = ui;
        this.delta = delta;
    }
}
