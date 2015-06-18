package org.freemars.controller.action;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.freemars.controller.FreeMarsController;

/**
 *
 * @author Deniz ARIKAN
 */
public class DisplayHelpContentsAction extends AbstractAction {

    private FreeMarsController controller;
    private String helpId;

    public DisplayHelpContentsAction(FreeMarsController controller, String helpId) {
        super("Martepédia", null);
        this.controller = controller;
        this.helpId = helpId;
    }

    public void actionPerformed(ActionEvent e) {
        controller.getHelpDialog().display(helpId);
    }
}
