package com.soma.builder;


/** "Product" */
class Pizza {
	private String dough = "";
	private String sauce = "";
	private String topping = "";
 
	public void setDough(String dough) {
		this.dough = dough;
	}
 
	public void setSauce(String sauce) {
		this.sauce = sauce;
	}
 
	public void setTopping(String topping) {
		this.topping = topping;
	}
}
 
/** "Abstract Builder" */
abstract class PizzaBuilder {
	protected Pizza pizza;
 
	public Pizza getPizza() {
		return pizza;
	}
 
	public void createNewPizzaProduct() {
		pizza = new Pizza();
	}
 
	public abstract void buildDough();
 
	public abstract void buildSauce();
 
	public abstract void buildTopping();
}
 
/** "ConcreteBuilder" */
class HawaiianPizzaBuilder extends PizzaBuilder {
	public void buildDough() {
		pizza.setDough("cross");
	}
 
	public void buildSauce() {
		pizza.setSauce("mild");
	}
 
	public void buildTopping() {
		pizza.setTopping("ham+pineapple");
	}
}
 
/** "ConcreteBuilder" */
class SpicyPizzaBuilder extends PizzaBuilder {
	public void buildDough() {
		pizza.setDough("pan baked");
	}
 
	public void buildSauce() {
		pizza.setSauce("hot");
	}
 
	public void buildTopping() {
		pizza.setTopping("pepperoni+salami");
	}
}
 
/** "Director" */
class Cook {
	private PizzaBuilder pizzaBuilder;
 
	public Cook setPizzaBuilder(PizzaBuilder pizzaBuilder) {
		this.pizzaBuilder = pizzaBuilder;
		return this;
	}
 
	public Pizza getPizza() {
		return pizzaBuilder.getPizza();
	}
 
	public Cook constructPizza() {
		pizzaBuilder.createNewPizzaProduct();
		pizzaBuilder.buildDough();
		pizzaBuilder.buildSauce();
		pizzaBuilder.buildTopping();
		return this;
	}
}
 
/** A given type of pizza being constructed. */
class BuilderExample {
	public static void main(String[] args) {
		
		PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();
		PizzaBuilder spicyPizzaBuilder = new SpicyPizzaBuilder();
		Cook cook = new Cook();
		cook.setPizzaBuilder(hawaiianPizzaBuilder);
		cook.constructPizza();
 
		Pizza pizza = cook.getPizza();
		
		
		
		Pizza chainPizza = new Cook().setPizzaBuilder(spicyPizzaBuilder).constructPizza().getPizza();
	}
}