package model;

public class Players {
	public Player first;
	public Player last;
	private int size;
	
	public Players(int amount) {
		first = new Player ((char) 33);
		first.setTurn(true);
		size = 1;
		Player aux = first;
		addPlayers(amount, aux);
	}
	
	public Players(int amount, String names) {
		first = new Player ((char) names.charAt(amount-1));
		first.setTurn(true);
		size = 1;
		Player aux = first;
		addPlayers(amount-2, aux, names);
	}
	
	public void addPlayers(int amount, Player aux, String names) {
		if(amount >= 0) {
			aux.setNext(new Player((char) (names.charAt(amount))));
			size++;
			amount--;
			addPlayers(amount,aux.getNext());
		}else {
			last = aux;
			last.setNext(first);
		}
	}
	
	public String stringPlayers() {
		String pstr = "";
		pstr = getPlayersIcons(size-1, pstr);
		return pstr;
	}
	
	public String getPlayersIcons(int s, String ps) {
		if(s >= 0) {
			ps += get(s).getIcon();
			s--;
			getPlayersIcons(s,ps);
		}
		return ps;
	}
	
	public Player get(int pos) {
		Player p = null;
		if(pos < size) {
			p = getPlayer(pos, first);
		}
		return p;
	}
	
	public Player getPlayer(int a, Player aux) {
		if(a > 0) {
			a--;
			aux = getPlayer(a, aux.getNext());
		}
		return aux;
	}
	public void addPlayers(int amount, Player aux) {
		if(amount > 0) {
			aux.setNext(new Player((char) (33 + amount)));
			size++;
			amount--;
			addPlayers(amount,aux);
		}else {
			last = aux;
			last.setNext(first);
		}
	}
	/*public String getPlayers() {
		String players = "";
		getPlayer(first);
		return players;
	}
	public String getPlayer(Player tem) {
		if(playersToReturn.equals("")) {
			playersToReturn += tem.getIcon();
			getPlayer(tem.getNext());
		}else if(play)
		
		return playersToReturn;
	}*/

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public Player getFirst() {
		return first;
	}

	public void setFirst(Player first) {
		this.first = first;
	}

	public Player getLast() {
		return last;
	}

	public void setLast(Player last) {
		this.last = last;
	}
	
	
}
