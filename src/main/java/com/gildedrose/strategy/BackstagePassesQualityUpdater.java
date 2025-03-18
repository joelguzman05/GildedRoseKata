package com.gildedrose.strategy;

import com.gildedrose.Item;

public class BackstagePassesQualityUpdater extends ItemQualityUpdater {

    private static final int TEN_DAYS_BEFORE_SELL_DATE = 10;
    private static final int FIVE_DAYS_BEFORE_SELL_DATE = 5;

    @Override
    public void updateQuality(Item item) {
        decreaseSellIn(item);
        increaseQuality((item));
        if (item.sellIn < TEN_DAYS_BEFORE_SELL_DATE) {
            increaseQuality((item));
        }
        if (item.sellIn < FIVE_DAYS_BEFORE_SELL_DATE) {
            increaseQuality((item));
        }
        if (item.sellIn < SELL_DATE) {
            setQualityToZero(item);
        }
    }
}
