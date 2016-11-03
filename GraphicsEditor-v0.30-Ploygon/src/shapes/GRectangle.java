package shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;

import constants.Constants.EDrawingType;

public class GRectangle extends GShape {
	private int x, y, w, h;
	public GRectangle() {
		super(EDrawingType.TP);
		this.x = 0;
		this.y = 0;
		this.w = 0;
		this.h = 0;
	}
	@Override
	public void initDrawing(int x, int y, Graphics2D g2D) {
		this.x = x;
		this.y = y;		
		this.w = 0;
		this.h = 0;
	}
	@Override
	public void keepDrawing(int x, int y, Graphics2D g2D) {
//		if(x<this.x){
//			
//			System.out.println("test");
//			//g2D.drawRect(x, this.y, this.w, this.h);
//			System.out.println("  q  "+x+"  -  "+this.y+"  -  "+this.w+"  -  "+this.h);
//			this.w = this.x-x;
//			this.h = y - this.y;
//			g2D.drawRect(x, this.y, this.w, this.h);
//			System.out.println("  b  "+x+"  -  "+this.y+"  -  "+this.w+"  -  "+this.h);
//		}else if(y<this.y){
//			
//			System.out.println("test");
//			//g2D.drawRect(x, this.y, this.w, this.h);
//			System.out.println("  q  "+x+"  -  "+this.y+"  -  "+this.w+"  -  "+this.h);
//			this.w = x-this.x;
//			this.h = this.y - y;
//			g2D.drawRect(x, this.y, this.w, this.h);
//			System.out.println("  b  "+x+"  -  "+this.y+"  -  "+this.w+"  -  "+this.h);
//		}
//		else{
			g2D.drawRect(this.x, this.y, this.w, this.h);
			this.w = x - this.x;
			this.h = y - this.y;
			g2D.drawRect(this.x, this.y, this.w, this.h);
//		}
				
	}
	@Override
	public void finishDrawing(int x, int y, Graphics g) {
	}
	@Override
	public void draw(Graphics2D g2D) {
		
		System.out.println("test23");
		g2D.drawRect(this.x, this.y, this.w, this.h);		
	}
	@Override
	public void continueDrawing(int x, int y, Graphics2D g2D ) {
//		g2D.drawRect(this.x, this.y, this.w, this.h);
//		this.w = x - this.x;
//		this.h = y - this.y;
//		g2D.drawRect(this.x, this.y, this.w, this.h);
		// TODO Auto-generated method stub
		
	}
}
