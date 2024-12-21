package rlp.footrix.protrix.var;

import rlp.footrix.framework.var.Revision;
import rlp.footrix.framework.var.Var;

import java.util.*;

public class ProtrixVar implements Var {

    private Map<Class<? extends Revision>, List<Revision>> revisions = new HashMap<>();

    public void publish(Revision revision) {
        this.revisions.putIfAbsent(revision.getClass(), new ArrayList<>());
        this.revisions.get(revision.getClass()).add(revision);
    }

    public <T extends Revision> List<T> revisions(Class<T> clazz) {
        List<T> revisions = (List<T>) this.revisions.get(clazz);
        if (revisions == null) return new ArrayList<>();
        return revisions.stream().sorted(Comparator.comparingLong(e -> e.date().toEpochMilli())).toList();
    }
}
