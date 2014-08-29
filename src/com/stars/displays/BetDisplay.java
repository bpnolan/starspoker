package com.stars.displays;

public class BetDisplay extends Display {

	public final String playerID;
	
	public BetDisplay(String player) {
		this.playerID = player;
	}
	
	@Override
	public void showDisplay() {
		// TODO Auto-generated method stub
		// METHOD SHOULD TURN ACTUAL DISPLAY ON / OFF
		System.out.println(playerID + " bet display enabled");
	}

	@Override
	public void stopDisplay() {
		// TODO Auto-generated method stub
		System.out.println(playerID + " bet display cleared");
	}

	@Override
	public void updateDisplay() {
		// TODO Auto-generated method stub
		System.out.println(playerID + " bet size: " + value);
	}
	

}
