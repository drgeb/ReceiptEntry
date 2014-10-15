package com.drgeb.receiptentry.vw.entry;

import java.util.function.Function;
import com.airhacks.afterburner.views.FXMLView;

public class EntryView extends FXMLView {
	
	public EntryView(Function <String,Object> injectionContext) {
		super(injectionContext);
	}
}
