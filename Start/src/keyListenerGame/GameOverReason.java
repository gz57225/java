package keyListenerGame;

public class GameOverReason {
	private String reason;
	private Snake participant1;
	private Snake participant2;
	
	public boolean isReal;
	
	public GameOverReason(String reason, Snake s1, Snake s2) {
		this.reason = reason;
		this.participant1 = s1;
		this.participant2 = s2;
		this.isReal = true;
	}
	
	public GameOverReason() {
		this.isReal = false;
	}
	
	public String toString() {
		return reason + " " + this.participant1.getName() + " " + this.participant2.getName();
	}
}
