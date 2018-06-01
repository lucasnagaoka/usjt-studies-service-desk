package templatemethod.manipulator;

/**
 * 
 * @author Lucas Nagaoka | RA: 81513916
 *
 */
public class ManipuladorMaiusculo extends ManipuladorAbstrato {

	protected String transformarString(String string) {
		return string.toUpperCase();
	}
}
