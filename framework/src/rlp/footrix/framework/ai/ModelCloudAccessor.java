package rlp.footrix.framework.ai;

import java.util.List;

public interface ModelCloudAccessor {
    MatchSimulator matchSimulator();

    interface Model {
        String execute(List<String> parameters);
    }
}
