package sv.chuckles.tuto6;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen{
	private Tuto6 game;
	private BitmapFont bitmapFont;
	private SpriteBatch batch;
	private String texto;
	private boolean isRetorno;
	
	public GameScreen(Tuto6 game){
		this.game = game;
		batch = new SpriteBatch();
		bitmapFont = new BitmapFont();	
		isRetorno = false;
	}

	@Override
	public void show() {
		bitmapFont.setColor(Color.GOLD);
		if(!isRetorno)
			texto = "Presione sobre la pantalla";
		else
			texto = "Presione sobre la pantalla, para salir";
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.4f, 0.4f, 0.4f, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		bitmapFont.draw(batch, 
				"Pantalla: GameScreen\n"+texto, 
				Gdx.graphics.getWidth()/2-90, 
				Gdx.graphics.getHeight()/2+50);
		batch.end();
		
		if(Gdx.input.justTouched()){
			if(!isRetorno){
				game.setScreen(new SecondScreen(game,this));
				isRetorno = true;
			}else
				Gdx.app.exit();
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
		if(isRetorno)
			dispose();
	}

	@Override
	public void dispose() {
		Gdx.app.log("GameScreen", "Entra al dispose");
		batch.dispose();
		bitmapFont.dispose();
	}
}
