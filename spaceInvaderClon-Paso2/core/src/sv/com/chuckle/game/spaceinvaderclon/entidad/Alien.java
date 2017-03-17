package sv.com.chuckle.game.spaceinvaderclon.entidad;

import sv.com.chuckle.game.spaceinvaderclon.utils.Asset;
import sv.com.chuckle.game.spaceinvaderclon.utils.GameObject;

public class Alien extends GameObject{
    public Alien(float x, float y) {
        super(Asset.nombSpriteAlien, x, y);
    }
}
