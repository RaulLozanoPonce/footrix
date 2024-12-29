package rlp.footrix.framework.var;

import java.util.List;

public class VarTerminal {
    private static Var var;

    public static void var(Var var) {
        VarTerminal.var = var;
    }

    public static void publish(Revision revision) {
        var.publish(revision);
    }

    public static <T extends Revision> List<T> revisions(Class<T> clazz) {
        return var.revisions(clazz);
    }
}
