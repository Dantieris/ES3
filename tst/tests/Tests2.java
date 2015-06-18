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

public class Tests2 {

	@Test
	public void testAbrirTelaDeEdicaoDeMapaNaoLancaNullPointerException() {
		try {
			new EditorModel().execute(new InitializeRealmCommand(new Realm()));
		} catch (NullPointerException ex) {
			fail("Não deveria lançar nenhuma exceção");
		}
	}

}
