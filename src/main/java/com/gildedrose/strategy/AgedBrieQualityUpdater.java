package com.gildedrose.strategy;

import com.gildedrose.Item;

public class AgedBrieQualityUpdater extends ItemQualityUpdater {

    @Override
    public void updateQuality(Item item) {
        decreaseSellIn(item);
        increaseQuality((item));
        if (item.sellIn < SELL_DATE) {
            increaseQuality((item));
        }
    }
}
