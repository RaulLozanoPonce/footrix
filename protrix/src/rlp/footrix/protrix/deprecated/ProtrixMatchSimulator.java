//package rlp.footrix.protrix.deprecated;
//
//import rlp.footrix.framework.ai.ModelCloudAccessor;
//import rlp.footrix.framework.types.entities.Match;
//import rlp.footrix.protrix.deprecated.helpers.TeamsHandle;
//
//import java.util.List;
//
//public class ProtrixMatchSimulator implements ModelCloudAccessor.Model {
//
//    private static final int framesPerMinute = 5;
//
//    private int duration = 0;
//
//    @Override
//    public String execute(List<String> list) {
//        this.definition = definition;
//        this.phase = phase;
//        this.date = date;
//        this.state = new MatchState(definition.local(), definition.visitant(), phase.substitutionsNumber(), framesPerMinute * 90);
//        this.teamsHandle = new TeamsHandle(this.state);
//
//
//        this.state.localPlayers(localPlayersLineup).visitantPlayers(visitantPlayersLineup);
//        simulateMatch();
//        return new Match(definition, date, state.playerStatistics(), state.events(), state.mvp(), duration);
//    }
//
//    private void simulateMatch() {
//        boolean continueMatch = simulateRegularMatch();
//        if (!continueMatch) return;
//        if (!phase.withExtension() || !isDraw()) return;
//        simulateExtension();
//    }
//
//    private boolean simulateRegularMatch() {
//        state.setPossession(state.local(), state.localPlayers().getFirst());
//        boolean continueMatch = simulatePart(1, 45);
//        if (!continueMatch) return false;
//        state.setPossession(state.visitant(), state.visitantPlayers().getFirst());
//        simulatePart(46, 90);
//        return true;
//    }
//
//    private boolean simulateExtension() {
//        state.setPossession(state.local(), state.localPlayers().getFirst());
//        boolean continueMatch = simulatePart(91, 105);
//        if (!continueMatch) return false;
//        state.setPossession(state.visitant(), state.visitantPlayers().getFirst());
//        simulatePart(106, 120);
//        return true;
//    }
//
//    private boolean simulatePart(int from, int to) {
//        for (int i = from; i <= to; i++) {
//            for (int j = 0; j < framesPerMinute; j++) {
//                duration = i;
//                boolean continueMatch = simulateSubMinute(i);
//                if (!continueMatch) return false;
//            }
//            state.addMinutes();
//            state.events().addAll(new SubstitutionsSimulator(state, i).simulate());
//        }
//        return true;
//    }
//
//    private boolean simulateSubMinute(int minute) {
//        state.events().addAll(eventsOfAction(minute));
//        state.events().addAll(new OutsSimulator(state, minute).simulate());
//        state.addFatigue();
//        Map<String, List<Match.MatchEvent>> outs = state.events().stream().filter(e -> e.type() == Expulsion).collect(Collectors.groupingBy(Match.MatchEvent::team));
//        for (Map.Entry<String, List<Match.MatchEvent>> entry : outs.entrySet()) {
//            if (entry.getValue().size() >= 5) {
//                state.events(state.events().stream().filter(e -> e.type() != Goal).toList());
//                String team = state.rivalOf(entry.getKey());
//                state.events().add(new Match.MatchEvent(team, Goal, minute, null, null));
//                state.events().add(new Match.MatchEvent(team, Goal, minute, null, null));
//                state.events().add(new Match.MatchEvent(team, Goal, minute, null, null));
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private List<Match.MatchEvent> eventsOfAction(int minute) {
//        Position position = state.positionOf(state.playerWithPossession());
//        double actionValue = Math.random();
//        if (actionValue < shotProbabilityOf(position)) {
//            return new ShootSimulator(state, minute).simulate();
//        } else {
//            Player rival = teamsHandle.mostProbablyRivalTo(state.teamWithPossession(), state.playerWithPossession());
//            if (actionValue < shotProbabilityOf(position) + passProbabilityOf(position)) {
//                return new PassSimulator(state, minute, rival).simulate();
//            } else {
//                return new DribbleSimulator(state, minute, rival).simulate();
//            }
//        }
//    }
//
//    private boolean isDraw() {
//        int localGoals = (int) state.events().stream().filter(e -> e.type() == Goal).filter(e -> e.team().equals(state.local())).count();
//        int visitantGoals = (int) state.events().stream().filter(e -> e.type() == Goal).filter(e -> e.team().equals(state.visitant())).count();
//        return localGoals == visitantGoals;
//    }
//}
