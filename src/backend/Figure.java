package backend;

import backend.element.*;
import backend.element.HorizontalStrippedCandy;

import java.awt.Point;

public enum Figure {
	
	F6(new Point[]{ new Point(0,-2), new Point(0,-1), new Point(0,1), new Point(0,2)}, 240, Bomb.class, false),
	F15(new Point[]{ new Point(-2,0), new Point(-1,0), new Point(1,0), new Point(2,0)}, 15, Bomb.class, false),	
	F4(new Point[]{ new Point(0,-1), new Point(0,1), new Point(0,2)}, 112,  VerticalStrippedCandy.class),
	F5(new Point[]{ new Point(0,-2), new Point(0,-1), new Point(0,1)}, 208, VerticalStrippedCandy.class),
	F13(new Point[]{ new Point(-1,0), new Point(1,0), new Point(2,0)}, 13,  HorizontalStrippedCandy.class),
	F14(new Point[]{ new Point(-2,0), new Point(-1,0), new Point(1,0)}, 7, HorizontalStrippedCandy.class),
	F7(new Point[]{ new Point(0,1), new Point(0,2), new Point(1,0), new Point(2,0)}, 60, WrappedCandy.class),
	F8(new Point[]{ new Point(0,-1), new Point(0,1), new Point(1,0), new Point(2,0)}, 92, WrappedCandy.class),
	F9(new Point[]{ new Point(0,-2), new Point(0,-1), new Point(1,0), new Point(2,0)}, 204, WrappedCandy.class),
	F16(new Point[]{ new Point(-1,0), new Point(1,0), new Point(0,1), new Point(0,2)}, 53, WrappedCandy.class),
	F17(new Point[]{ new Point(-2,0), new Point(-1,0), new Point(0,1), new Point(0,2)}, 51, WrappedCandy.class),
	F18(new Point[]{ new Point(-2,0), new Point(-1,0), new Point(0,-1), new Point(0,-2)}, 195, WrappedCandy.class),
	F19(new Point[]{ new Point(-2,0), new Point(-1,0), new Point(0,-1), new Point(0,1)}, 83, WrappedCandy.class),
	F20(new Point[]{ new Point(-1,0), new Point(1,0), new Point(0,-2), new Point(0,-1)}, 197, WrappedCandy.class),
	F1(new Point[]{new Point(0,1), new Point(0,2)}, 48),
	F2(new Point[]{new Point(0,-1), new Point(0,1)}, 80),
	F3(new Point[]{new Point(0,-1), new Point(0,-2)}, 192),
	F10(new Point[]{ new Point(1,0), new Point(2,0)}, 12),	
	F11(new Point[]{ new Point(-1,0), new Point(1,0)}, 5),	
	F12(new Point[]{ new Point(-2,0), new Point(-1,0)}, 3);
	
	
	private Point[] points;
	private int value;
	private Class<?> replacementClass;
	private boolean isCandyRepl = true;
	
	private Figure(Point[] points, int value, Class<?> replacementClass) {
		this.points = points;
		this.value = value;
		this.replacementClass = replacementClass;
	}
	
	private Figure(Point[] points, int value, Class<?> replacementClass, boolean isCandyRepl) {
		this.points = points;
		this.value = value;
		this.replacementClass = replacementClass;
		this.isCandyRepl = isCandyRepl;
	}
	
	private Figure(Point[] points, int value) {
		this.points = points;
		this.value = value;
		this.replacementClass = null;
	}
	
	public Point[] getPoints() {
		return points;
	}
	
	public int size() {
		return points.length;
	}
	
	public Class<?> getReplacementClass() {
		return replacementClass;
	}
	
	public boolean hasReplacement() {
		return replacementClass != null;
	}
	
	public boolean matches(int acum) {
		return value == (value & acum);
	}
	
	public Element generateReplacement(CandyColor color) {
		try {
			Element e;
			e = (Element) replacementClass.newInstance();
			if (isCandyRepl) {
				((Candy)e).setColor(color);
			} 
			return e;
		} catch(Exception e) {
		}
		return null;
	}	
}
