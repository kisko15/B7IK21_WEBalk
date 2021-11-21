package hu.me.iit.webalk.second;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	private final Service service;

	@Autowired
	 public MainController(Service service) {
        this.service = service;
    }
	
	 @ResponseBody
	 @GetMapping("/a")
	 public String getARoot() {
		 return service.getValue();
	 }
		
}
