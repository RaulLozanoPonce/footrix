package rlp.footrix.protrix.simulator.actions;

import rlp.footrix.framework.types.Match;
import rlp.footrix.framework.types.Player;
import rlp.footrix.protrix.model.ProtrixPlayer;
import rlp.footrix.protrix.simulator.ActionSimulator;
import rlp.footrix.protrix.simulator.MatchState;

import java.util.ArrayList;
import java.util.List;

import static rlp.footrix.framework.types.Match.MatchEvent.Type.Assist;
import static rlp.footrix.framework.types.Match.MatchEvent.Type.Goal;
import static rlp.footrix.framework.types.Position.PT;

public class MatchMinuteShootSimulator extends ActionSimulator {

    private final ProtrixPlayer player;
    private final String team;
    private final String rivalTeam;

    public MatchMinuteShootSimulator(MatchState state, int minute) {
        super(state, minute);
        this.player = (ProtrixPlayer) state.playerWithPossession();
        this.team = state.teamWithPossession();
        this.rivalTeam = state.rivalOf(team);
    }

    @Override
    public List<Match.MatchEvent> simulate() {
        double playerOverall = localFactor(team) * shootOf(player) * percentOf(player.overall())/100.0;
        double failOverall = percentOf(78);
        double random = Math.random() * (playerOverall + failOverall);
        List<Match.MatchEvent> events = random < playerOverall ? successfulShot() : unsuccessfulShot();
        this.state.init(rivalTeam, state.playersOf(rivalTeam).getFirst());
        return events;
    }

    private List<Match.MatchEvent> successfulShot() {
        ProtrixPlayer goalKeeper = state.playersOf(rivalTeam).stream().filter(p -> state.positionOf(p) == PT).map(p -> (ProtrixPlayer) p).toList().getFirst();
        double rivalOverall = localFactor(rivalTeam) * goalkeeperOf(goalKeeper) * percentOf(goalKeeper.overall())/100.0;
        double goalOverall = percentOf(65);
        double random = Math.random() * (rivalOverall + goalOverall) * Math.pow(2.72, -0.2 * state.goalsFor(team));
        return random < rivalOverall ? save(goalKeeper) : goal(goalKeeper);
    }

    private List<Match.MatchEvent> goal(Player goalKeeper) {
        List<Match.MatchEvent> events = new ArrayList<>();
        state.addGoal(player, goalKeeper);
        events.add(new Match.MatchEvent(team, Goal, minute, state.playerWithPossession().definition().id()));
        if (state.previousPlayerWithPossession() == null) return events;
        state.addAssistance(state.previousPlayerWithPossession());
        events.add(new Match.MatchEvent(team, Assist, minute, state.previousPlayerWithPossession().definition().id()));
        return  events;
    }

    private List<Match.MatchEvent> save(Player goalKeeper) {
        state.addShootInTargetSaved(player, goalKeeper);
        return new ArrayList<>();
    }

    private List<Match.MatchEvent> unsuccessfulShot() {
        state.addShootOffTarget(player);
        return new ArrayList<>();
    }

    private double shootOf(ProtrixPlayer player) {
        return player.energy() * (player.mood().overall() + 0.5) * (0.6 * player.shootSummary() + 0.3 * player.techniqueSummary() + 0.1 * player.physiqueSummary());
    }

    private double goalkeeperOf(ProtrixPlayer goalKeeper) {
        return (goalKeeper.mood().overall() + 0.5) * (0.7 * goalKeeper.gkSkills() + 0.2 * goalKeeper.speedSummary() + 0.1 * goalKeeper.physiqueSummary());
    }
}
