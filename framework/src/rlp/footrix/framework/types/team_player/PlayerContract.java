package rlp.footrix.framework.types.team_player;

import java.time.Instant;

public record PlayerContract(Instant endDate, long salary, Role role) {
    public enum Role {
        Undisputed(0.7), Regular(0.5), Rotation(0.3), Substitute(0.1), Reserve(0.01), Young(0);

        private final double expectedPlayingTime;

        Role(double expectedPlayingTime) {
            this.expectedPlayingTime = expectedPlayingTime;
        }

        public double expectedPlayingTime() {
            return expectedPlayingTime;
        }
    }
}
