package game.enemy;

import base.GameObject;
import base.Vector2D;
import game.enemy.bullet.EnemyLargeShoot;
import game.enemy.bullet.EnemyShoot;
import utils.Utils;

public class EnemyLarge extends GameObject {
    public Vector2D velocity;
    private EnemyLargeShoot enemyLargeShoot;


    public EnemyLarge() {
        this.image = Utils.loadImage("resources/square/enemy_square_medium.png");
        this.enemyLargeShoot = new EnemyLargeShoot();
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.enemyLargeShoot.run(this);
    }
}
