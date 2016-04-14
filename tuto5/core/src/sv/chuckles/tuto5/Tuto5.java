package sv.chuckles.tuto5;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.BufferUtils;
import com.badlogic.gdx.utils.ScreenUtils;

public class Tuto5 extends ApplicationAdapter implements GestureListener {
	SpriteBatch batch;
	Sprite sprite;
	OrthographicCamera camera;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		sprite = new Sprite(new Texture("dbs_2048x1152.jpg"));
		sprite.setPosition(-sprite.getWidth()/2,-sprite.getHeight()/2);
		
		camera = new OrthographicCamera(800, 400);
		
		 Gdx.input.setInputProcessor(new GestureDetector(this));
	}

	@Override
	public void render () {
		camera.update();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		batch.end();
		
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			camera.zoom += 0.02;
        }
		if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
			camera.zoom -= 0.02;
        }
	}
	
	@Override
	public void dispose() {
		Gdx.app.log("Tuto5", "Entra al dispose");
		batch.dispose();
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		Gdx.app.log("longPress", "Screenshot inicia proceso");
		byte[] pixels = ScreenUtils.getFrameBufferPixels(0, 0, Gdx.graphics.getBackBufferWidth(), Gdx.graphics.getBackBufferHeight(), true);

		Pixmap pixmap = new Pixmap(Gdx.graphics.getBackBufferWidth(), Gdx.graphics.getBackBufferHeight(), Pixmap.Format.RGBA8888);
		BufferUtils.copy(pixels, 0, pixmap.getPixels(), pixels.length);
		PixmapIO.writePNG(Gdx.files.external("miPantallazo.png"), pixmap);
		pixmap.dispose();
		
		Gdx.input.vibrate(1000);
		Gdx.app.log("longPress", "Screenshot tomada");
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		camera.translate(-deltaX,deltaY);
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		return false;
	}
}
