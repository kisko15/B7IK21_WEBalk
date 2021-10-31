package hu.me.iit.AutoConsoleApplication.impl;

import hu.me.iit.AutoConsoleApplication.Motor;

public class Villanymotor implements Motor{

	private final int teljesitmeny;
	private final int feszultseg;
	
	public Villanymotor(int teljesitmeny, int feszultseg) {
		super();
		this.teljesitmeny = teljesitmeny;
		this.feszultseg = feszultseg;
	}
	@Override
	public String toString() {
		return "VillanyMotor [teljesítmény=" + teljesitmeny + ", feszultseg=" + feszultseg + "]";
	}
}
