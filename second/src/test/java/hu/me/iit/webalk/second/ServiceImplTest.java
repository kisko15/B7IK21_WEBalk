package hu.me.iit.webalk.second;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServiceImplTest {
	
	@Mock Dependency dependency;
	
	@InjectMocks ServiceImpl service;

	@Test
	void testCalculate() {
		//GIVEN
		
		//WHEN
		service.calculate();
		
		//THEN
		verify(dependency, times(1)).helpNoParameterNoReturnValue();
	}
	
	@Test
	void return5() {
		//GIVEN
		final int FIVE = 5;
		
		//WHEN
		int result = service.return5();
		
		//THEN
		assertEquals(FIVE, result);
	}
	
	@Test
	void dependencyReturnValueIsUsed() {
		//GIVEN
		final int FIVE = 5;
		
		when(dependency.helpNoParameterReturnValue()).thenReturn(FIVE);
		
		//WHEN
		int result = service.callHelpAndUseReturnValue();
		
		//THEN
		verify(dependency, times(1)).helpNoParameterReturnValue();
		assertEquals(FIVE, result);
	}
	
	@Test
	void dependencyCaptorCall() {
		//GIVEN
		final int FIVE = 5;
		
		//WHEN
		service.callHelpAndPassParameter5();
		
		//THEN
		ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
		
		verify(dependency, times(1)).helpWithParameterNoReturnValue(captor.capture());
		assertEquals(FIVE, captor.getValue());
	}
	
	

}
