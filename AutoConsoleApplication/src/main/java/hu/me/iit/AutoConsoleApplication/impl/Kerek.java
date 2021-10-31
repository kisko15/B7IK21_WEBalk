package hu.me.iit.AutoConsoleApplication.impl;

public class Kerek implements hu.me.iit.AutoConsoleApplication.Kerek {
	
	private final int szelesseg;
	private final int atmero;
	private final int kopenyMagassag;
	
	public Kerek(int szelesseg, int atmero, int kopenyMagassag) {
		super();
		this.szelesseg = szelesseg;
		this.atmero = atmero;
		this.kopenyMagassag = kopenyMagassag;
	}
	@Override
	public String toString() {
		return "Kerek [" + szelesseg + "/" + kopenyMagassag + " R " + atmero + "]";
	};
}
