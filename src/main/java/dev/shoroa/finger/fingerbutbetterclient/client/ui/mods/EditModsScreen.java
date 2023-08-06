package dev.shoroa.finger.fingerbutbetterclient.client.ui.mods;

import dev.shoroa.finger.fingerbutbetterclient.client.FBBClient;
import dev.shoroa.finger.fingerbutbetterclient.client.module.Module;
import dev.shoroa.finger.fingerbutbetterclient.client.module.ui.HudModule;
import dev.shoroa.finger.fingerbutbetterclient.client.ui.widgets.WButton;
import dev.shoroa.finger.fingerbutbetterclient.utils.DraggingHelper;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class EditModsScreen extends Screen {
    private DraggingHelper drag = new DraggingHelper();
    private HudModule currentMod = null;
    public EditModsScreen() {
        super(Component.empty());
    }

    @Override
    protected void init() {
        addRenderableWidget(WButton.builder(Component.literal("Mod Menu"), (button) -> minecraft.setScreen(new ModMenuScreen()))
                .size(100, 16)
                .pos(width/2-50, height/2-8)
                .build());
        super.init();
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mx, int my, float delta) {
        for (Module m : FBBClient.INSTANCE.modManager().modules().stream().filter(m -> m instanceof HudModule).toList()) {
            HudModule hm = (HudModule)m;
            if(hm.hovered(mx,my)) {
                guiGraphics.renderOutline(hm.x(),hm.y(),hm.width(),hm.height(),-1);
            }
        }
        if(currentMod != null) {
            drag.setPosition(mx,my,currentMod::setX, currentMod::setY);
        }
        super.render(guiGraphics, mx,my,delta);
    }

    @Override
    public boolean mouseClicked(double mx, double my, int button) {
        for (Module m : FBBClient.INSTANCE.modManager().modules().stream().filter(m -> m instanceof HudModule).toList()) {
            HudModule hm = (HudModule)m;
            if(hm.hovered((int) mx,(int) my) && button == 0) {
                System.out.println("dsa");
                currentMod = hm;
                drag.handlePress((int) mx, (int) my, currentMod.x(), currentMod.y());
            }
        }
        return super.mouseClicked(mx,my,button);
    }

    @Override
    public boolean mouseReleased(double d, double e, int i) {
        currentMod = null;
        return super.mouseReleased(d, e, i);
    }
}
