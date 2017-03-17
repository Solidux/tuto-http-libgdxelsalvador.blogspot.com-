package sv.com.chuckle.game.spaceinvaderclon;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import sv.com.chuckle.game.spaceinvaderclon.screen.MainScreen;
import sv.com.chuckle.game.spaceinvaderclon.utils.Asset;

public class GameLoop extends Game {

	public GameLoop(){

	}

	@Override
	public void create() {
		setScreen(new MainScreen(this));
	}

	@Override
	public void render() {
		getScreen().render(Gdx.graphics.getDeltaTime());
	}
}
