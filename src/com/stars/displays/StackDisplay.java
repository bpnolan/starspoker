package com.stars.displays;

public class StackDisplay extends Display {

	public final String player;
	
	public StackDisplay(String player) {
		this.player = player;
	}
	
	
	
	@Override
	public void showDisplay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopDisplay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDisplay() {
		// TODO Auto-generated method stub
		System.out.println(player + " stack size: " + value);
	}
	

}
