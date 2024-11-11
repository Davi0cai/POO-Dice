package tecinfo.poo.model;

public class Player {
	private long id;
	private long wins;

	public Player(){
	}

	public Player(long id){
		this.id = id;
	} // Good thing I made this

	public Player(long id, long wins){
		this.id = id;
		this.wins = wins;
	}

	public long getId() {
		return id;
	}

	public long getWins() {
		return wins;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setWins(long wins) {
		this.wins = wins;
	}

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((wins == null) ? 0 : wins.hashCode());
		return result;
	}*/

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (id != other.id)
			return false;
		if (wins != other.wins)
			return false;
		return true;
	}
	
}