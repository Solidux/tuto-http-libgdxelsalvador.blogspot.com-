package sv.chuckles.tuto6;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class SecondScreen implements Screen {
	private Tuto6 game;
	private BitmapFont bitmapFont;
	private SpriteBatch batch;
	private GameScreen gameScreen;
	
	public SecondScreen(Tuto6 game,GameScreen gameScreen) {
		this.game = game;
		this.gameScreen = gameScreen;
		batch = new SpriteBatch();
		bitmapFont = new BitmapFont();	
	}

	@Override
	public void show() {
		bitmapFont.setColor(Color.RED);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		bitmapFont.draw(batch, 
				"Pantalla: SecondScreen\nPresione sobre la pantalla,\npara regresar a la pantalla anterior", 
				Gdx.graphics.getWidth()/2-90, 
				Gdx.graphics.getHeight()/2+50);
		batch.end();
		
		if(Gdx.input.justTouched()){
			game.setScreen(gameScreen);
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void dispose() {
		Gdx.app.log("SecondScreen", "Entra al dispose");
		batch.dispose();
		bitmapFont.dispose();
	}

}
