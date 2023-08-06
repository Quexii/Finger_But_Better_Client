package dev.shoroa.finger.fingerbutbetterclient.client.module;

import dev.shoroa.finger.fingerbutbetterclient.client.FBBClient;
import net.minecraft.client.Minecraft;

public class Module {
    private String name,description;
    private boolean state;
    protected Minecraft mc = Minecraft.getInstance();

    public Module(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void onEnable() {FBBClient.BUS.subscribe(this);}
    public void onDisable() {FBBClient.BUS.unsubscribe(this);}

    public void toggle() {
        state(!state());
        if(state()) onEnable(); else onDisable();
    }

    public boolean state() {
        return state;
    }

    public void state(boolean state) {
        this.state = state;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }
}
