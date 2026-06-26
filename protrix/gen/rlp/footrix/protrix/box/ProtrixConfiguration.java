package rlp.footrix.protrix.box;

import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class ProtrixConfiguration extends io.intino.alexandria.core.BoxConfiguration {

	public ProtrixConfiguration(String[] args) {
		super(args);
	}

	public String port() {
		return get("port");
	}

	public java.io.File home() {
		return new java.io.File(args.getOrDefault("home", System.getProperty("user.home")));
	}
}