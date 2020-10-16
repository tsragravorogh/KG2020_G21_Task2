package com.company;

import com.company.pixel_lines.BresenhamLineDrawer;
import com.company.pixel_lines.DDALineDrawer;
import com.company.pixel_lines.WuLineDrawer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel implements MouseMotionListener {
    private Point2D position = new Point(0, 0);

    public DrawPanel() {
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_3BYTE_BGR);
        Graphics gr = bi.createGraphics();
        gr.setColor(Color.WHITE);
        gr.fillRect(0,0,getWidth(), getHeight());
        gr.setColor(Color.BLACK);
        PixelDrawer pd = new GraphicsPixelDrawer(gr);
        LineDrawer ld = new DDALineDrawer(pd);
        BresenhamLineDrawer bld = new BresenhamLineDrawer(pd);
        WuLineDrawer wld = new WuLineDrawer(pd);
        drawAll(wld);
        g.drawImage(bi, 0, 0, null);
        gr.dispose();
    }
    private void drawAll(LineDrawer ld){
        drawSnowFlake(ld, 200, 300, 150, 28);
        ld.drawLine(getWidth() / 2, getHeight() / 2, (int) position.getX(), (int) position.getY());
    }

    public static void drawSnowFlake(LineDrawer ld, int x, int y, int r, int n) {
        double da = 2 * Math.PI / n;
        for (int i = 0; i < n ; i++ ) {
            double a = da * i;
            double dx = r * Math.cos(a);
            double dy = r * Math.sin(a);

            ld.drawLine(x, y, x + (int)dx, y + (int)dy);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        position = new Point(e.getX(), e.getY());
        repaint();
    }
}
