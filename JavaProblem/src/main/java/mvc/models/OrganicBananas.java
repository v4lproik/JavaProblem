package mvc.models;

/**
 * Created by v4lproik on 26/01/15.
 */
public class OrganicBananas extends ItemAbstract {

    //specific variables for each item
    private static final int MAX_QUALITY = 50;
    private static final int SELLIN_STEP = 1;
    private static final int QUALITY_STEP = 2;

    /**
     * specific business logic for agedbrie
     *
     * The "Organic Bananas" item degrade in Quality twice as fast as normal items
     *
     * @param item
     */
    @Override
    public void update(Item item) {
        //quality cannot be negative
        if (item.getQuality() < MAX_QUALITY && item.getQuality() >= 0) {
            updateQuality(item);
        }
        updateSellIn(item);
    }

    @Override
    public void updateSellIn(Item item) {
        item.sellIn -= SELLIN_STEP;
    }

    @Override
    public void updateQuality(Item item) {
        //logic from supermarketplusplus
        if(item.getSellIn() < 0)
            item.setQuality(item.getQuality() - QUALITY_STEP);
        else
            item.setQuality(item.getQuality() - QUALITY_STEP * 2);
    }
}
