import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class FileUserServiceTest {


    @Mock
    IOUtils ioUtils;

    FileUserService fileUserService;

    @Before
    public void setUp() throws Exception {
        fileUserService = new FileUserService(ioUtils);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testThatUserExistInSystem() {

        when(ioUtils.readNextLine()).thenReturn("check");
        when(ioUtils.fileExist(anyString())).thenReturn(true);

        fileUserService.addUser();

        verify(ioUtils).writeMessage(eq("Enter email: "));

        verify(ioUtils).writeMessage(eq("user already exist"));
    }

    @Test

    public void testIfPersonalEmailHasAT(){

    }


}