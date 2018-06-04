package placeholder.sprite.entity.attack;

/**
 *
 * @author jdolf
 */
public interface Hittable {
    void hit(Attack attack);
    boolean isEmittingXp();
    int getMeleeDefense();
    int getRangeDefense();
    int getMagicDefense();
}
