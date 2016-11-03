package menus;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.Constants;

public class FileMenu extends JMenu {
	private static final long serialVersionUID = 1L;

	public FileMenu() {
		super(Constants.FILEMENU_TITLE);
		for (int i=0; i<Constants.EFileMenuItem.values().length; i++) {
			JMenuItem menuItem = new JMenuItem(
					Constants.EFileMenuItem.values()[i].getText());
			this.add(menuItem);
		}
	}		
}
