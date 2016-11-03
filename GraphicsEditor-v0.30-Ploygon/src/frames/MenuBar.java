package frames;
import javax.swing.JMenuBar;

import menus.EditMenu;
import menus.FileMenu;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;

	MenuBar() {
		FileMenu fileMenu = new FileMenu();
		this.add(fileMenu);
		EditMenu editMenu = new EditMenu();
		this.add(editMenu);
	}

	public void initialize() {
		// TODO Auto-generated method stub
		
	}
}
