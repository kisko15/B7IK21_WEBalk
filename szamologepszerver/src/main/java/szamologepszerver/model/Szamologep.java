package szamologepszerver.model;

public class Szamologep {
	public double calculate(Double a, Double b, String operator) {
		if ("+".equals(operator)) {
			return a + b;
		} else if ("-".equals(operator)) {
			return a - b;
		} else 	if ("*".equals(operator)) {
			return a * b;
		} else 	if ("/".equals(operator)) {
			return a / b;
		} else throw new NotSupportedOperationException();
	}
}
