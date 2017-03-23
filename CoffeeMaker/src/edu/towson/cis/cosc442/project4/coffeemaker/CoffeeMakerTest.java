package edu.towson.cis.cosc442.project4.coffeemaker;

import junit.framework.TestCase;


/**
 *
 */
public class CoffeeMakerTest extends TestCase {
	private CoffeeMaker cm;

	private Recipe r1;
	
	private Inventory i;

	public void setUp() {
		cm = new CoffeeMaker();
		i = cm.checkInventory();
	}
	
	
	
	
	
	
	public void testaddinventory(){
		
		cm.addinventorytrue(6, 1, 1, 1);
		
		assertEquals(6,i.getCoffee());
		assertEquals(1,i.getMilk());
		assertEquals(1,i.getSugar());
		assertEquals(1,i.getChocolate());
		
		
		
	}
	
public void testcheckinventoryfalse(){
		
		cm.addinventorytrue(6, 1, 1, 4);
		cm.checkInventory();
		assertNotSame(3,i.getCoffee());
		assertNotSame(0,i.getMilk());
		assertNotSame(0,i.getSugar());
		assertNotSame(1,i.getChocolate());
	
	}

public void testcheckinventorytrue(){
	i.setCoffee(6);
	i.setMilk(1);
	i.setChocolate(4);
	i.setSugar(1);
	
	assertEquals("Coffee: " + i.getCoffee() + i.nextLine() +
			"Milk: " + i.getMilk() + i.nextLine() +
			"Sugar: " + i.getSugar() + i.nextLine() +
			"Chocolate: " + i.getChocolate() + i.nextLine()
		
			,i.toString());
	

}

public void testinventorynegative(){
	
	i.setCoffee(-5);
	i.setChocolate(-2);
	i.setMilk(-4);
	i.setSugar(-3);
	assertSame(0,i.getCoffee());
	assertSame(0,i.getMilk());
assertSame(0,i.getSugar());
	assertSame(0,i.getChocolate());

}

public void testaddinventorytrue(){
	
	
	assertTrue(cm.addInventory(0, 0, 0, 0));}

public void testaddinventoryfalse(){
	assertFalse(cm.addInventory(-1, -1, -1, -1));
	assertFalse(cm.addInventory(10, -1, -1, -1));	
	assertFalse(cm.addInventory(10, -1, 10, -1));
	assertFalse(cm.addInventory(10, -1, 10, 10));
	assertFalse(cm.addInventory(10, 10, -1, 10));
	assertFalse(cm.addInventory(10, 10, 10, -1));	
	}
	
public void testmakepurchase(){
		
		cm.addinventorytrue(6, 1, 1, 6);
		
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(3);
		cm.addRecipe(r1);
		cm.makeCoffee(r1,50);
		
		
		
		assertEquals(0,cm.makerecipie(r1,50),0.001);
	}

public void testpurchasemoneyless(){
	cm.addinventorytrue(6, 1, 1, 6);
	
	r1 = new Recipe();
	r1.setName("Coffee");
	r1.setPrice(50);
	r1.setAmtCoffee(6);
	r1.setAmtMilk(1);
	r1.setAmtSugar(1);
	r1.setAmtChocolate(0);
	cm.addRecipe(r1);
	
	assertEquals(40,cm.makeCoffee(r1,40),0.001);
	
	
	
}

public void testingredient(){
	
	
	r1 = new Recipe();
	r1.setName("Coffee");
	r1.setPrice(50);
	r1.setAmtCoffee(6);
	r1.setAmtMilk(1);
	r1.setAmtSugar(1);
	r1.setAmtChocolate(0);
	cm.addRecipe(r1);
	
	assertEquals(50,cm.makeCoffee(r1,50),0.001);
	
	
	
}



	public void testAddRecipe1() {
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
		
		assertTrue(cm.addRecipe(r1));
	}
	
	public void testAddRecipe2() {
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
		
		cm.addRecipe(r1);
		
		r1 = new Recipe();
		r1.setName("Chocolate Milk ");
		r1.setPrice(50);
		r1.setAmtCoffee(0);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(3);
		
		cm.addRecipe(r1);
		
		r1 = new Recipe();
		r1.setName("Toffee Drink");
		r1.setPrice(30);
		r1.setAmtCoffee(5);
		r1.setAmtMilk(1);
		r1.setAmtSugar(4);
		r1.setAmtChocolate(0);
		
		cm.addRecipe(r1);
		
		r1 = new Recipe();
		r1.setName("Milk");
		r1.setPrice(20);
		r1.setAmtCoffee(0);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
		
		assertTrue(cm.addRecipe(r1));
		
		
	}
	

	
public void testAddRecipeFalse() {
	r1 = new Recipe();
		r1.setPrice(-1);
		r1.setAmtCoffee(-2);
		r1.setAmtMilk(-3);
		r1.setAmtSugar(-4);
		r1.setAmtChocolate(-5);	
		
assertEquals(0,r1.getPrice());
assertEquals(0,r1.getAmtCoffee());
assertEquals(0,r1.getAmtMilk());
assertEquals(0,r1.getAmtSugar());
assertEquals(0,r1.getAmtChocolate());


}

public void testCheckRecipeName() {
	r1 = new Recipe();
	    r1.setName("Coffee");
		
		
assertEquals("Coffee",r1.toString());



}
	
	
	
	public void testaddSamename() {
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
		
		cm.addRecipe(r1);
		
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
		
		assertFalse(cm.addRecipe(r1));
	}

	public void testDeleteRecipe1() {
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
		
		cm.addRecipe(r1);
		assertTrue(cm.deleteRecipe(r1));
	}

	
	
	public void testEditRecipe1() {
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
		
		cm.addRecipe(r1);
		Recipe newRecipe = new Recipe();
		newRecipe = r1;
		r1.setName("Coffee");
		r1.setPrice(50);
		r1.setAmtCoffee(6);
		r1.setAmtMilk(1);
		r1.setAmtSugar(1);
		r1.setAmtChocolate(0);
	
		assertTrue(cm.editRecipe(r1, newRecipe));
	}
	
	
public void testrecepiename(){
	r1 = new Recipe();
	r1.setName("Coffee");
	r1.setPrice(50);
	r1.setAmtCoffee(6);
	r1.setAmtMilk(1);
	r1.setAmtSugar(1);
	r1.setAmtChocolate(0);
	
	cm.addRecipe(r1);
    
		
		assertEquals(r1,cm.getRecipeForName("Coffee"));
		
		
	}

public void testrecepienamewrong(){
	r1 = new Recipe();
	r1.setName("Coffee");
	r1.setPrice(50);
	r1.setAmtCoffee(6);
	r1.setAmtMilk(1);
	r1.setAmtSugar(1);
	r1.setAmtChocolate(0);
	
	cm.addRecipe(r1);
    
		
		assertNotSame(r1,cm.getRecipeForName("Coff"));
				
	}
}