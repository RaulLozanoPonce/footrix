package rlp.footrix.framework.commands.types;

import rlp.footrix.framework.Application;
import rlp.footrix.framework.calculators.ContractHelper;
import rlp.footrix.framework.events.types.NewSeasonEvent;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.team.Team;

import java.util.List;

public class NewSeasonCommand {
    private final Application application;

    public NewSeasonCommand(Application application, NewSeasonEvent event) {
        this.application = application;
    }

    public void execute() {
        retirePlayers();
        initSeason();
        initEvents();
        createPlayers();
        adjustTeamFans();
    }

    private void retirePlayers() {
        List<Player> players = application.playerManager().players().stream().filter(Player::active).filter(Player::isDecidedToRetire).toList();
        players.forEach(Player::retire);
        System.out.println("Jugadores retirados: " + players.size());
    }

    private void initSeason() {
        application.game().initSeason(application.game().seasonNumber() + 1);
        application.competitionManager().setupNewSeason();
    }

    private void initEvents() {
        application.taskHub().add(application.newSeasonTasks(false));
    }

    private void createPlayers() {
        //TODO PONER 275 COMO VARIABLE
        int count = 0;
        for (Team team : application.teamManager().teams()) {
            for (int i = 0; i < 5; i++) {
                Player player = application.models().playerGenerator().generate(application.getDate());
                team.setPlayer(player, ContractHelper.youngContractOf(player, application.eloManager().percentElo(team.definition().id())));
                application.playerManager().add(player);
                count++;
            }
        }
        for (int i = count; i < 275; i++) {
            application.playerManager().add(application.models().playerGenerator().generate(application.getDate()));
        }
    }

    private void adjustTeamFans() {
        for (Team team : application.teamManager().teams()) {
            team.fans().newSeason(team.elo().quantity());
        }
    }
}
