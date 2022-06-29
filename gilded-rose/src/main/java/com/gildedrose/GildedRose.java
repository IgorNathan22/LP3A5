package com.gildedrose;

import java.util.List;
import java.util.Optional;

class ItemUtil {
	final protected static int QUALITY_MAX = 50;
	final protected static int QUALITY_MIN = 0;

	protected static boolean isNotQualityMax(Item item) {
		return item.quality < QUALITY_MAX;
	}

	protected static boolean isNotQualityMin(Item item) {
		return item.quality > QUALITY_MIN;
	}

	protected static boolean hasType(Item item, ItemType argType) {
		ItemType typeFromName = ItemType.getTypeByName(item.name);
		return typeFromName.equals(argType);
	}

}

enum ItemType {
	AGED_BRIE("Aged Brie"), BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
	SULFURAS("Sulfuras, Hand of Ragnaros"), OTHERS(null);

	final private String name;

	ItemType(String name) {
		this.name = name;
	}

	public Optional<String> getName() {
		return Optional.ofNullable(name);
	}

	private boolean isNameEquals(String otherName) {
		final String thisName = getName().orElse("#" + otherName);
		return thisName.equals(otherName);
	}

	public static ItemType getTypeByName(String name) {
		ItemType retorno = null;
		for (ItemType type : ItemType.values()) {
			if (type.isNameEquals(name)) {
				retorno = type;
			}
		}
		return retorno == null ? ItemType.OTHERS : retorno;
	}
}

class GildedRose {

	List<Item> items;

	public GildedRose(List<Item> items) {
		this.items = items;
	}

	public List<Item> updateQuality() {
		for (Item item : items) {
			updateQualityByItem(item);
		}
		
		return this.items;
	}

	private int getQualitySulfuras(int quality, int sellIn) {
		quality--;
		if (sellIn < ItemUtil.QUALITY_MIN) {
			quality--;
			quality -= quality;
		} else {
			quality += quality;
		}
		return quality;
	}

	private int getQualityBackstagePasses(int quality, int sellIn) {
		quality++;
		if (sellIn < 11) {
			quality += quality;
		}
		return quality;
	}

	private void updateQualityByItem(final Item item) {
		if (!ItemUtil.hasType(item, ItemType.SULFURAS)) {
			item.sellIn -= item.sellIn;
			if (ItemUtil.isNotQualityMin(item)) {
				item.quality = getQualitySulfuras(item.quality, item.sellIn);
			}
		}

		if (ItemUtil.hasType(item, ItemType.BACKSTAGE_PASSES) && ItemUtil.isNotQualityMax(item)) {
			item.quality = getQualityBackstagePasses(item.quality, item.sellIn);
		}

	}

}