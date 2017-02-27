package sv.com.chuckle.game.spaceinvaderclon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameLoop extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img,img2,img3;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("alien.png");
		img2 = new Texture("Starfighter.png");
		img3 = new Texture("missile.png");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.draw(img2, 100, 0);
		batch.draw(img3,200,0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		img2.dispose();
		img3.dispose();
	}
}
