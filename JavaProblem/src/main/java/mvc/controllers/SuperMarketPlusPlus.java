package mvc.controllers;

import mvc.models.Item;
import mvc.models.ItemAbstract;
import mvc.models.ItemUpdateFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class SuperMarketPlusPlus {

    static Logger log = Logger.getLogger(SuperMarketPlusPlus.class.getName());

    private static List<Item> items = null;

    private static final int DAY = 5;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        BasicConfigurator.configure();

        log.debug("Starting Supermarket Plus Plus");
		
        items = new ArrayList<Item>();
        items.add(new Item("Thermal Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Chicken", 5, 7));
        items.add(new Item("Sulfuras", 0, 80));
        items.add(new Item("Backstage Passes", 15, 20));
        items.add(new Item("Ginger Cake", 3, 6));
        items.add(new Item("Organic Bananas", 30, 26));

        for(int i = 0; i < DAY; i++){
            updateQuality(items);
        }
}


    public static void updateQuality(List<Item> items)
    {
        for (Item item : items) {
            ItemAbstract itemStrategy = ItemUpdateFactory.getItemStrategy(item.getName());
            log.debug("Bef Update : item name " + item.getName() + ", quality " + item.getQuality() + ", sellIn " + item.getSellIn());
            itemStrategy.update(item);
            log.debug("Aft Update : item name " + item.getName() + ", quality " + item.getQuality() + ", sellIn " + item.getSellIn());
        }
    }
	/*
    public static void updateQuality()
    {
        for (int i = 0; i < items.size(); i++)
        {
            if ((!"Aged Brie".equals(items.get(i).getName())) && !"Backstage Passes".equals(items.get(i).getName())) 
            {
                if (items.get(i).getQuality() > 0)
                {
                    if (!"Sulfuras".equals(items.get(i).getName()))
                    {
                        items.get(i).setQuality(items.get(i).getQuality() - 1);
                    }
                }
            }
            else
            {
                if (items.get(i).getQuality() < 50)
                {
                    items.get(i).setQuality(items.get(i).getQuality() + 1);

                    if ("Backstage Passes".equals(items.get(i).getName()))
                    {
                        if (items.get(i).getSellIn() < 11)
                        {
                            if (items.get(i).getQuality() < 50)
                            {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }

                        if (items.get(i).getSellIn() < 6)
                        {
                            if (items.get(i).getQuality() < 50)
                            {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!"Sulfuras".equals(items.get(i).getName()))
            {
                items.get(i).setSellIn(items.get(i).getSellIn() - 1);
            }

            if (items.get(i).getSellIn() < 0)
            {
                if (!"Aged Brie".equals(items.get(i).getName()))
                {
                    if (!"Backstage Passes".equals(items.get(i).getName()))
                    {
                        if (items.get(i).getQuality() > 0)
                        {
                            if (!"Sulfuras".equals(items.get(i).getName()))
                            {
                                items.get(i).setQuality(items.get(i).getQuality() - 1);
                            }
                        }
                    }
                    else
                    {
                        items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
                    }
                }
                else
                {
                    if (items.get(i).getQuality() < 50)
                    {
                        items.get(i).setQuality(items.get(i).getQuality() + 1);
                    }
                }
            }
        }
    }*/

}