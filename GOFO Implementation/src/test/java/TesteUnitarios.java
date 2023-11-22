import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteUnitarios {

    private Player player;

    @BeforeEach
    public void setUp() {
        player = new Player();
    }

    @Test
    public void testSetAndGetBalance() {
        // Definindo o saldo como 100
        player.setBalance(100);

        // Verificando se o saldo definido é igual a 100
        assertEquals(100, player.getBalance());
    }
}
