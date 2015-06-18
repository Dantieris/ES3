package tests;

import static org.junit.Assert.*;

import org.freemars.FreeMarsLauncher;
import org.freemars.controller.FreeMarsController;
import org.freemars.controller.action.file.ContinueGameAction;
import org.freemars.editor.EditorModel;
import org.freemars.ui.mainmenu.MainMenuFrame;
import org.freemars.ui.mainmenu.MenuWindow;
import org.freerealm.Realm;
import org.freerealm.executor.command.InitializeRealmCommand;
import org.junit.Before;
import org.junit.Test;

public class Tests {
	
	private FreeMarsController controller;
	
	@Before
	public void before() {
		FreeMarsLauncher.main(null);
		
		controller = new FreeMarsController();
	}
	
	@Test
	public void testTraducaoContinue() {		
		assertEquals("Continuar", controller.getMainMenuFrame().getMenuWindow().getContinueButton().getText());
	}
	
	@Test
	public void testTraducaoNewGame() {		
		assertEquals("Novo jogo", controller.getMainMenuFrame().getMenuWindow().getNewButton().getText());
	}
	
	@Test
	public void testTraducaoLoad() {		
		assertEquals("Carregar", controller.getMainMenuFrame().getMenuWindow().getOpenButton().getText());
	}
	
	@Test
	public void testTraducaoQuickLoad() {		
		assertEquals("Carregar rápido", controller.getMainMenuFrame().getMenuWindow().getQuickLoadButton().getText());
	}
	
	@Test
	public void testTraducaoPreferences() {
		assertEquals("Preferências", controller.getMainMenuFrame().getMenuWindow().getPreferencesButton().getText());
	}
	
	@Test
	public void testTraducaoMapEditor() {
		assertEquals("Editor de mapas", controller.getMainMenuFrame().getMenuWindow().getEditorButton().getText());
	}
	
	@Test
	public void testTraducaoMarspedia() {
		assertEquals("Martepédia", controller.getMainMenuFrame().getMenuWindow().getMarsopediaButton().getText());
	}
	
	@Test
	public void testTraducaoExitGame() {
		assertEquals("Sair do jogo", controller.getMainMenuFrame().getMenuWindow().getExitButton().getText());
	}

}
