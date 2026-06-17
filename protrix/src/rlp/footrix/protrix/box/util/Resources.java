package rlp.footrix.protrix.box.util;

import io.intino.alexandria.Resource;
import io.intino.alexandria.logger.Logger;

import java.net.URL;

public class Resources {

    public static URL goalIconPath() {
        return Resources.class.getResource("/icons/goal.png");
    }

    public static URL substitutionIconPath() {
        return Resources.class.getResource("/icons/substitution.png");
    }

    public static URL yellowCardIconPath() {
        return Resources.class.getResource("/icons/yellow-card.png");
    }

    public static URL redCardIconPath() {
        return Resources.class.getResource("/icons/red-card.png");
    }

    public static URL injury1IconPath() {
        return Resources.class.getResource("/icons/injury-1.png");
    }

    public static URL injury2IconPath() {
        return Resources.class.getResource("/icons/injury-2.png");
    }

    public static URL injury3IconPath() {
        return Resources.class.getResource("/icons/injury-3.png");
    }

    public static byte[] getBytes(Resource resource) {
        return getBytes(resource, false);
    }

    public static byte[] getBytes(Resource resource, boolean showLog) {
        try {
            return resource.bytes();
        } catch (Throwable e) {
            if (showLog) Logger.error(e);
        }
        return new byte[0];
    }
}
