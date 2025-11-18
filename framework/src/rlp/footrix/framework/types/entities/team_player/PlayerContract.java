package rlp.footrix.framework.types.entities.team_player;

import java.time.Instant;

public record PlayerContract(Instant endDate, float salary, Role role) {
    public enum Role {
        Undisputed(0.7, 1.15), Regular(0.5, 1), Rotation(0.3, 0.85), Substitute(0.1, 0.65), Reserve(0.01, 0.4), Young(0, 0.3);

        private final double expectedPlayingTime;
        private final double salaryFactor;

        Role(double expectedPlayingTime, double salaryFactor) {
            this.expectedPlayingTime = expectedPlayingTime;
            this.salaryFactor = salaryFactor;
        }

        public double expectedPlayingTime() {
            return expectedPlayingTime;
        }

        public double salaryFactor() {
            return salaryFactor;
        }
    }
}
