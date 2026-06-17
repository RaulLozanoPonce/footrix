package rlp.footrix.framework.ai;

public interface ModelCloudAccessor {
    MatchSimulator matchSimulator();
    PlayerGenerator playerGenerator();
    Trainer trainer();
}
