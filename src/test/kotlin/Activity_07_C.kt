import activity_04_C.Fruits
import activity_05_C_OOP.Cart_
import activity_05_C_OOP.Main
import activity_06_C.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals


//Create the unit test for adding items in the Cart as well as checking out the items in cart.
//key = product (Name, Price)
// value = quantity

internal class Activity_07_C {
    //ADD ITEMS TO CART
    @Test
    fun addToCartLessZeroQuantity() {
        val main: Main = Main()
        var cart = Cart_()
        assertThrows<InvalidProductQuantityException> { main.addToCart_(cart, Fruits("Mango", 2.2), -2.5) }
    }

    @Test
    fun addToCartLessZeroPrice() {
        val main: Main = Main()
        var cart = Cart_()
        assertThrows<InvalidProductPriceException> { main.addToCart_(cart, Fruits("Mango", 0.0), 2.5) }
    }

    @Test
    fun addToCartEmptyProductName() {
        val main: Main = Main()
        var cart = Cart_()
        assertThrows<InvalidProductNameException> { main.addToCart_(cart, Fruits("", 10.0), 2.5) }
    }

    @Test
    fun addItemsToCartSuccess() {
        val main: Main = Main()
        var cart = Cart_()
        assertEquals("Add to Cart Success", main.addToCart_(cart, Fruits("Mango", 10.0), 2.5))
    }


    //CHECK OUT CART
    @Test
    fun checkOutProductQuantityLessZero() {
        val main: Main = Main()
        var cart = Cart_()
        cart.items.put(Fruits("Mango", 2.2), -1.0)
        assertThrows<InvalidProductQuantityException> { main.checkOutCart_(cart) }
    }

    @Test
    fun checkOutProductPriceLessZero() {
        val main: Main = Main()
        var cart = Cart_()
        cart.items.put(Fruits("Mango", -5.3), 2.0)
        assertThrows<InvalidProductPriceException> { main.checkOutCart_(cart) }
    }

    @Test
    fun checkOutProductNameEmpty() {
        val main: Main = Main()
        var cart = Cart_()
        cart.items.put(Fruits("", 2.3), 2.0)
        assertThrows<InvalidProductNameException> { main.checkOutCart_(cart) }
    }

    @Test
    fun checkOutEmptyCartException() {
        val main: Main = Main()
        var cart = Cart_()
        assertThrows<EmptyCartException> { main.checkOutCart_(cart) }
    }

    @Test
    fun checkOutCartSuccess() {
        val main: Main = Main()
        var cart = Cart_()
        cart.items.put(Fruits("Mango", 2.3), 2.0)
        assertEquals("Check Out Success", main.checkOutCart_(cart))
    }


}