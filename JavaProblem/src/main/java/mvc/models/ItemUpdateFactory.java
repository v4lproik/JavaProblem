package mvc.models;

/**
 * Created by v4lproik on 27/01/15.
 *
 */
public class ItemUpdateFactory {

    //maintain the list of items
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras";
    private static final String BACKSTAGE_PASSES = "Backstage Passes";
    private static final String ORGANIC_BANANAS = "Organic Bananas";

    public static ItemAbstract getItemStrategy(String name) {
        //TODO: switch case... but the project is java 1.6 in the pom.xml
        ItemAbstract itemStrategy;

        if (AGED_BRIE.equals(name))
        {
            itemStrategy = new AgedBrie();
        }else{
            if (BACKSTAGE_PASSES.equals(name))
            {
                itemStrategy = new BackstagePasses();
            }else{
                if (!SULFURAS.equals(name)){
                    itemStrategy = new Sulfuras();
                }else{
                    if(ORGANIC_BANANAS.equals(name)){
                        itemStrategy = new OrganicBananas();
                    }else{
                        //it is a common item...
                        itemStrategy = new CommonItem();
                    }
                }
            }
        }

        return itemStrategy;
    }
}
