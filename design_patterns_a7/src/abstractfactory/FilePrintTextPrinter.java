package abstractfactory;

/**
 * 
 * @author Lucas Nagaoka | RA: 81513916
 *
 */
public class FilePrintTextPrinter implements TextPrinter {

	@Override
	public void print() {
		System.out.println("File Print");
	}

}
