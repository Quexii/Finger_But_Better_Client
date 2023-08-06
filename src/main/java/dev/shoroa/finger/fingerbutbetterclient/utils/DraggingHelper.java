package dev.shoroa.finger.fingerbutbetterclient.utils;

import java.util.function.Consumer;

public class DraggingHelper {
    private boolean dragging;
    private int dragX = 0, dragY = 0;

    public void handlePress(int mx, int my, int dragX, int dragY) {
        this.dragX = dragX-mx;
        this.dragY = dragY-my;
    }

    public void setPosition(int mx, int my, Consumer<Integer> setX, Consumer<Integer> setY) {
        setX.accept(mx+dragX);
        setY.accept(my+dragY);
    }
}
