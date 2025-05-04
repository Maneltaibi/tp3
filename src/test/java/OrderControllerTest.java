

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.example.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @Mock
    private OrderDao orderDao;

    @InjectMocks
    private OrderController orderController;

    @Test
    void testCreateOrder() {
        // Arrange
        Order order = new Order(1L, "Test Order");

        // Act
        orderController.createOrder(order);

        // Assert
        verify(orderService).createOrder(order);
    }
}