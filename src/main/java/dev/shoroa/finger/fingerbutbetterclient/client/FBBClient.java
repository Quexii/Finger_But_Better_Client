package dev.shoroa.finger.fingerbutbetterclient.client;

import dev.shoroa.finger.fingerbutbetterclient.client.event.Event;
import dev.shoroa.finger.fingerbutbetterclient.client.event.impl.EventRender2D;
import dev.shoroa.finger.fingerbutbetterclient.client.event.impl.EventTick;
import dev.shoroa.finger.fingerbutbetterclient.client.event.impl.EventUpdate;
import dev.shoroa.finger.fingerbutbetterclient.client.module.Module;
import dev.shoroa.finger.fingerbutbetterclient.client.module.ModuleManager;
import dev.shoroa.finger.fingerbutbetterclient.client.module.ui.HudModule;
import dev.shoroa.finger.fingerbutbetterclient.client.module.ui.impl.DummyModule;
import dev.shoroa.finger.fingerbutbetterclient.client.ui.mods.EditModsScreen;
import io.github.nevalackin.homoBus.Listener;
import io.github.nevalackin.homoBus.annotations.EventLink;
import io.github.nevalackin.homoBus.bus.impl.EventBus;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FBBClient implements ClientModInitializer {
    public static FBBClient INSTANCE;
    private KeyMapping KEY_MODMENU = new KeyMapping("fcbb.modmenu", GLFW.GLFW_KEY_RIGHT_SHIFT, "fcbb.category");
    public static final EventBus<Event> BUS = new EventBus<>();
    public static final Logger LOG = LoggerFactory.getLogger("FINGER");
    private final Minecraft mc = Minecraft.getInstance();
    private ModuleManager modManager = new ModuleManager();
    @Override
    public void onInitializeClient() {
        INSTANCE = this;
        KeyBindingHelper.registerKeyBinding(KEY_MODMENU);
        BUS.subscribe(this);
        HudRenderCallback.EVENT.register((context,delta)->BUS.post(new EventRender2D(context,delta)));
        ClientTickEvents.START_CLIENT_TICK.register((mc)->BUS.post(new EventTick()));

        modManager.register(DummyModule.class, new DummyModule());
    }
    @EventLink
    private final Listener<EventUpdate> eUpdate = e -> {
        if(KEY_MODMENU.consumeClick()) {
            mc.setScreen(new EditModsScreen());
        }
    };
    @EventLink
    private final Listener<EventRender2D> e2D = e -> {
        for (Module m : modManager.modules()) {
            if(m instanceof HudModule hm) {
                if(mc.screen instanceof EditModsScreen) {
                    hm.dummy(e.ui, e.delta);
                } else
                    hm.render(e.ui,e.delta);
            }
        }
    };

    public ModuleManager modManager() {
        return modManager;
    }
}
