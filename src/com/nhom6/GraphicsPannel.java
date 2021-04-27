package com.nhom6;

import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class GraphicsPannel {
	
	DataInput dataInput = new DataInput();
	//So luong diem
	private int numberPoint = dataInput.getMaxDinh();
	//Day cac diem va duong
	private ArrayList<MyPoint> listPoint = new ArrayList<MyPoint>();
	private ArrayList<MyLine> listLine = new ArrayList<MyLine>();
	private ArrayList<Point> lp = new ArrayList<Point>();
	
	public int getNumberPoint() {
		return numberPoint;
	}

	public void setNumberPoint(int numberPoint) {
		this.numberPoint = numberPoint;
	}

	public ArrayList<MyPoint> getListPoint() {
		return listPoint;
	}

	public void setListPoint(ArrayList<MyPoint> listPoint) {
		this.listPoint = listPoint;
	}

	public ArrayList<MyLine> getListLine() {
		return listLine;
	}

	public void setListLine(ArrayList<MyLine> listLine) {
		this.listLine = listLine;
	}

	//Phuong thuc tao do thi voi toa do cac diem
	public void createGraph(Graphics g) {	
		MyPoint mp1 = new MyPoint(400, 400, 1);
		listPoint.add(mp1);
		double deg = 360/(numberPoint*1.0);
		double rad = Math.toRadians(deg);
		for (int i = 1; i < numberPoint; i++) {
			//Tao toa do diem nam tren 1 duong tron
			double x = 600 - Math.cos(rad*i)*200;
			double y = 400 - Math.sin(rad*i)*200;
			MyPoint mp = new MyPoint(x, y, i+1);
			listPoint.add(mp);
			Point p = new Point((int) x, (int) y);
			lp.add(p);
		}
		
		for (int i = 0; i < numberPoint; i++) {
			listPoint.get(i).draw(g);
		}
	}
	
	//Phuong thuc ve do thi voi cac diem duoc tao
	public void drawGraph(Graphics2D g) {
		//Add cac diem vao day listLine
		for (int i = 1; i < dataInput.getDanhSachDinh().size(); i++) {
			for (Integer j: dataInput.getDanhSachDinh().get(i)) {
				MyLine ml = new MyLine(lp.get(i), lp.get(j), i, j);
				listLine.add(ml);
			}
		}		
		int a[][] = new int[listLine.size()][listLine.size()];
		//Tao ma tran duong di cua do thi
		for (int i = 1; i < dataInput.getDanhSachDinh().size(); i++) {
			for (int j = 1; j < dataInput.getDanhSachDinh().size(); j++) {
				a[i][j] = 0;
			}
		}
		//Tao ma tran duong di cua do thi
		for (int i = 1; i < dataInput.getDanhSachDinh().size(); i++) {
			for (Integer j: dataInput.getDanhSachDinh().get(i)) {
				a[i][j] = 1;
			}			
		}
		//Ve duong di
		for (int i = 1; i < dataInput.getDanhSachDinh().size(); i++) {
			for (int j = i; j < dataInput.getDanhSachDinh().size(); j++) {
				if (a[i][j] == 1) {
					listLine.get(i).drawLineMiddle(g);
					listLine.get(i).drawArrowMiddle(g);
				}
				if (a[j][i] == 1) {
					listLine.get(i).drawLineLeft(g);
					listLine.get(i).drawArrowLeft(g);
				}
			}
		}
	}
	
	public void addLineDFS(Graphics2D g) {
		 DFS dfs = new DFS(numberPoint);
		 dfs.KhoiTao();
		 g.setColor(Color.RED);
		 for (int i = 1; i < dataInput.getDanhSachDinh().size(); i++) {
			 dfs.TRYDFS(dataInput.getDanhSachDinh().get(i).size());
		 }
	}
	
	public void addLineBFS(Graphics2D g) {
		g.setColor(Color.RED);
		BFS bfs = new BFS();
		for (int i = 1; i <= numberPoint; i++) {
			bfs.BFS(i);
		}
		
	}
	
}
