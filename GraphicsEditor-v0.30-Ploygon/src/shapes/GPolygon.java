package shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.Vector;

import constants.Constants.EDrawingType;

public class GPolygon extends GShape{
	private Polygon polygon;
	public GPolygon(){
		super(EDrawingType.NP);
		this.polygon = new Polygon();
		System.out.print("test");;
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.draw(this.polygon);
		
	}

	@Override
	public void initDrawing(int x, int y, Graphics2D g2D) {
		this.polygon.addPoint(x, y);
		this.polygon.addPoint(x, y);
		
	}

	@Override
	public void continueDrawing(int x, int y, Graphics2D g2D) {
		this.polygon.addPoint(x, y);
		
		
		
		//g2D.drawLine(this.x, this.y, this.w, this.h);
		
//		System.out.println(this.cnt+"  sw");
//		if(this.cnt>0){
//			g2D.drawLine(xPoints.get(this.cnt-1), yPoints.get(this.cnt-1),xPoints.get(this.cnt),yPoints.get(this.cnt));	
//		g2D.drawLine(xPoints.get(this.cnt-1), yPoints.get(this.cnt-1),xPoints.get(this.cnt),yPoints.get(this.cnt));
//		}
//		this.cnt++;
////		this.temp1 = w;
////		this.temp2 = h;
//		
		
	}

	@Override
	public void finishDrawing(int x, int y, Graphics g) {
	
	}

	@Override
	public void keepDrawing(int x, int y, Graphics2D g2D) {
		g2D.draw(this.polygon);
		this.polygon.xpoints[polygon.npoints-1] = x;
		this.polygon.ypoints[polygon.npoints-1] = y;
		g2D.draw(this.polygon);	
	}
	

}
