package shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;

import constants.Constants.EDrawingType;

abstract public class GShape {
	private EDrawingType eDrawingType;
	
	public GShape(EDrawingType eDrawingType){
		this.eDrawingType = eDrawingType;
	}
	abstract public void draw(Graphics2D g2D);
	abstract public void initDrawing(int x, int y, Graphics2D g2D);
	abstract public void keepDrawing(int x, int y, Graphics2D g2D);
	abstract public void continueDrawing(int x, int y, Graphics2D g2D);
	abstract public void finishDrawing(int x, int y, Graphics g);
	public GShape clone() {
		try {
			return this.getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	public EDrawingType geteDrawingType() {
		return eDrawingType;
	}
	public void seteDrawingType(EDrawingType eDrawingType) {
		this.eDrawingType = eDrawingType;
	}
}
