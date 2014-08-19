package com.soma.builder.inner;


// inner class 를 이용한 Builder Pattern
public class Pizza {
	private int size;
	private boolean cheese;
	private boolean pepperoni;
	private boolean bacon;

	public static class Builder {
		// required
		private final int size;

		// optional
		private boolean cheese = false;
		private boolean pepperoni = false;
		private boolean bacon = false;

		public Builder(int size) {
			this.size = size;
		}

		public Builder cheese(boolean value) {
			cheese = value;
			return this;
		}

		public Builder pepperoni(boolean value) {
			pepperoni = value;
			return this;
		}

		public Builder bacon(boolean value) {
			bacon = value;
			return this;
		}

		public Pizza build() {
			return new Pizza(this);
		}
	}

	private Pizza(Builder builder) {
		size = builder.size;
		cheese = builder.cheese;
		pepperoni = builder.pepperoni;
		bacon = builder.bacon;
	}
}

class main {
	public static void main(String args[]){
		Pizza pizza = new Pizza.Builder(12)
				        .cheese(true)
				        .pepperoni(true)
				        .bacon(true)
				        .build();
	}
}