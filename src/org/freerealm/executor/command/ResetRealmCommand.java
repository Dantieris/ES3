package org.freerealm.executor.command;

import org.freerealm.Realm;
import org.freerealm.executor.CommandResult;
import org.freerealm.settlement.improvement.SettlementImprovementManager;
import org.freerealm.resource.ResourceManager;
import org.freerealm.tile.TileTypeManager;
import org.freerealm.tile.improvement.TileImprovementTypeManager;
import org.freerealm.diplomacy.Diplomacy;
import org.freerealm.history.FreeRealmHistory;
import org.freerealm.map.FreeRealmMap;
import org.freerealm.player.PlayerManager;
import org.freerealm.nation.NationManager;
import org.freerealm.resource.bonus.BonusResourceManager;
import org.freerealm.unit.UnitTypeManager;
import org.freerealm.vegetation.VegetationTypeManagerImpl;

/**
 * Command class to reset the given realm.
 *
 * @author Deniz ARIKAN
 */
public class ResetRealmCommand extends AbstractCommand {
    
    public ResetRealmCommand(Realm realm) {
        super(realm);
    }

    /**
     * Executes command to reset the given realm.
     *
     * @param realm Realm to execute the command
     * @return CommandResult
     */
    public CommandResult execute() {
        getRealm().setResourceManager(new ResourceManager());
        getRealm().setBonusResourceManager(new BonusResourceManager());
        getRealm().setTileTypeManager(new TileTypeManager());
        getRealm().setVegetationManager(new VegetationTypeManagerImpl());
        getRealm().setTileImprovementTypeManager(new TileImprovementTypeManager());
        getRealm().setSettlementImprovementManager(new SettlementImprovementManager());
        getRealm().setUnitTypeManager(new UnitTypeManager());
        getRealm().setNationManager(new NationManager());
        getRealm().setPlayerManager(new PlayerManager());
        getRealm().setDiplomacy(new Diplomacy());
        getRealm().setHistory(new FreeRealmHistory());
        getRealm().setMap(new FreeRealmMap());
        getRealm().setPathFinder(null);
        getRealm().setNumberOfTurns(0);
        getRealm().setMapItemCount(0);
        return new CommandResult(CommandResult.NO_UPDATE, "");
    }
}
