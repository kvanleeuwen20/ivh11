package kvl.school.ivh11.service;

import kvl.school.ivh11.domain.*;
import kvl.school.ivh11.repository.CustomerRepo;
import kvl.school.ivh11.repository.EmployeeRepo;
import kvl.school.ivh11.service.abstr.CinemaService;
import kvl.school.ivh11.utils.CinemaData;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Level;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CinemaServiceTest {
    private CinemaData data;

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    public CinemaServiceTest() {
    }

    @BeforeClass
    public static void initializeDatabase() {
    }

    @AfterClass
    //@Sql({"sql/drop-database.sql"})
    public static void cleanUpDatabase() {
    }

    @Before
    public void setUp() {
        this.data = new CinemaData(customerRepo, employeeRepo);
    }

    @Test
    //@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"schema.sql"})
    //@Sql({"sql/remove-test-data.sql", "data.sql"})
    public void findCinemasWithId() {
        Cinema cinema = this.cinemaService.findCinemasWithId(this.data.getId());

        Assert.assertEquals(this.data.getCinema(), cinema);
    }
}