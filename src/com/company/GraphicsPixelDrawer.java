package com.company;

import java.awt.*;

public class GraphicsPixelDrawer implements PixelDrawer{
    private Graphics g;

    public GraphicsPixelDrawer(Graphics g) {
        this.g = g;
    }

    @Override
    public void colorPixel(int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x, y, 1, 1);
    }

    @Override
    public void colorPixel(int x, int y) {

    }
}