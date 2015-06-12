package org.freemars.earth.action;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;
import org.freemars.controller.FreeMarsController;
import org.freemars.controller.action.DisplayRenameUnitFromOrbitDialogAction;
import org.freemars.earth.ui.OrbitDialog;
import org.freemars.earth.ui.UnitSelectionToggleButton;
import org.freerealm.settlement.Settlement;
import org.freerealm.settlement.improvement.SettlementImprovement;
import org.freerealm.settlement.improvement.SettlementImprovementType;
import org.freerealm.unit.Unit;

/**
 *
 * @author Deniz ARIKAN
 */
public class OrbitDialogUnitSelectionAction extends AbstractAction {

    private FreeMarsController freeMarsController;
    private OrbitDialog orbitDialog;

    public OrbitDialogUnitSelectionAction(FreeMarsController freeMarsController, OrbitDialog orbitDialog) {
        this.freeMarsController = freeMarsController;
        this.orbitDialog = orbitDialog;
    }

    public void actionPerformed(ActionEvent e) {
        JPopupMenu popup = new JPopupMenu();
        SettlementImprovementType starPortImprovementType = freeMarsController.getFreeMarsModel().getRealm().getSettlementImprovementManager().getImprovement("Starport");
        UnitSelectionToggleButton unitSelectionToggleButton = (UnitSelectionToggleButton) e.getSource();
        Unit unit = unitSelectionToggleButton.getUnit();
        SendUnitInOrbitToEarthAction sendUnitInOrbitToEarthAction = new SendUnitInOrbitToEarthAction(freeMarsController, orbitDialog, unit);
        JMenuItem goToEarthMenuItem = new JMenuItem();
        goToEarthMenuItem.setAction(sendUnitInOrbitToEarthAction);
        goToEarthMenuItem.setText("Go to Earth");
        popup.add(goToEarthMenuItem);
        JMenu goToMarsCityMenu = new JMenu("Land on Martian starport");
        Iterator<Settlement> iterator = unit.getPlayer().getSettlementsIterator();
        boolean colonyWithStarportFound = false;
        while (iterator.hasNext()) {
            Settlement settlement = iterator.next();
            SettlementImprovement starPortImprovement = settlement.getImprovementOfType(starPortImprovementType);
            if (starPortImprovement != null) {
                colonyWithStarportFound = true;
                JMenuItem marsCityMenuItem = new JMenuItem();
                marsCityMenuItem.setEnabled(starPortImprovement.isEnabled());
                if (starPortImprovement.isEnabled()) {
                    marsCityMenuItem.setAction(new LandUnitInOrbitToMarsColonyAction(freeMarsController, orbitDialog, unit, settlement));
                    marsCityMenuItem.setText(settlement.getName());
                } else {
                    marsCityMenuItem.setText(settlement.getName() + " (Inactive)");
                }
                goToMarsCityMenu.add(marsCityMenuItem);
            }
        }
        if (colonyWithStarportFound) {
            popup.add(goToMarsCityMenu);
        } else {
            popup.add(new JSeparator());
            JMenuItem noStarportMenuItem = new JMenuItem("No starport on Mars");
            noStarportMenuItem.setEnabled(false);
            noStarportMenuItem.setFont(noStarportMenuItem.getFont().deriveFont(Font.ITALIC));
            popup.add(noStarportMenuItem);
        }
        popup.add(new JMenuItem(new DisplayRenameUnitFromOrbitDialogAction(freeMarsController, orbitDialog, unit)));
        popup.show(unitSelectionToggleButton, unitSelectionToggleButton.getWidth() / 2, unitSelectionToggleButton.getHeight() / 4);
    }
}
