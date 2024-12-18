package rlp.footrix.protrix.box;

public class Main {
	public static void main(String[] args) {
		ProtrixBox box = new ProtrixBox(args);
		box.start();
		Runtime.getRuntime().addShutdownHook(new Thread(box::stop));
	}
}