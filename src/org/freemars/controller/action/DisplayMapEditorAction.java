package org.freemars.controller.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import org.freemars.controller.FreeMarsController;
import org.freemars.controller.action.file.Messages;

/**
 *
 * @author Deniz ARIKAN
 */
public class DisplayMapEditorAction extends AbstractAction {

    private FreeMarsController controller;

    public DisplayMapEditorAction(FreeMarsController controller) {
        super(Messages.getString("DisplayMapEditorAction.map_editor"), null); //$NON-NLS-1$
        putValue(SHORT_DESCRIPTION, Messages.getString("DisplayMapEditorAction.map_editor2")); //$NON-NLS-1$
        putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_E));
        this.controller = controller;
    }

    public void actionPerformed(ActionEvent e) {
        controller.displayEditorFrame();
    }
}
