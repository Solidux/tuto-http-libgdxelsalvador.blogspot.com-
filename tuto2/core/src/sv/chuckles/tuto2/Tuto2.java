package sv.chuckles.tuto2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tuto2 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Sound sonido;
	Music musica;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		
		Gdx.app.log("Tuto2", "Inicia el programa.");
		sonido = Gdx.audio.newSound(Gdx.files.internal("explosion.wav"));
		musica = Gdx.audio.newMusic(Gdx.files.internal("fight.wav"));
		musica.setLooping(true);
		musica.setVolume(0.2f);
		musica.play();
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(Gdx.input.justTouched()){
			sonido.play();
			Gdx.app.log("Tuto2", "Touch(X,Y):("+Gdx.input.getX()+","+Gdx.input.getY()+")");
		}
			
		batch.begin();
		batch.draw(img,//logo libgdx
				Gdx.graphics.getWidth()/2-img.getWidth()/2,//posicion en X Centrada 
				Gdx.graphics.getHeight()/2-img.getHeight()/2//posicion en Y Centrada
		);
		batch.end();
	}
	
	@Override
	public void resize(int width, int height) {
		Gdx.app.log("Tuto2", "Resolucion: "+Gdx.graphics.getWidth()+"x"+Gdx.graphics.getHeight());
	}

	@Override
	public void pause() {
		Gdx.app.log("Tuto2", "Entro en pausa.");
		musica.pause();
	}

	@Override
	public void resume() {
		Gdx.app.log("Tuto2", "Entro en resumen.");
		musica.play();
	}

	@Override
	public void dispose() {
		Gdx.app.log("Tuto2", "Entro en dispose.");
		img.dispose();
		batch.dispose();
		musica.dispose();
		sonido.dispose();
	}
}
