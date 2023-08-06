package dev.shoroa.finger.fingerbutbetterclient.client.ui.widgets;

import dev.shoroa.finger.fingerbutbetterclient.utils.RenderUtil;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractButton;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;

public class WButton extends AbstractButton {
    private OnPress onPress;
    private WButton(int i, int j, int k, int l, Component component, OnPress onPress) {
        super(i, j, k, l, component);
        this.onPress = onPress;
    }

    @Override
    public void onPress() {
        onPress.onPress(this);
    }
    public static Builder builder(Component component, OnPress onPress) {
        return new Builder(component, onPress);
    }

    @Override
    protected void renderWidget(GuiGraphics ui, int i, int j, float f) {
        Minecraft minecraft = Minecraft.getInstance();
        ui.setColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderUtil.verticalGradient(getX()+1, getY()+1, getWidth()-2, getHeight()-2, 0xff50c7d9,0xff50d9a9);
        if(isHovered()) {
            RenderUtil.fill(getX()+1, getY()+1, getWidth()-2, getHeight()-2,0x20000000);
        }
        RenderUtil.fill(getX(), getY()+2, 1, getHeight()-4, 0xff328c7f);
        RenderUtil.fill(getX()+getWidth()-1, getY()+2, 1, getHeight()-4, 0xff328c7f);
        RenderUtil.fill(getX()+2, getY(), getWidth()-4, 1, 0xff328c7f);
        RenderUtil.fill(getX()+2, getY()+getHeight()-1, getWidth()-4, 1, 0xff328c7f);
        RenderUtil.fill(getX()+1, getY()+1, 1, 1, 0xff328c7f);
        RenderUtil.fill(getX()+getWidth()-2, getY()+1, 1, 1, 0xff328c7f);
        RenderUtil.fill(getX()+1, getY()+getHeight()-2, 1, 1, 0xff328c7f);
        RenderUtil.fill(getX()+getWidth()-2, getY()+getHeight()-2, 1, 1, 0xff328c7f);
        ui.drawCenteredString(minecraft.font,getMessage(), getX()+getWidth()/2, getY()+getHeight()/2
                -4, -1);
    }

    @Override
    protected void updateWidgetNarration(NarrationElementOutput narrationElementOutput) {

    }

    public static class Builder {
        private final Component message;
        private final OnPress onPress;
        @Nullable
        private Tooltip tooltip;
        private int x;
        private int y;
        private int width = 150;
        private int height = 20;
        public Builder(Component component, OnPress onPress) {
            this.message = component;
            this.onPress = onPress;
        }
        public Builder pos(int i, int j) {
            this.x = i;
            this.y = j;
            return this;
        }

        public Builder width(int i) {
            this.width = i;
            return this;
        }

        public Builder size(int i, int j) {
            this.width = i;
            this.height = j;
            return this;
        }

        public Builder bounds(int i, int j, int k, int l) {
            return this.pos(i, j).size(k, l);
        }

        public Builder tooltip(@Nullable Tooltip tooltip) {
            this.tooltip = tooltip;
            return this;
        }

        public WButton build() {
            WButton button = new WButton(this.x, this.y, this.width, this.height, this.message, this.onPress);
            button.setTooltip(this.tooltip);
            return button;
        }
    }
    @Environment(EnvType.CLIENT)
    public interface OnPress {
        void onPress(WButton button);
    }
}
