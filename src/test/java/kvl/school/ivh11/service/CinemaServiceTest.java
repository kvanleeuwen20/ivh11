package kvl.school.ivh11.service;

import kvl.school.ivh11.domain.Cinema;
import kvl.school.ivh11.domain.Screen;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CinemaServiceTest {
    private final static long id = 1;
    private final static String location = "Chasséveld 15, 4811 DH Breda";
    private final static String name = "Pathé Breda";

    private final static Screen screenOne;

    private final static Screen screenTwo;

    private Set<Screen> screens;

    private final CinemaService cinemaService;

    @Autowired
    public CinemaServiceTest(CinemaService cinemaService) {
        this.cinemaService = cinemaService;

        screens = new HashSet<>();
        screens.add();
    }
    public void initializeDatabase() {
    }

    @AfterClass
    @Sql({"drop-database.sql"})
    public void cleanUpDatabase() {
    }


    @BeforeClass
    @Sql({"create-database.sql"})
    @Before
    @Sql({"remove-test-data.sql", "insert-test-data.sql"})
    public void setUp() {
    }

    @Test
    public void findCinemasWithId() {
        Cinema cinema = this.cinemaService.findCinemasWithId(id);

        Assert.assertNotNull(cinema);
        Assert.assertEquals(location, cinema.getLocation());
        Assert.assertEquals(name, cinema.getName());
        Assert.assertEquals(location, cinema.getScreens());

    }
}