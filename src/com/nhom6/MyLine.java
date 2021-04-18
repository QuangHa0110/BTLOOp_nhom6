package com.nhom6;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.Polygon;

public class MyLine {

	private int indexP1;
	private int indexP2;
	private Line2D.Double line;
	private Color color[] = {Color.white, Color.blue};
	private int type=0;
	private int indexLine = 0;
	private final double radius = 15;
	public MyLine(Point p1, Point p2, int indexP1, int indexP2) {
		line = new Line2D.Double(p1, p2);
		this.indexP1 = indexP1;
		this.indexP2 = indexP2;
	}

	public void drawLineMiddle(Graphics2D g) {
		g.setColor(Color.black);
		g.setStroke(new BasicStroke(2));
		g.draw(line);
		if (indexLine > 0) {
			String str = "(" + indexLine + ")";
			g.drawString(str, (int) (Math.abs(line.x1 + line.x2) / 2), (int) (line.y1 + line.y2) / 2);
		}
		
	}

	public void drawLineLeft(Graphics2D g) {
		g.setColor(Color.black);
	    g.setStroke(new BasicStroke(2));
		double d = Math.sqrt(Math.pow((line.x2-line.x1), 2)+ Math.pow((line.y2-line.y1), 2));
		Point p1 = new Point((int)(line.x1+(line.y1-line.y2)*radius/d),(int)(line.y1+(line.x2-line.x1)*radius/d));
		Point p2 = new Point((int)(line.x2+(line.y1-line.y2)*radius/d),(int)(line.y2+(line.x2-line.x1)*radius/d));
		Line2D.Double line1 = new Line2D.Double(p1,p2);
		g.draw(line1);
		if (indexLine > 0) {
			String str = "(" + indexLine + ")";
			g.drawString(str, (int) (Math.abs(line.x1 + line.x2) / 2), (int) (line.y1 + line.y2) / 2);
		}
	}
	public void drawArrowMiddle(Graphics2D g) {
		g.setColor(Color.black);
		double range = Math.sqrt(Math.pow((line.x2-line.x1), 2)+ Math.pow((line.y2-line.y1), 2));
		Line2D.Double line1= new Line2D.Double(line.x1+radius*(line.x2-line.x1)/range, line.y1+radius*(line.y2-line.y1)/range, line.x2-radius*(line.x2-line.x1)/range, line.y2-radius*(line.y2-line.y1)/range);
		double range1 = Math.sqrt(Math.pow((line1.x2-line1.x1), 2)+ Math.pow((line1.y2-line1.y1), 2));
		int[] x = {(int)line1.x2, (int)(line1.x2+10*(line1.x1-line1.x2)/range1+4*(line1.y2-line.y1)/range1), (int)(line1.x2+10*(line1.x1-line1.x2)/range1-4*(line1.y2-line1.y1)/range1) };
		int[] y = {(int)line1.y2, (int)(line1.y2+10*(line1.y1-line1.y2)/range1+4*(line1.x1-line.x2)/range1), (int)(line1.y2+10*(line1.y1-line1.y2)/range1-4*(line1.x1-line1.x2)/range1) };
		Polygon p= new Polygon(x, y, 3);
		g.fillPolygon(p);
		g.drawPolygon(x, y, 3);
	}
	public void drawArrowLeft(Graphics2D g) {
		g.setColor(Color.black);
		
		double d = Math.sqrt(Math.pow((line.x2-line.x1), 2)+ Math.pow((line.y2-line.y1), 2));
		Point p1 = new Point((int)(line.x1+(line.y1-line.y2)*radius/d),(int)(line.y1+(line.x2-line.x1)*radius/d));
		Point p2 = new Point((int)(line.x2+(line.y1-line.y2)*radius/d),(int)(line.y2+(line.x2-line.x1)*radius/d));
		Line2D.Double line1 = new Line2D.Double(p1,p2);
		int[] x1 = {(int)line1.x2, (int)(line1.x2+10*(line1.x1-line1.x2)/d+5*(line1.y2-line1.y1)/d), (int)(line1.x2+10*(line1.x1-line1.x2)/d-5*(line1.y2-line1.y1)/d) };
		int[] y1 = {(int)line1.y2, (int)(line1.y2+10*(line1.y1-line1.y2)/d+5*(line1.x1-line1.x2)/d), (int)(line1.y2+10*(line1.y1-line1.y2)/d-5*(line1.x1-line1.x2)/d) };
		Polygon p= new Polygon(x1, y1, 3);
		g.fillPolygon(p);
		g.drawPolygon(x1, y1, 3);
	}

	public int getIndexP1() {
		return indexP1;
	}

	public void setIndexP1(int indexP1) {
		this.indexP1 = indexP1;
	}

	public int getIndexP2() {
		return indexP2;
	}

	public void setIndexP2(int indexP2) {
		this.indexP2 = indexP2;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getIndexLine() {
		return indexLine;
	}

	public void setIndexLine(int order) {
		this.indexLine = order;
	}
}
