package com.stars.displays;

public abstract class Display {

	public double value;
	public double bbVal;
	public abstract void showDisplay();
	public abstract void stopDisplay();
	public abstract void updateDisplay();
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
		this.updateDisplay();
	}
	
}
