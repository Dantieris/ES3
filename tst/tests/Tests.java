package tests;

import static org.junit.Assert.*;

import org.freemars.FreeMarsLauncher;
import org.freemars.controller.FreeMarsController;
import org.freemars.editor.EditorModel;
import org.freerealm.Realm;
import org.freerealm.executor.command.InitializeRealmCommand;
import org.junit.Test;

public class Tests {

	@Test
	public void testAbrirTelaDeEdicaoDeMapaNaoLancaNullPointerException() {
		try {
			new EditorModel().execute(new InitializeRealmCommand(new Realm()));
		} catch (NullPointerException ex) {
			fail("N�o deveria lan�ar nenhuma exce��o");
		}
	}

}
