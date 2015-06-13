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
import org.junit.Test;

public class Tests {

	@Test
	public void testAbrirTelaDeEdicaoDeMapaNaoLancaNullPointerException() {
		try {
			new EditorModel().execute(new InitializeRealmCommand(new Realm()));
		} catch (NullPointerException ex) {
			fail("Não deveria lançar nenhuma exceção");
		}
	}
	
	@Test
	public void testTraducaoMenuPrincipalPortugues () {
		FreeMarsLauncher.main(null);
		
		FreeMarsController controller = new FreeMarsController();
		
		assertEquals("Continuar", controller.getMainMenuFrame().getMenuWindow().getContinueButton().getText());
		assertEquals("Novo Jogo", controller.getMainMenuFrame().getMenuWindow().getNewButton().getText());
		assertEquals("Carregar", controller.getMainMenuFrame().getMenuWindow().getOpenButton().getText());
		assertEquals("Carregar Rápido", controller.getMainMenuFrame().getMenuWindow().getQuickLoadButton().getText());
		assertEquals("Preferências", controller.getMainMenuFrame().getMenuWindow().getPreferencesButton().getText());
		assertEquals("Editor de Mapas", controller.getMainMenuFrame().getMenuWindow().getEditorButton().getText());
		assertEquals("Martepedia", controller.getMainMenuFrame().getMenuWindow().getMarsopediaButton().getText());
		assertEquals("Sair do Jogo", controller.getMainMenuFrame().getMenuWindow().getExitButton().getText());
		
	}

}
