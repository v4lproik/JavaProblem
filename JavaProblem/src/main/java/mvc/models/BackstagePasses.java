package mvc.models;

/**
 * Created by v4lproik on 26/01/15.
 */
public class BackstagePasses extends ItemAbstract {

    //specific variables for each item
    private static final int MAX_QUALITY = 50;
    private static final int SELLIN_STEP = 1;
    private static final int QUALITY_STEP = 1;

    /**
     * specific business logic for agedbrie
     *
     * The Quality of an item is never more than 50; except for “Sulfuras” which can be 80. Certain item categories have special behaviours, again which need to be maintained:
     "Backstage Passes" actually increases in Quality the older it gets
     aged brie, increases in Quality as it's SellIn value reduces (i.e as it gets closer to the concert). Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but Quality drops to 0 after the concert
     *
     * @param item
     */
    @Override
    public void update(Item item) {
        if (item.quality < MAX_QUALITY) {
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
        item.setQuality(item.getQuality() + QUALITY_STEP);

        if (item.sellIn < 11) {
            if (item.quality < MAX_QUALITY) {
                item.setQuality(item.getQuality() + QUALITY_STEP);
            }
        }
        if (item.sellIn < 6) {
            if (item.quality < MAX_QUALITY) {
                item.setQuality(item.getQuality() + QUALITY_STEP);
            }
        }
    }
}
