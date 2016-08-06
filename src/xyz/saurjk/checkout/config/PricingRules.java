package xyz.saurjk.checkout.config;

public class PricingRules {

	public final int unitPrice;
	public final int specialPriceNumber;
	public final int specialPrice;

	public int getUnitPrice() {
		return unitPrice;
	}

	public int getSpecialPriceNumber() {
		return specialPriceNumber;
	}

	public int getSpecialPrice() {
		return specialPrice;
	}

	public static class MyBuilder {
		private final int unitPrice;
		private int specialPriceNumber;
		private int specialPrice;

		public MyBuilder(int unitPrice) {
			this.unitPrice = unitPrice;
		}

		public MyBuilder specialPrice(int specialPriceNumber, int specialPrice) {
			this.specialPriceNumber = specialPriceNumber;
			this.specialPrice = specialPrice;
			return this;
		}

		public PricingRules build() {
			return new PricingRules(this);
		}
	}

	private PricingRules(MyBuilder builder) {
		this.unitPrice = builder.unitPrice;
		this.specialPriceNumber = builder.specialPriceNumber;
		this.specialPrice = builder.specialPrice;
	}

	@Override
	public String toString() {
		return "PricingRules [unitPrice=" + unitPrice + ", specialPriceNumber=" + specialPriceNumber + ", specialPrice="
				+ specialPrice + "]";
	}

}
