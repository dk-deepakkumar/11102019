package com.silverbars.domain;

public final class Summary {

	// quantity of single order
    long quantity;
    // price per KG
    long pricePerKg;

    // two argument Constructor
    public Summary(long quantity, long pricePerKg) {
        super();
        this.quantity = quantity;
        this.pricePerKg = pricePerKg;
    }
   

    /**
	 * @return the quantity
	 */
	public long getQuantity() {
		return quantity;
	}



	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}



	/**
	 * @return the pricePerKg
	 */
	public long getPricePerKg() {
		return pricePerKg;
	}



	/**
	 * @param pricePerKg the pricePerKg to set
	 */
	public void setPricePerKg(long pricePerKg) {
		this.pricePerKg = pricePerKg;
	}



	public String toString() {
        return quantity/1000d + "kg for £" + pricePerKg/100d;
    }
}
