package rlp.footrix.protrix.var;

import rlp.footrix.framework.var.Revision;
import rlp.footrix.framework.var.Var;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProtrixVar implements Var {

    private Map<Class<? extends Revision>, Map<String, Revision>> revisions = new HashMap<>();

    public void publish(Revision revision) {
        this.revisions.putIfAbsent(revision.getClass(), new HashMap<>());
        if (revision instanceof MatchMetricRevision matchMetricRevision) publish(matchMetricRevision);
        else this.revisions.get(revision.getClass()).put(revision.key(), revision);
    }

    public <T extends Revision> List<T> revisions(Class<T> clazz) {
        Map<String, T> revisions = (Map<String, T>) this.revisions.get(clazz);
        if (revisions == null) return new ArrayList<>();
        return new ArrayList<>(revisions.values());
    }

    public void publish(MatchMetricRevision revision) {
        Map<String, Revision> revisions = this.revisions.get(revision.getClass());
        if (revisions.containsKey(revision.key())) {
            ((MatchMetricRevision) revisions.get(revision.key())).sum();
        } else {
            revisions.put(revision.key(), revision);
        }
    }
}
