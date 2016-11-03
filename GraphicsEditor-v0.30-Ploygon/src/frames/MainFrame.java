package frames;
import java.awt.BorderLayout;
import javax.swing.JFrame;

import constants.Constants;
import constants.Constants.EMainFrame;

// MainFrame specialize JFrame
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	// components
	private MenuBar menuBar;
	private ToolBar toolBar;
	private DrawingPanel drawingPanel;
	// constructor
	public MainFrame() {
		// attribute initialization
		this.setTitle(Constants.MAINFRAME_TITLE);
		this.setLocation(EMainFrame.X.getValue(), EMainFrame.Y.getValue());
		this.setSize(EMainFrame.W.getValue(), EMainFrame.H.getValue());
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// component creation & registration
		this.menuBar = new MenuBar();
		this.setJMenuBar(menuBar);
		this.toolBar = new ToolBar();
		this.add(toolBar, BorderLayout.NORTH);
		this.drawingPanel = new DrawingPanel();
		this.add(drawingPanel, BorderLayout.CENTER);
	}	
	public void initialize() {
		// set associations among components
		toolBar.setDrawingPanel(this.drawingPanel);
		// component initialization
		this.menuBar.initialize();			
		this.toolBar.initialize();		
		this.drawingPanel.initialize();		
	}
}
