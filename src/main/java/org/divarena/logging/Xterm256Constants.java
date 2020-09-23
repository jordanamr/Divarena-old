package org.divarena.logging;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class Xterm256Constants {
	
	public final static Marker HIGHLIGHT = MarkerFactory.getMarker("HIGHLIGHT");

	public final static String ESC_START = "\033[";
	public final static String ESC_END = "m";
	public final static String BOLD = "1;";
	public final static String START_256_FG = "38;5;";
	public final static String START_256_BG = "48;5;";
	public final static String START_8_FG = "3";
	public final static String START_8_BG = "4";

	public final static String DEFAULT_FG = "39";
	public final static String DEFAULT_BG = "49";

	public final static String BLACK_FG = "30";
	public final static String RED_FG = "31";
	public final static String GREEN_FG = "32";
	public final static String YELLOW_FG = "33";
	public final static String BLUE_FG = "34";
	public final static String MAGENTA_FG = "35";
	public final static String CYAN_FG = "36";
	public final static String WHITE_FG = "37";
}
