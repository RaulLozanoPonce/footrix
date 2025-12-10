package rlp.footrix.protrix.box;

import io.intino.magritte.framework.stores.FileSystemStore;
import rlp.footrix.protrix.model.ProtrixGraph;

import java.io.File;

public class Main {
	public static void main(String[] args) {
		ProtrixBox box = new ProtrixBox(args);
        FileSystemStore store = new FileSystemStore(new File("./temp/"));
        ProtrixGraph graph = ProtrixGraph.load(store);
        box.put(graph);
        box.start();
		Runtime.getRuntime().addShutdownHook(new Thread(box::stop));
	}
}