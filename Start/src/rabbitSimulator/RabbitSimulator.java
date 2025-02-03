package rabbitSimulator;

public class RabbitSimulator {
	private int adults;
	private int children;
	
	public RabbitSimulator() {
		this.adults = 0;
		this.children = 1;
	}

	public void advanceYear() {
		int previous_children = children;
		children = adults;
		adults += previous_children;
	}
	
	public int getRabbits() {
		return adults + children;
	}
	
	public String toString() {
		return "pairs of adults: " + adults + ". pairs of babies: " + children + ". pairs of all: " + getRabbits();
	}
}
