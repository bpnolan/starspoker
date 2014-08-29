package com.stars.entities;

import java.util.List;

import com.stars.displays.PotDisplay;
import com.stars.utils.DealerChatParser;
import com.stars.utils.PlayerActions;

public class Table {

	public double bbVal;
	public List<Player> players;
	public List<Double> bets;
	public PotDisplay pot;
	DealerChatParser parser;
	
	public Table() {
		parser = new DealerChatParser();
	}
	public void serviceAction() {
		parser.receiveChat("TEST STRING");
		
		if(parser.isNewStreet()) {
			this.updatePot();
		}else if(parser.getPlayer(players) != null) {
			
			Player play = parser.getPlayer(players);
			PlayerActions action = parser.getPlayerAction();
			
			
			
		}
	}
	
	// when stakes are known, i.e. blind chat is posted, application can then display bets in BBs
	public void establishStakes(double val) {
		bbVal = val;
		
	}
	
	//method called at the end of each street
	public void updatePot() {
		double totalStreetBets = 0;
		for(Double bet : bets) {
			totalStreetBets = totalStreetBets + bet;
		}
		
		pot.setValue(pot.getValue() + totalStreetBets);
		
		for(Player player : players) {
			player.clearBetDisplay();
		}
	}
	
	private void playerBet(String playerName, String amount) {
		
		for(Player player : players) {
			if(playerName.equals(player.getPlayer())) {
				player.bet(amount);
				bets.add(Double.parseDouble(amount));
			}
		}
	}
	
	private void playerRaise(String playerName, String amount, String total) {
		
		for(Player player : players) {
			if(playerName.equals(player.getPlayer())) {
				player.raise(amount, total);
				bets.add(Double.parseDouble(amount));
			}
		}
	}
	
	private void playerFold(String playerName) {
		for(Player player : players) {
			if(playerName.equals(player.getPlayer())) {
				player.fold();
			}
		}
	}
	
	private void returnUncalledBet(String playerName, String amount) {
		for(Player player : players) {
			if(playerName.equals(player.getPlayer())) {
				
			}
		}
	}
	
	
}
