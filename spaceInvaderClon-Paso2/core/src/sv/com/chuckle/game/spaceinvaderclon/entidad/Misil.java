package sv.com.chuckle.game.spaceinvaderclon.entidad;

import sv.com.chuckle.game.spaceinvaderclon.utils.Asset;
import sv.com.chuckle.game.spaceinvaderclon.utils.GameObject;
import sv.com.chuckle.game.spaceinvaderclon.utils.Utils;

public class Misil extends GameObject{
    private float vel;

    public Misil(float x, float y){
        super(Asset.nombSpriteMisil,x,y);
        vel = 300;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        moveBy(0,vel*delta);

        if(getY() > Utils.ALTO)
            remove();

    }
}

