package rlp.footrix.protrix.types;

import rlp.footrix.framework.types.entities.definitions.PlayerDefinition;
import rlp.footrix.framework.types.entities.player.Player;
import rlp.footrix.framework.types.entities.player.Position;
import rlp.footrix.protrix.helper.PositionFactorCalculator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProtrixPlayer extends Player {

    public ProtrixPlayer(PlayerDefinition definition, Position mainPosition, List<Position> secondaryPositions) {
        super(definition, mainPosition, secondaryPositions);
        this.otherPositions.putAll(otherPositions(mainPosition, secondaryPositions));
    }

    public double otherPositionFactor(Position position) {
        return otherPositions.get(position);
    }

    private Map<Position, Double> otherPositions(Position mainPosition, List<Position> secondaryPositions) {
        Map<Position, Double> otherPositions = new HashMap<>();
        for (Position position : Positions.values()) {
            if (position == mainPosition || secondaryPositions.contains(position)) continue;
            otherPositions.put(position, PositionFactorCalculator.factor(mainPosition, position));
        }
        return otherPositions;
    }

    private double average(Integer... skills) {
        return Arrays.stream(skills).mapToInt(s -> s).average().getAsDouble();
    }
}
