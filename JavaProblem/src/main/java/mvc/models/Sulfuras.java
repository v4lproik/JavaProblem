package mvc.models;

/**
 * Created by v4lproik on 26/01/15.
 */
public class Sulfuras extends ItemAbstract {

    //specific variables for each item
    private static final int MAX_QUALITY = 80;
    private static final int SELLIN_STEP = 1;
    private static final int QUALITY_STEP = 1;

    /**
     * specific business logic for agedbrie
     *
     * "Sulfuras" never has to be sold or decreases in Quality
    *
     * @param item
     */
    @Override
    public void update(Item item) {
        if (item.quality < MAX_QUALITY) {
            updateQuality(item);
        }
        //updateSellIn(item);
    }

    @Override
    public void updateSellIn(Item item) {
        item.sellIn -= SELLIN_STEP;
    }

    @Override
    public void updateQuality(Item item) {

    }
}
