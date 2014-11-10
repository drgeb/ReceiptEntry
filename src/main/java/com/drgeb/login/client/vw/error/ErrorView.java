package com.drgeb.login.client.vw.error;

/**
 *
 * @author Dr. Gerald E. Bennett
 * 
 **/

import java.util.function.Function;
import com.airhacks.afterburner.views.FXMLView;

public class ErrorView extends FXMLView {
	public ErrorView() {
	}

	public ErrorView(Function<String, Object> injectionContext) {
		super(injectionContext);
	}
}
