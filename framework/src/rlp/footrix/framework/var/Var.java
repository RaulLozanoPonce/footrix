package rlp.footrix.framework.var;

import java.util.*;

public interface Var {
    void publish(Revision revision);
    <T extends Revision> List<T> revisions(Class<T> clazz);
}
