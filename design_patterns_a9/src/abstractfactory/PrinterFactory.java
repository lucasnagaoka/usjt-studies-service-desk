package abstractfactory;

/**
 * 
 * @author Lucas Nagaoka | RA: 81513916
 *
 */
public class PrinterFactory implements AbstractPrinterFactory {

	@Override
	public TextPrinter getPrinterInstance(String printerType) {
		switch (printerType) {
		case "FILEPRINT": return new FilePrintTextPrinter();
		case "SCREENPRINT": return new ScreenPrintTextPrinter();
		}

		return null;
	}

}
