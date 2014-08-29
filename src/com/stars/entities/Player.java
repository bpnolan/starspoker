package com.stars.entities;

import com.stars.displays.*;
import java.util.UUID;


public class Player {

	public String playerId;
	public String player;
	public StackDisplay stack;
	public BetDisplay bet;
	
	public Player(String name) {
		playerId = UUID.randomUUID().toString();
		player = name;
		stack = new StackDisplay(player);
		bet = new BetDisplay(player);
	}
	
	public void bet(String amount) {
		double currentVal = stack.getValue();
		double betVal = Double.parseDouble(amount);
		
		stack.setValue(currentVal-betVal);
		bet.setValue(betVal);
		bet.showDisplay();		
	}
	
	public void raise(String raiseAmount, String total) {
		double currentVal = stack.getValue();
		double raiseVal = Double.parseDouble(raiseAmount);
		double betVal = Double.parseDouble(total);
		
		stack.setValue(currentVal-raiseVal);
		bet.setValue(betVal);
	}
	
	public void fold() {
		//bet.stopDisplay();
	}
	
	public void clearBetDisplay() {
		bet.stopDisplay();
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
	
	
	
}
