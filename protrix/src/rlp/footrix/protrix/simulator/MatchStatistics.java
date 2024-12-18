package rlp.footrix.protrix.simulator;

import rlp.footrix.framework.types.Position;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchStatistics {
    private final Map<Position, Integer> successfulDribbles = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private final Map<Position, Integer> unsuccessfulDribbles = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private final Map<Position, Integer> successfulPasses = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private final Map<Position, Integer> unsuccessfulPasses = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private final Map<Position, Integer> shootsOffTarget = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private final Map<Position, Integer> shootsInTargetSaved = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private final Map<Position, Integer> goals = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private final Map<Position, Integer> assistances = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private final Map<Position, Integer> faultsCommited = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private final Map<Position, Integer> foulsReceived = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private final Map<Position, Integer> yellowCards = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private final Map<Position, Integer> yellowExpulsions = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private final Map<Position, Integer> redCards = Arrays.stream(Position.values()).collect(Collectors.toMap(p -> p, p -> 0));
    private int injuries = 0;

    public Map<Position, Integer> successfulDribbles() {
        return successfulDribbles;
    }

    public Map<Position, Integer> unsuccessfulDribbles() {
        return unsuccessfulDribbles;
    }

    public Map<Position, Integer> successfulPasses() {
        return successfulPasses;
    }

    public Map<Position, Integer> unsuccessfulPasses() {
        return unsuccessfulPasses;
    }

    public Map<Position, Integer> shootsOffTarget() {
        return shootsOffTarget;
    }

    public Map<Position, Integer> shootsInTargetSaved() {
        return shootsInTargetSaved;
    }

    public Map<Position, Integer> goals() {
        return goals;
    }

    public Map<Position, Integer> assistances() {
        return assistances;
    }

    public Map<Position, Integer> faultsCommited() {
        return faultsCommited;
    }

    public Map<Position, Integer> foulsReceived() {
        return foulsReceived;
    }

    public Map<Position, Integer> yellowCards() {
        return yellowCards;
    }

    public Map<Position, Integer> yellowExpulsions() {
        return yellowExpulsions;
    }

    public Map<Position, Integer> redCards() {
        return redCards;
    }

    public int injuries() {
        return injuries;
    }

    public void addSuccessfulDribble(Position dribbler, Position haggled) {
        this.successfulDribbles.put(dribbler, this.successfulDribbles.get(dribbler) + 1);
    }

    public void addUnsuccessfulDribble(Position dribbler, Position haggled) {
        this.unsuccessfulDribbles.put(dribbler, this.unsuccessfulDribbles.get(dribbler) + 1);
    }

    public void addSuccessfulPass(Position passer, Position cutter) {
        this.successfulPasses.put(passer, this.successfulPasses.get(passer) + 1);
    }

    public void addUnsuccessfulPass(Position passer, Position cutter) {
        this.unsuccessfulPasses.put(passer, this.unsuccessfulPasses.get(passer) + 1);
    }

    public void addShootOffTarget(Position shooter) {
        this.shootsOffTarget.put(shooter, this.shootsOffTarget.get(shooter) + 1);
    }

    public void addShootInTargetSaved(Position goalkeeper) {
        this.shootsInTargetSaved.put(goalkeeper, this.shootsInTargetSaved.get(goalkeeper) + 1);
    }

    public void addGoal(Position scorer) {
        this.goals.put(scorer, this.goals.get(scorer) + 1);
    }

    public void addAssistance(Position assistant) {
        this.assistances.put(assistant, this.assistances.get(assistant) + 1);
    }

    public void addFault(Position fouler, Position fouled) {
        this.faultsCommited.put(fouler, this.faultsCommited.get(fouler) + 1);
        this.foulsReceived.put(fouled, this.foulsReceived.get(fouled) + 1);
    }

    public void addYellowCard(Position fouler) {
        this.yellowCards.put(fouler, this.yellowCards.get(fouler) + 1);
    }

    public void addYellowExpulsion(Position fouler) {
        this.yellowExpulsions.put(fouler, this.yellowExpulsions.get(fouler) + 1);
    }

    public void addRedCard(Position fouler) {
        this.redCards.put(fouler, this.redCards.get(fouler) + 1);
    }

    public void addInjury() {
        this.injuries++;
    }
}
