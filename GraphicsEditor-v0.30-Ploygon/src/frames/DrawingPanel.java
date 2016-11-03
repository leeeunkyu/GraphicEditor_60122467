package frames;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import constants.Constants.EDrawingType;
import constants.Constants.EToolBarButton;
import shapes.GEllipse;
import shapes.GLine;
import shapes.GPolygon;
import shapes.GRectangle;
import shapes.GShape;

public class DrawingPanel extends JPanel {
	// attributes
	private static final long serialVersionUID = 1L;
	// object states
	private enum EState {idle, drawing};
	// components
	private Vector<GShape> shapeVector;
	
	// associative attributes
	private GShape selectedShape;
	// working objects;
	private GShape currentShape;
	
	private GShape finshShape;
	
	public DrawingPanel() {
		MouseEventHandler mouseEventHandler = new MouseEventHandler();
		this.addMouseListener(mouseEventHandler);
		this.addMouseMotionListener(mouseEventHandler);
		
		this.shapeVector = new Vector<GShape>();
	}
	public void initialize() {
	}
	
//	public void setESelectedTool(EToolBarButton eSelectedTool) {
//		switch (eSelectedTool) {
//		case rectangle:
//			this.selectedShape = new GRectangle();
//			break;
//		case ellipse:
//			this.selectedShape = new GEllipse();
//			break;
//		case line:
//			this.selectedShape = new GLine();
//			break;
//		case polygon:
//			this.selectedShape = new GPolygon();
//			break;
//		default:
//			break;
//		}	
//	}
	public void setselectedShape(GShape shape) {
		// TODO Auto-generated method stub
		System.out.println(this.selectedShape);
		this.selectedShape=shape;
	}
	public void paint(Graphics g) {
		for (GShape shape: this.shapeVector) {
			shape.draw((Graphics2D)g);
		}
	}
	
	private void initDrawing(int x, int y) {
		this.currentShape= this.selectedShape.clone();
		Graphics2D g2D = (Graphics2D)this.getGraphics();
		g2D.setXORMode(this.getBackground());
		this.currentShape.initDrawing(x, y, g2D);
	}
	private void keepDrawing(int x, int y) {
		Graphics2D g2D = (Graphics2D)this.getGraphics();
		g2D.setXORMode(this.getBackground());
		this.currentShape.keepDrawing(x, y, g2D);
	}
	private void finishDrawing(int x, int y) {
		Graphics2D g2D = (Graphics2D)this.getGraphics();
		
		this.currentShape.finishDrawing(x, y, g2D);
		this.shapeVector.add(this.currentShape);
	}	
	private void continueDrawing(int x, int y) {
		Graphics2D g2D = (Graphics2D)this.getGraphics();
		g2D.setXORMode(this.getBackground());
		this.currentShape.continueDrawing(x, y, g2D);
		this.shapeVector.add(this.currentShape);
	}
	
	
	class MouseEventHandler 
		implements MouseInputListener, MouseMotionListener {
		private EState eState = EState.idle;
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount()==1){
				mouse1Clicked(e);
			}else if(e.getClickCount()==2){
				mouse2Clicked(e);
			}
 		}
		public void mouse1Clicked(MouseEvent e) {
			if (eState == EState.idle) {
				if(selectedShape.geteDrawingType()== EDrawingType.NP){
				initDrawing(e.getX(), e.getY());
				System.out.println(e.getX()+"    -     " +e.getY());
				eState = EState.drawing;
				}
			}else if (eState == EState.drawing) {		
				//finishDrawing(e.getX(), e.getY());
				continueDrawing(e.getX(),e.getY());
				eState = EState.idle;
			}
		}
		public void mouse2Clicked(MouseEvent e) {
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			if (eState == EState.idle) {
				initDrawing(e.getX(), e.getY());
				System.out.println(e.getX()+"    -     " +e.getY());
				
				eState = EState.drawing;
				if(e.getClickCount()==2){
					finishDrawing(e.getX(),e.getY());
				}
			}		
			}
		@Override
		public void mouseReleased(MouseEvent e) {
			if (eState == EState.drawing) {		
				//finishDrawing(e.getX(), e.getY());
				continueDrawing(e.getX(),e.getY());
				eState = EState.idle;
			}
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			if (eState == EState.drawing) {
				keepDrawing(e.getX(), e.getY());
			}
		}		
		@Override
		public void mouseDragged(MouseEvent e) {
			if (eState == EState.drawing) {
				keepDrawing(e.getX(), e.getY());
			}
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
		}
	}


	
}
