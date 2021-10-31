package hu.me.iit.AutoConsoleApplication.impl;

public class BelsoEgesuMotor implements hu.me.iit.AutoConsoleApplication.Motor {
	
	private final int loero;
	private final int ccm;
	
	public BelsoEgesuMotor(int loero, int ccm) {
		super();
		this.loero = loero;
		this.ccm = ccm;
	}
	
	@Override
	public String toString() {
		return "Motor [loero=" + loero + ", ccm=" + ccm + "]";
	}
}
