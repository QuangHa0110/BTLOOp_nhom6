package com.nhom6;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class MyPoint extends Canvas {
	
	//Tao diem
	private Point2D.Double Point;
	//So chi diem
	private int indexPoint=0;
	public MyPoint(double x, double y, int indexPoint) {
		Point = new Point2D.Double(x,y);
		this.indexPoint=indexPoint;
	}
	public void draw(Graphics g) {
		//Ve diem mau sac diem so chi diem
		g.setColor(Color.BLACK);
		//((Graphics2D) g).draw((Shape) Point);
		g.drawOval((int)Point.getX(),(int)Point.getY(),20,20);
		if(indexPoint>0) {
			String s="";
			g.drawString(s+indexPoint,(int)Point.getX()+6,(int)(Point.getY()+15));
		}
	}
	public int getIndexPoint() {
		return indexPoint;
	}
	public void setIndexPoint(int indexPoint) {
		this.indexPoint = indexPoint;
	}
}
