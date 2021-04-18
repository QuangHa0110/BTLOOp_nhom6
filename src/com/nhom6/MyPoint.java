package com.nhom6;

import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Color;

public class MyPoint extends Canvas {
	
	private int indexPoint;
	private double x;
	private double y;

	public MyPoint(double x, double y, int indexPoint) {
		this.indexPoint = indexPoint;
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics2D g) {
		g.drawOval((int) x, (int) y, 40, 40);
		g.drawString(Integer.toString(indexPoint), (int) x + 17, (int) y + 15);
		setForeground(Color.ORANGE);
	}
}
