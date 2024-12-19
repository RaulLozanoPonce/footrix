package rlp.footrix.framework.var;

import rlp.footrix.framework.types.Position;

import java.time.Instant;

public class PlayerMatchPerformance implements Revision {

    private final Instant date;
    private String player;
    private String match;
    private Position position;
    private Double preEnergy;
    private Double postEnergy;
    private Double preHappiness;
    private Double postHappiness;
    private Boolean isExpelled;
    private Boolean isInjured;
    private Integer enterMinute;
    private Integer exitMinute;
    private String note;

    public PlayerMatchPerformance(Instant date) {
        this.date = date;
    }

    @Override
    public Instant date() {
        return date;
    }

    public String player() {
        return player;
    }

    public PlayerMatchPerformance player(String player) {
        this.player = player;
        return this;
    }

    public String match() {
        return match;
    }

    public PlayerMatchPerformance match(String match) {
        this.match = match;
        return this;
    }

    public Position position() {
        return position;
    }

    public PlayerMatchPerformance position(Position position) {
        this.position = position;
        return this;
    }

    public Double preEnergy() {
        return preEnergy;
    }

    public PlayerMatchPerformance preEnergy(Double preEnergy) {
        this.preEnergy = preEnergy;
        return this;
    }

    public Double postEnergy() {
        return postEnergy;
    }

    public PlayerMatchPerformance postEnergy(Double postEnergy) {
        this.postEnergy = postEnergy;
        return this;
    }

    public Double preHappiness() {
        return preHappiness;
    }

    public PlayerMatchPerformance preHappiness(Double preHappiness) {
        this.preHappiness = preHappiness;
        return this;
    }

    public Double postHappiness() {
        return postHappiness;
    }

    public PlayerMatchPerformance postHappiness(Double postHappiness) {
        this.postHappiness = postHappiness;
        return this;
    }

    public Boolean expelled() {
        return isExpelled;
    }

    public PlayerMatchPerformance expelled(Boolean expelled) {
        this.isExpelled = expelled;
        return this;
    }

    public Boolean injured() {
        return isInjured;
    }

    public PlayerMatchPerformance injured(Boolean injured) {
        this.isInjured = injured;
        return this;
    }

    public Integer enterMinute() {
        return enterMinute;
    }

    public PlayerMatchPerformance enterMinute(Integer enterMinute) {
        this.enterMinute = enterMinute;
        return this;
    }

    public Integer exitMinute() {
        return exitMinute;
    }

    public PlayerMatchPerformance exitMinute(Integer exitMinute) {
        this.exitMinute = exitMinute;
        return this;
    }

    public String note() {
        return note;
    }

    public PlayerMatchPerformance note(String note) {
        this.note = note;
        return this;
    }
}
