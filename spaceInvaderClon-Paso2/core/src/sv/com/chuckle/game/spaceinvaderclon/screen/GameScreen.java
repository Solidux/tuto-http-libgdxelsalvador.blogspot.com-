package sv.com.chuckle.game.spaceinvaderclon.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;

import sv.com.chuckle.game.spaceinvaderclon.GameLoop;
import sv.com.chuckle.game.spaceinvaderclon.entidad.Alien;
import sv.com.chuckle.game.spaceinvaderclon.entidad.Hero;
import sv.com.chuckle.game.spaceinvaderclon.utils.Utils;


public class GameScreen implements Screen{
    private GameLoop game;
    private Hero hero;
    private Stage stage;

    public GameScreen(GameLoop game){
        this.game = game;
        stage = new Stage();
        hero = new Hero(Utils.ANCHO/2-45,0);
        stage.addActor(hero);

        Alien a = new Alien(100,400);
        stage.addActor(a);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
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
        stage.dispose();
    }
}
