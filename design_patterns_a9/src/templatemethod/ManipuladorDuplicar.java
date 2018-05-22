package templatemethod;

/**
 * 
 * @author Lucas Nagaoka | RA: 81513916
 *
 */
public class ManipuladorDuplicar extends ManipuladorAbstrato {

	protected String transformarString(String string) {
		return string + " " + string;
	}
}
