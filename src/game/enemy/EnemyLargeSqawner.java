package game.enemy;

import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class EnemyLargeSqawner extends GameObject {
    private int count = 0;
    private Random random;

    public EnemyLargeSqawner() {
        this.random = new Random();
    }

    @Override
    public void run() {
        super.run();
        if (this.count >= 80) {
            EnemyLarge enemyLarge = new EnemyLarge();
            enemyLarge.position.set(random.nextInt(50), 0);
            enemyLarge.velocity.set(0, random.nextInt(2) + 1);
            GameObjectManager.instance.add(enemyLarge);
            this.count = 0;
        } else {
            this.count += 1;
        }
    }

}
