package dmit2015.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.within;

public class ProductTest {
    @Test
    void getName_whenProductCreated_shouldReturnCorrectName() {
        // Arrange
        Product currentProduct = new Product("Laptop", 1200);

        // Act
        String actualName = currentProduct.getName();

        // Assert
        assertThat(actualName).isEqualTo("Laptop");
    }

    @Test
    void getPrice_whenProductCreated_shouldReturnCorrectPrice() {
        // Arrange
        Product currentProduct = new Product("Laptop", 1200);

        // Act
        double actualPrice = currentProduct.getPrice();

        // Assert
assertThat(actualPrice).isCloseTo(1200, within(0.01));
    }

    @Test
    void getPriceWithTax_whenCalled_shouldReturnCorrectValue() {
        // Arrange
        Product currentProduct = new Product("Laptop", 1200);

        // Act
        double actualPriceWithTax = currentProduct.getPriceWithTax();

        // Assert
        assertThat(actualPriceWithTax).isCloseTo(1260, within(0.01));
    }

    @Test
    void constructor_whenNameIsBlank_shouldThrowException() {
        assertThatThrownBy(() ->
                new Product("", 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("required");
    }

    @Test
    void constructor_whenPriceIsNegative_shouldThrowException() {
        assertThatThrownBy(() ->
                new Product("Laptop", -5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("greater than 0");
    }
}
