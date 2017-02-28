package sv.com.chuckle.game.spaceinvaderclon.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import sv.com.chuckle.game.spaceinvaderclon.GameLoop;
import sv.com.chuckle.game.spaceinvaderclon.utils.Utils;


public class GameOverScreeen implements Screen{
    private GameLoop game;
    private BitmapFont font;
    private Batch batch;

    public GameOverScreeen(GameLoop game){
        this.game = game;
        font = new BitmapFont();
        batch = new SpriteBatch();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(Gdx.input.justTouched())
            game.setScreen(new GameScreen(game));
        batch.begin();
        font.draw(batch, "GAME OVER", Utils.ANCHO/2-50, Utils.ALTO/2+100);
        font.draw(batch, "Presione sobre la pantalla para iniciar el juego", Utils.ANCHO/2-150, Utils.ALTO/2+50);
        batch.end();

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

    }

    @Override
    public void dispose() {
        font.dispose();
        batch.dispose();
    }
}
