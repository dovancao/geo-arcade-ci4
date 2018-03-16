package game.enemy.bullet;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import game.enemy.EnemyLarge;


public class EnemyLargeShoot {
    private FrameCounter frameCounter = new FrameCounter(50);

    public void run(EnemyLarge enemyLarge){

        if(this.frameCounter.run()){
            BulletEnemy bulletLargeEnemy = new BulletEnemy();
            bulletLargeEnemy.position.set(enemyLarge.position);
            bulletLargeEnemy.velocity.set(GameObjectManager.instance.getPlayer().position.normalize().multiply(3));
            GameObjectManager.instance.add(bulletLargeEnemy);
        }

    }
}
