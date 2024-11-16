import org.powermock.api.mockito.PowerMockito;
import com.example.UserDao;
import com.example.UserService;
import junit.framework.TestCase;
import org.junit.Test;

public class UserServiceTest extends TestCase {
    @Test
    public void testGetNameById() {
        UserDao mockDao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(mockDao.findNameById(111)).thenReturn("raj");// assigning sample test case w/o connecting to
                                                                       // db
        UserService service = new UserService(mockDao);// pass mockobj
        String name = service.getNameById(111);// when service calls the exact method, it doesnt connect todb, return
        assertEquals("raj", name);
    }

    @Test
    public void testGetEmailById() {
        UserDao mockDao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(mockDao.findEmailById(111)).thenReturn("raj@gmail.com");
        UserService service = new UserService(mockDao);
        String email = service.getEmailById(111);
        assertEquals("raj@gmail.com", email);
    }
}
