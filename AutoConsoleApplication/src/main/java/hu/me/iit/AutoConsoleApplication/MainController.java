package hu.me.iit.AutoConsoleApplication;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.me.iit.AutoConsoleApplication.impl.BelsoEgesuMotor;

@RestController
@RequestMapping(path= "/auto")
public class MainController {

	private Motor motor16 = new BelsoEgesuMotor(180, 1600);
	private Auto opelAstra = new Auto(motor16,get4kerek(),"Opel Astra");
		
	@GetMapping(path= "", produces = MediaType.APPLICATION_JSON_VALUE)
	String allArticles() {
		return opelAstra.toString();
	}	

	public static Kerek[] get4kerek() {
		Kerek[] kerekek = new Kerek[4];
		
		for (int i = 0; i < kerekek.length; i++) {
			kerekek[i] = new hu.me.iit.AutoConsoleApplication.impl.Kerek(205, 15, 65);
		}
		return kerekek;

	}

}
