package sv.chuckles.tuto1;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tuto1 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		sprite = new Sprite(img);
		sprite.setPosition(200, 100);
		sprite.setScale(0.75f);
		sprite.setRotation(45);
	}

	@Override
	public void render () {
		float rotar = 5;
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		rotar += sprite.getRotation();
		if(rotar > 360) rotar = 5;
		sprite.setRotation(rotar);
		
		float dirX = Gdx.input.getAccelerometerY();
		float dirY = Gdx.input.getAccelerometerX();
		float x = sprite.getX();
		float y = sprite.getY();
		
		if(dirX == 0){
			if(Gdx.input.isKeyPressed(Keys.LEFT))
				x -= 5;
			else if(Gdx.input.isKeyPressed(Keys.RIGHT))
				x += 5;
		}else{
			if(dirX < 0)
				x -= 5;
			else
				x += 5;
		}
		if(dirY == 0){
			if(Gdx.input.isKeyPressed(Keys.UP))
				y += 5;
			else if(Gdx.input.isKeyPressed(Keys.DOWN))
				y -= 5;
		}else{
			if(dirY < 0)
				y += 5;
			else
				y -= 5;
		}
		if(x < 0) x=0;
		if(y < 0) y=0;
		if(x>Gdx.graphics.getWidth()) x=Gdx.graphics.getWidth();
		if(y>Gdx.graphics.getHeight()) y=Gdx.graphics.getHeight();
		sprite.setPosition(x, y);
		sprite.draw(batch);
		batch.end();
	}
}
