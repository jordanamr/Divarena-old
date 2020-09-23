package org.divarena.logging;

import ch.qos.logback.classic.PatternLayout;

public class Xterm256PatternLayout extends PatternLayout {

	static {
		PatternLayout.defaultConverterMap.put("highlightLevel", Xterm256HighlightingCompositeConverter.class.getName());
	}
}
