package rlp.footrix.protrix.box;

import rlp.footrix.protrix.ProtrixAppConfiguration;
import rlp.footrix.protrix.ProtrixApplication;

import java.time.Instant;

public class ProtrixBox extends AbstractBox {

	private ProtrixApplication application;

	public ProtrixBox(String[] args) {
		this(new ProtrixConfiguration(args));
	}

	public ProtrixBox(ProtrixConfiguration configuration) {
		super(configuration);
	}

	@Override
	public io.intino.alexandria.core.Box put(Object o) {
		super.put(o);
		return this;
	}

	public void beforeStart() {
		ProtrixAppConfiguration config = new ProtrixAppConfiguration();
		application = new ProtrixApplication(config);
		application.start();
	}

	public void afterStart() {
		application.setDate(Instant.parse("2025-08-01T00:00:00Z"));
	}

	public void beforeStop() {

	}

	public void afterStop() {

	}

	protected io.intino.alexandria.ui.services.AuthService authService(java.net.URL authServiceUrl) {
		//TODO add your authService
		return null;
	}

	public ProtrixApplication application() {
		return application;
	}
}