package dev.shoroa.finger.fingerbutbetterclient.utils;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.util.FastColor;
import org.joml.Matrix4f;

public class RenderUtil {
    public static void fill(int x, int y, int width, int height, int color) {
        float r1 = (float) FastColor.ARGB32.alpha(color) / 255.0F;
        float g1 = (float) FastColor.ARGB32.red(color) / 255.0F;
        float b1 = (float) FastColor.ARGB32.green(color) / 255.0F;
        float a1 = (float) FastColor.ARGB32.blue(color) / 255.0F;
        Tesselator t = Tesselator.getInstance();
        BufferBuilder bb = t.getBuilder();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        bb.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        bb.vertex(x, y, 0).color(g1, b1, a1, r1).endVertex();
        bb.vertex(x, y+height, 0).color(g1, b1, a1, r1).endVertex();
        bb.vertex(x+width, y+height, 0).color(g1, b1, a1, r1).endVertex();
        bb.vertex(x+width, (float)y, 0).color(g1, b1, a1, r1).endVertex();
        t.end();
        RenderSystem.disableBlend();
    }
    public static void horizontalGradient(VertexConsumer vertexConsumer, int x, int y, int width, int height, int color1, int color2) {
        float r1 = (float) FastColor.ARGB32.alpha(color1) / 255.0F;
        float g1 = (float) FastColor.ARGB32.red(color1) / 255.0F;
        float b1 = (float) FastColor.ARGB32.green(color1) / 255.0F;
        float a1 = (float) FastColor.ARGB32.blue(color1) / 255.0F;
        float r2 = (float) FastColor.ARGB32.alpha(color2) / 255.0F;
        float g2 = (float) FastColor.ARGB32.red(color2) / 255.0F;
        float b2 = (float) FastColor.ARGB32.green(color2) / 255.0F;
        float a2 = (float) FastColor.ARGB32.blue(color2) / 255.0F;
        Tesselator t = Tesselator.getInstance();
        BufferBuilder bb = t.getBuilder();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        bb.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        bb.vertex(x, y, 0).color(g1, b1, a1, r1).endVertex();
        bb.vertex(x, y+height, 0).color(g2, b2, a2, r2).endVertex();
        bb.vertex(x+width, y+height, 0).color(g2, b2, a2, r2).endVertex();
        bb.vertex(x+width, (float)y, 0).color(g1, b1, a1, r1).endVertex();
        t.end();
        RenderSystem.disableBlend();
    }
    public static void verticalGradient(int x, int y, int width, int height, int color1, int color2) {
        float r1 = (float) FastColor.ARGB32.alpha(color1) / 255.0F;
        float g1 = (float) FastColor.ARGB32.red(color1) / 255.0F;
        float b1 = (float) FastColor.ARGB32.green(color1) / 255.0F;
        float a1 = (float) FastColor.ARGB32.blue(color1) / 255.0F;
        float r2 = (float) FastColor.ARGB32.alpha(color2) / 255.0F;
        float g2 = (float) FastColor.ARGB32.red(color2) / 255.0F;
        float b2 = (float) FastColor.ARGB32.green(color2) / 255.0F;
        float a2 = (float) FastColor.ARGB32.blue(color2) / 255.0F;
        Tesselator t = Tesselator.getInstance();
        BufferBuilder bb = t.getBuilder();
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        bb.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        bb.vertex(x, y, 0).color(g1, b1, a1, r1).endVertex();
        bb.vertex(x, y+height, 0).color(g1, b1, a1, r1).endVertex();
        bb.vertex(x+width, y+height, 0).color(g2, b2, a2, r2).endVertex();
        bb.vertex(x+width, (float)y, 0).color(g2, b2, a2, r2).endVertex();
        t.end();
        RenderSystem.disableBlend();
    }
}
