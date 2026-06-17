package rlp.footrix.framework.types.entities;

import rlp.footrix.framework.types.entities.player.Player;

import java.util.Map;

public record Training(Map<Player, TrainingRecord> records) {
    public record TrainingRecord(double score, /*Map<String, Double> trainings,*/ double fatigue, int injuryLevel) {}
}
