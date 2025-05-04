

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.example.*;
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductApiClient productApiClient;

    @InjectMocks
    private ProductService productService;

    @Test
    void testGetProductSuccess() {
        // Arrange
        String productId = "P1";
        Product expectedProduct = new Product(productId, "Laptop");
        when(productApiClient.getProduct(productId)).thenReturn(expectedProduct);

        // Act
        Product actualProduct = productService.getProduct(productId);

        // Assert
        assertEquals(expectedProduct, actualProduct);
        verify(productApiClient).getProduct(productId);
    }

    @Test
    void testGetProductInvalidDataFormat() {
        // Arrange
        String productId = "P2";
        when(productApiClient.getProduct(productId)).thenReturn(null); // Simule un format de données invalide

        // Act
        Product product = productService.getProduct(productId);

        // Assert
        assertEquals(null, product);
        verify(productApiClient).getProduct(productId);
    }

    @Test
    void testGetProductApiFailure() {
        // Arrange
        String productId = "P3";
        when(productApiClient.getProduct(productId)).thenThrow(new RuntimeException("API failure"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> productService.getProduct(productId));
        verify(productApiClient).getProduct(productId);
    }
}
