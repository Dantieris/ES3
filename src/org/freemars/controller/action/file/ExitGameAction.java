package org.freemars.controller.action.file;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.freemars.controller.FreeMarsController;

/**
 *
 * @author Deniz ARIKAN
 */
public class ExitGameAction extends AbstractAction {

    private FreeMarsController controller;

    public ExitGameAction(FreeMarsController controller) {
        super(Messages.getString("ExitGameAction.exit_game")); //$NON-NLS-1$
        this.controller = controller;
    }

    public void actionPerformed(ActionEvent e) {
        Object[] options = {Messages.getString("ExitGameAction.yes_exit"), Messages.getString("ExitGameAction.no_thanks")}; //$NON-NLS-1$ //$NON-NLS-2$
        int value = JOptionPane.showOptionDialog(controller.getCurrentFrame(),
                Messages.getString("ExitGameAction.really_quit"), //$NON-NLS-1$
                Messages.getString("ExitGameAction.quit_game"), //$NON-NLS-1$
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if (value == JOptionPane.YES_OPTION) {
            Logger.getLogger(ExitGameAction.class).info("Exiting Free Mars.");
            System.exit(0);
        }
    }
}
