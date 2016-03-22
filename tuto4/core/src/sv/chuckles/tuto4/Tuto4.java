package sv.chuckles.tuto4;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tuto4 extends ApplicationAdapter {
	SpriteBatch batch;
	float stateTime;
	Animation aniIdle, aniWalk, aniRun;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		//carga de imaganes del descanso
		TextureRegion[] keyFramesIdle = {
				new TextureRegion(new Texture("idle/idle_1.png")),
				new TextureRegion(new Texture("idle/idle_2.png")),
				new TextureRegion(new Texture("idle/idle_3.png")),
				new TextureRegion(new Texture("idle/idle_4.png")),
				new TextureRegion(new Texture("idle/idle_5.png")),
				new TextureRegion(new Texture("idle/idle_6.png")),
				new TextureRegion(new Texture("idle/idle_7.png")),
				new TextureRegion(new Texture("idle/idle_8.png")),
				new TextureRegion(new Texture("idle/idle_9.png")),
				new TextureRegion(new Texture("idle/idle_10.png"))
		}; 
		aniIdle = new Animation(0.075f, keyFramesIdle);
		
		//carga de imaganes caminando
		TextureRegion[] keyFramesWalk = {
				new TextureRegion(new Texture("walk/walk_1.png")),
				new TextureRegion(new Texture("walk/walk_2.png")),
				new TextureRegion(new Texture("walk/walk_3.png")),
				new TextureRegion(new Texture("walk/walk_4.png")),
				new TextureRegion(new Texture("walk/walk_5.png")),
				new TextureRegion(new Texture("walk/walk_6.png")),
				new TextureRegion(new Texture("walk/walk_7.png")),
				new TextureRegion(new Texture("walk/walk_8.png")),
				new TextureRegion(new Texture("walk/walk_9.png")),
				new TextureRegion(new Texture("walk/walk_10.png"))
		}; 
		aniWalk = new Animation(0.075f, keyFramesWalk);		
		
		//carga de imagenes corriendo
		TextureRegion[] keyFramesRun = {
				new TextureRegion(new Texture("run/run_1.png")),
				new TextureRegion(new Texture("run/run_2.png")),
				new TextureRegion(new Texture("run/run_3.png")),
				new TextureRegion(new Texture("run/run_4.png")),
				new TextureRegion(new Texture("run/run_5.png")),
				new TextureRegion(new Texture("run/run_6.png")),
				new TextureRegion(new Texture("run/run_7.png")),
				new TextureRegion(new Texture("run/run_8.png"))
		}; 
		aniRun = new Animation(0.07f, keyFramesRun);		

		stateTime = 0;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		batch.begin();
		batch.draw(aniIdle.getKeyFrame(stateTime, true), 0, 0);
		batch.draw(aniWalk.getKeyFrame(stateTime, true), 0, 170);
		batch.draw(aniRun.getKeyFrame(stateTime, true), 0, 340);
		batch.draw(aniRun.getKeyFrame(stateTime, true), 600 //posicion en X
				,340 //posicion en Y
				,-aniRun.getKeyFrame(stateTime).getRegionWidth() //ancho de la imagen
				,aniRun.getKeyFrame(stateTime).getRegionHeight() //alto de la imagen
		);
		batch.end();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
	}
}
