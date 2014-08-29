package com.stars.utils;

import java.util.ArrayList;
import java.util.List;

import com.stars.entities.Player;

public class DealerChatParser {

	private final String newLineChar = "\n";
	List<String> statements;
	private String currentStatement;
	
	public DealerChatParser() {
		statements = new ArrayList<String>();		
	}
	
	//method takes in copy/pasted dealer chat from script, parses it
	public void receiveChat(String chatBuffer) {
		String[] lines = chatBuffer.split(newLineChar);
		currentStatement = lines[lines.length-1];
	}	
		
	public Player getPlayer(List<Player> players) {
		Player player = null;
		for(Player play : players) {
			if(currentStatement.contains(play.getPlayer())) player = play;
		}		
		return player;
	}
	
	public PlayerActions getPlayerAction() {
		PlayerActions action = PlayerActions.nothing;
		if(currentStatement.contains(Keywords.folds.toString())) action = PlayerActions.fold;		
		if(currentStatement.contains(Keywords.bets.toString())) action = PlayerActions.bet;
		if(currentStatement.contains(Keywords.calls.toString())) action = PlayerActions.calls;
		if(currentStatement.contains(Keywords.raises.toString())) action = PlayerActions.raise;
				
		return action;
	}
	
	public double getBetAmount() {
		double betAmount = 0;
		String[] words = currentStatement.split(" ");
		for(int i = 0; i<words.length; i++) {
			try{
				betAmount = Double.parseDouble(words[i]);
			}catch(NumberFormatException e) {
				
			}
		}
		return betAmount;
	}
	
	public boolean isNewStreet() {
		boolean newStreet = false;
		if(currentStatement.contains(Keywords.Dealing.toString())) newStreet = true;
		
		return newStreet;
	}
}
