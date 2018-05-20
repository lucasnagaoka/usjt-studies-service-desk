package abstractfactory;

/**
 * 
 * @author Lucas Nagaoka | RA: 81513916
 *
 */
public interface AbstractPrinterFactory {
	TextPrinter getPrinterInstance(String printerType);

}
