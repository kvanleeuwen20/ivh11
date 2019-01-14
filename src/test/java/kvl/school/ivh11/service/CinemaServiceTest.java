package kvl.school.ivh11.service;

import kvl.school.ivh11.cnf.DataSourceConfig;
import kvl.school.ivh11.domain.*;
import kvl.school.ivh11.repository.CustomerRepo;
import kvl.school.ivh11.repository.EmployeeRepo;
import kvl.school.ivh11.utils.CinemaData;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@Import(CinemaData.class)
//@ContextConfiguration(classes = {DataSourceConfig.class})
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
    @Sql({"create-database.sql"})
    public static void initializeDatabase() {
    }

    @AfterClass
    @Sql({"drop-database.sql"})
    public static void cleanUpDatabase() {
    }

    @Before
    @Sql({"remove-test-data.sql", "insert-test-data.sql"})
    public void setUp() {
        //this.data = new CinemaData(customerRepo, employeeRepo);
    }

    @Test
    public void findCinemasWithId() {
        Cinema cinema = this.cinemaService.findCinemasWithId(this.data.getId());

        Assert.assertEquals(this.data.getCinema(), cinema);
    }
}