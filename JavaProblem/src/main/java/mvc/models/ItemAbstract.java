package mvc.models;

/**
 * Created by v4lproik on 26/01/15.
 */
public abstract class ItemAbstract {
    public abstract void update(Item item);

    //These functions cannot be public, the business logic is implemented in each model and handled by update
    protected abstract void updateSellIn(Item item);
    protected abstract void updateQuality(Item item);
}
