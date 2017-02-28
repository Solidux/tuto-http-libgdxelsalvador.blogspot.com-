package sv.com.chuckle.game.spaceinvaderclon;

import com.badlogic.gdx.Game;

import sv.com.chuckle.game.spaceinvaderclon.screen.MainScreen;

public class GameLoop extends Game {

	@Override
	public void create() {
		setScreen(new MainScreen(this));
	}
}
