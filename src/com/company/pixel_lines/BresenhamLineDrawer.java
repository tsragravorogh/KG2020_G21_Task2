package com.company.pixel_lines;

import com.company.DrawPanel;
import com.company.LineDrawer;
import com.company.PixelDrawer;

import java.awt.*;

public class BresenhamLineDrawer implements LineDrawer {
    private PixelDrawer pd;

    public BresenhamLineDrawer(PixelDrawer pd) {
        this.pd = pd;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {

    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2, Color color) {

    }
}


