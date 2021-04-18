package com.nhom6;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.Polygon;

public class MyLine {

	// so chi cac diem
	private int indexP1;
	private int indexP2;
	private Line2D.Double line;
	private Color color[] = { Color.white, Color.blue };
	private int type = 0;
	// so chi cua line
	private int indexLine = 0;
	// ban kinh cua hinh tron point
	private final double radius = 15;

	public MyLine(Point p1, Point p2, int indexP1, int indexP2) {
		line = new Line2D.Double(p1, p2);
		this.indexP1 = indexP1;
		this.indexP2 = indexP2;
	}

	// ve line khi chi co 1 line qua 2 diem
	public void drawLineMiddle(Graphics2D g) {
		g.setColor(Color.black);
		// dieu chinh do rong cua line
		g.setStroke(new BasicStroke(2));
		g.draw(line);
		if (indexLine > 0) {
			// ve so chi cua line
			String str = "(" + indexLine + ")";
			g.drawString(str, (int) (Math.abs(line.x1 + line.x2) / 2), (int) (line.y1 + line.y2) / 2);
		}

	}

	// ve line khi co 2 line qua 2 diem (2 chieu)
	public void drawLineLeft(Graphics2D g) {
		g.setColor(Color.black);
		// dieu chinh do rong cua line
		g.setStroke(new BasicStroke(2));
		// range la do dai duong noi 2 point
		double range = Math.sqrt(Math.pow((line.x2 - line.x1), 2) + Math.pow((line.y2 - line.y1), 2));
		// tao hai diem va line1 ben trai cua line
		Point p1 = new Point((int) (line.x1 + (line.y1 - line.y2) * radius / range), (int) (line.y1 + (line.x2 - line.x1) * radius / range));
		Point p2 = new Point((int) (line.x2 + (line.y1 - line.y2) * radius / range), (int) (line.y2 + (line.x2 - line.x1) * radius / range));
		Line2D.Double line1 = new Line2D.Double(p1, p2);
		g.draw(line1);
		if (indexLine > 0) {
			String str = "(" + indexLine + ")";
			g.drawString(str, (int) (Math.abs(line.x1 + line.x2) / 2), (int) (line.y1 + line.y2) / 2);
		}
	}

	// ve mui ten cho truong hop chi co 1 line giua 2 diem
	public void drawArrowMiddle(Graphics2D g) {
		g.setColor(Color.black);
		// range la do dai duong noi 2 point
		double range = Math.sqrt(Math.pow((line.x2 - line.x1), 2) + Math.pow((line.y2 - line.y1), 2));
		// line1 la duong noi 2 diem thuoc 2 hinh tron point va gan nhau nhat
		Line2D.Double line1 = new Line2D.Double(line.x1 + radius * (line.x2 - line.x1) / range, line.y1 + radius * (line.y2 - line.y1) / range, line.x2 - radius * (line.x2 - line.x1) / range, line.y2 - radius * (line.y2 - line.y1) / range);
		double range1 = Math.sqrt(Math.pow((line1.x2 - line1.x1), 2) + Math.pow((line1.y2 - line1.y1), 2));
		// 2 mang x,y la mang chua toa do 3 diem cua tam giac mui ten
		int[] xPoint1 = { (int) line1.x2, (int) (line1.x2 + 10 * (line1.x1 - line1.x2) / range1 + 4 * (line1.y2 - line.y1) / range1), (int) (line1.x2 + 10 * (line1.x1 - line1.x2) / range1 - 4 * (line1.y2 - line1.y1) / range1) };
		int[] yPoint1 = { (int) line1.y2, (int) (line1.y2 + 10 * (line1.y1 - line1.y2) / range1 + 4 * (line1.x1 - line.x2) / range1), (int) (line1.y2 + 10 * (line1.y1 - line1.y2) / range1 - 4 * (line1.x1 - line1.x2) / range1) };
		// ve mui ten
		Polygon p = new Polygon(xPoint1, yPoint1, 3);
		g.fillPolygon(p);
		g.drawPolygon(xPoint1, yPoint1, 3);
	}

	// ve mui ten cho truong hop có 2 line giua 2 diem
	public void drawArrowLeft(Graphics2D g) {
		g.setColor(Color.black);
		// range la do dai duong noi 2 point
		double range = Math.sqrt(Math.pow((line.x2 - line.x1), 2) + Math.pow((line.y2 - line.y1), 2));
		Point p1 = new Point((int) (line.x1 + (line.y1 - line.y2) * radius / range), (int) (line.y1 + (line.x2 - line.x1) * radius / range));
		Point p2 = new Point((int) (line.x2 + (line.y1 - line.y2) * radius / range), (int) (line.y2 + (line.x2 - line.x1) * radius / range));
		Line2D.Double line1 = new Line2D.Double(p1, p2);
		// 2 mang x,y la mang chua toa do 3 diem cua tam giac mui ten
		int[] xPoint2 = { (int) line1.x2, (int) (line1.x2 + 10 * (line1.x1 - line1.x2) / range + 5 * (line1.y2 - line1.y1) / range), (int) (line1.x2 + 10 * (line1.x1 - line1.x2) / range - 5 * (line1.y2 - line1.y1) / range) };
		int[] yPoint2 = { (int) line1.y2, (int) (line1.y2 + 10 * (line1.y1 - line1.y2) / range + 5 * (line1.x1 - line1.x2) / range), (int) (line1.y2 + 10 * (line1.y1 - line1.y2) / range - 5 * (line1.x1 - line1.x2) / range) };
		// ve mui ten
		Polygon p = new Polygon(xPoint2, yPoint2, 3);
		g.fillPolygon(p);
		g.drawPolygon(xPoint2, yPoint2, 3);
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
