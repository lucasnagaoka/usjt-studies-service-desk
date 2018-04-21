package abstractfactory;

/**
 * 
 * @author Lucas Nagaoka | RA: 81513916
 *
 */
public class ScreenPrintTextPrinter implements TextPrinter {

	@Override
	public void print() {
		System.out.println("Screen Print");
	}

}
