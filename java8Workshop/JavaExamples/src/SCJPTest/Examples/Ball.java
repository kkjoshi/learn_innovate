package SCJPTest.Examples;

public class Ball extends BouncingThing implements IBouncable {
	int bollBouncedCount = 60;
	private int bollBouncedCount1 = 61;
	@Override
	public int getBounceCount() {
		// TODO Auto-generated method stub
		return bollBouncedCount+super.getBounceCount();
	}


}
