package sv.chuckles.tuto6;

import com.badlogic.gdx.Game;

public class Tuto6 extends Game {

	@Override
	public void create() {
		setScreen(new GameScreen(this));
	}
	
}
