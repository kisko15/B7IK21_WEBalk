package hu.me.iit.HaziElso;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import hu.me.iit.Enum.Kivitel;
import hu.me.iit.Enum.Uzemanyag;

public class AutoDto {
	
	@NotNull
	private int id;
	
	@NotNull
	@NotBlank
	private String gyarto;
	
	@NotNull
	@NotBlank
	private String modell;
	
	@NotNull
	@NotBlank
	@Max(6)
	private String rendszam;
	
	@NotNull
	private LocalDate gyartasiIdo;
	private String szin;
	private Kivitel kivitel;
	private int ajtokszama;
	private int ferohelyekszama;
	private String valtotipus;
	private Uzemanyag uzemanyagtipus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGyarto() {
		return gyarto;
	}
	public void setGyarto(String gyarto) {
		this.gyarto = gyarto;
	}
	public String getModell() {
		return modell;
	}
	public void setModell(String modell) {
		this.modell = modell;
	}
	public String getRendszam() {
		return rendszam;
	}
	public void setRendszam(String rendszam) {
		this.rendszam = rendszam;
	}
	public LocalDate getGyartasiIdo() {
		return gyartasiIdo;
	}
	public void setGyartasiIdo(LocalDate gyartasiIdo) {
		this.gyartasiIdo = gyartasiIdo;
	}
	public String getSzin() {
		return szin;
	}
	public void setSzin(String szin) {
		this.szin = szin;
	}
	public Kivitel getKivitel() {
		return kivitel;
	}
	public void setKivitel(Kivitel kivitel) {
		this.kivitel = kivitel;
	}
	public int getAjtokszama() {
		return ajtokszama;
	}
	public void setAjtokszama(int ajtokszama) {
		this.ajtokszama = ajtokszama;
	}
	public int getFerohelyekszama() {
		return ferohelyekszama;
	}
	public void setFerohelyekszama(int ferohelyekszama) {
		this.ferohelyekszama = ferohelyekszama;
	}
	public String getValtotipus() {
		return valtotipus;
	}
	public void setValtotipus(String valtotipus) {
		this.valtotipus = valtotipus;
	}
	public Uzemanyag getUzemanyagtipus() {
		return uzemanyagtipus;
	}
	public void setUzemanyagtipus(Uzemanyag uzemanyagtipus) {
		this.uzemanyagtipus = uzemanyagtipus;
	}
	
	public AutoDto(int id, String gyarto, String modell, String rendszam, LocalDate gyartasiIdo, String szin,
			Kivitel kivitel, int ajtokszama, int ferohelyekszama, String valtotipus, Uzemanyag uzemanyagtipus) {
		super();
		this.id = id;
		this.gyarto = gyarto;
		this.modell = modell;
		this.rendszam = rendszam;
		this.gyartasiIdo = gyartasiIdo;
		this.szin = szin;
		this.kivitel = kivitel;
		this.ajtokszama = ajtokszama;
		this.ferohelyekszama = ferohelyekszama;
		this.valtotipus = valtotipus;
		this.uzemanyagtipus = uzemanyagtipus;
	}
	
	@Override
	public String toString() {
		return "AutoDto [id=" + id + ", gyarto=" + gyarto + ", modell=" + modell + ", rendszam=" + rendszam
				+ ", gyartasiIdo=" + gyartasiIdo + ", szin=" + szin + ", kivitel=" + kivitel + ", ajtokszama="
				+ ajtokszama + ", ferohelyekszama=" + ferohelyekszama + ", valtotipus=" + valtotipus
				+ ", uzemanyagtipus=" + uzemanyagtipus + "]";
	}
}
