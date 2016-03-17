package sv.chuckles.tuto3;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;

public class Tuto3 extends ApplicationAdapter {
	SpriteBatch batch;
	Sprite sprite1,sprite2,sprite3;
	Rectangle rec1,rec2;
	Circle cir1,cir3;
	
	ShapeRenderer renderer = null;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		sprite1 = new Sprite(new Texture("badlogic.jpg"));
		sprite2 = new Sprite(new Texture("badlogic.jpg"));
		sprite3 = new Sprite(new Texture("badlogic.jpg"));
		
		sprite1.setPosition(Gdx.graphics.getWidth()/2-sprite1.getWidth()/2, Gdx.graphics.getHeight()-sprite1.getHeight()-50);
		rec1 = new Rectangle(sprite1.getX(), sprite1.getY(), sprite1.getWidth(), sprite1.getHeight());
		cir1 = new Circle(sprite1.getX()+sprite1.getWidth()/2, sprite1.getY()+sprite1.getWidth()/2, 50f);
		
		sprite2.setColor(Color.BLUE);
		rec2 = new Rectangle(0, 0, sprite2.getWidth(), sprite2.getHeight());
		
		sprite3.setPosition(Gdx.graphics.getWidth()-sprite3.getWidth(),0);
		sprite3.setColor(Color.MAGENTA);
		cir3 = new Circle(0, 0, 50f);
		//Instancia para dibujar la figuras matematicas
		//comentarias esta linea si no se quiere ver los rectangulos y circulos dibujados
		renderer = new ShapeRenderer();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		detectarMovimiento(sprite2,false);
		detectarMovimiento(sprite3,true);
		
		detectarColisiones();

		//pintado de las imagenes en la pantalla
		batch.begin();
		sprite1.draw(batch);
		sprite2.draw(batch);
		sprite3.draw(batch);
		batch.end();
		
		if(renderer != null){
			renderer.begin(ShapeType.Line);
			renderer.setColor(Color.GOLD);
			renderer.rect(rec1.getX(), rec1.getY(), rec1.getWidth(), rec1.getHeight());
			renderer.circle(cir1.x, cir1.y, cir1.radius);
			renderer.setColor(Color.WHITE);
			renderer.circle(cir3.x, cir3.y, cir3.radius);
			renderer.rect(rec2.getX(), rec2.getY(), rec2.getWidth(), rec2.getHeight());
			renderer.end();
		}
	}
	
	private void detectarColisiones() {
		//detectar si hay colision entre los rectangulos
		if(rec1.overlaps(rec2)){
			sprite2.setColor(Color.YELLOW);
		}else{
			sprite2.setColor(Color.BLUE);
		}
		if(cir1.overlaps(cir3)){
			sprite3.setColor(Color.YELLOW);
		}else{
			sprite3.setColor(Color.MAGENTA);
		}
	}

	private void detectarMovimiento(Sprite sprite,boolean isKeyCursorPress){
		float x = sprite.getX();
		float y = sprite.getY();
		if(isKeyCursorPress){
			if(Gdx.input.isKeyPressed(Keys.LEFT))
				x -= 5;
			else if(Gdx.input.isKeyPressed(Keys.RIGHT))
				x += 5;
			if(Gdx.input.isKeyPressed(Keys.UP))
				y += 5;
			else if(Gdx.input.isKeyPressed(Keys.DOWN))
				y -= 5;
		}else{
			if(Gdx.input.isKeyPressed(Keys.A))
				x -= 5;
			else if(Gdx.input.isKeyPressed(Keys.D))
				x += 5;
			if(Gdx.input.isKeyPressed(Keys.W))
				y += 5;
			else if(Gdx.input.isKeyPressed(Keys.S))
				y -= 5;			
		}
		if(x < 0) x=0;
		if(y < 0) y=0;
		if(x>Gdx.graphics.getWidth()) x=Gdx.graphics.getWidth();
		if(y>Gdx.graphics.getHeight()) y=Gdx.graphics.getHeight();
		sprite.setPosition(x, y);
		//tambien tenemos que mover el rectangulo o el circulo
		if(isKeyCursorPress)//si es verdad, movemos el circulo
			cir3.setPosition(x+sprite.getWidth()/2, y+sprite.getHeight()/2);
		else
			rec2.setPosition(x, y);
			
	}
	
	@Override
	public void dispose() {
		if(renderer != null)
			renderer.dispose();
		batch.dispose();
	}
}
