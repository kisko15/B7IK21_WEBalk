package hu.me.iit.webalk.second;

import org.springframework.stereotype.Component;

@Component
public class DependencyImpl implements Dependency{

	@Override
	public void helpNoParameterNoReturnValue() {	
		
	}

	@Override
	public int helpNoParameterReturnValue() {
	
		return 45;
	}

	@Override
	public void helpWithParameterNoReturnValue(int a) {
	
	}

}
