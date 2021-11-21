package hu.me.iit.webalk.second;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceImpl implements Service {

	private final Dependency dependency;
	private String value;

    @Value("${sajat-cucc}")
    public void setValue(String value) {
        this.value = value;
    }
	
	public ServiceImpl(Dependency dependency) {
		this.dependency = dependency;
	}
	
	@Override
	public void calculate() {
		
		dependency.helpNoParameterNoReturnValue();
	}

	public int return5() {
		return 5;
	}

	public int callHelpAndUseReturnValue() {	
		return dependency.helpNoParameterReturnValue();
	}
	
	public void callHelpAndPassParameter5() {
		dependency.helpWithParameterNoReturnValue(5);
	}

	@Override
	public String getValue() {
		return value;
	}
	
	
}
