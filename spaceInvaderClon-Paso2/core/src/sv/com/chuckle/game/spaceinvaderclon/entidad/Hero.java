package sv.com.chuckle.game.spaceinvaderclon.entidad;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.TimeUtils;

import sv.com.chuckle.game.spaceinvaderclon.utils.Asset;
import sv.com.chuckle.game.spaceinvaderclon.utils.GameObject;
import sv.com.chuckle.game.spaceinvaderclon.utils.Utils;


public class Hero extends GameObject{
    private float x;
    private float vel = 250f;
    private ESTADO estado;
    private long lastFire;

    enum ESTADO{
        nada
        ,derecha
        ,izquierda
    }

    public Hero(float x, float y) {
        super(Asset.nombSpriteHero, x, y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if(Gdx.input.isTouched()){
            if(TimeUtils.millis() - lastFire >= 300){
                Misil misil = new Misil(getX()+getWidth()/2-10, getY()+getHeight());
                getStage().addActor(misil);
                lastFire = TimeUtils.millis();
            }
        }

        Application.ApplicationType appType = Gdx.app.getType();
        switch (appType){
            case Desktop:
                if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
                    estado = ESTADO.izquierda;
                else if(Gdx.input.isKeyPressed(Keys.RIGHT))
                    estado = ESTADO.derecha;
                else
                    estado = ESTADO.nada;
                break;
            case Android:
                if(Gdx.input.getAccelerometerX() < 0)
                    estado = ESTADO.derecha;
                else if(Gdx.input.getAccelerometerX() > 0)
                    estado = ESTADO.izquierda;
                else
                    estado = ESTADO.nada;
                break;
        }//fin switch

        x = getX();
        if(estado == ESTADO.derecha)
            x += delta*vel;
        if(estado == ESTADO.izquierda)
            x -= delta*vel;

        if(x<=0)
            x = 0;
        else if(x>= Utils.ANCHO-getWidth())
            x = Utils.ANCHO-getWidth();

        setPosition(x, 0);
    }
}
