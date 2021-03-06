package readinglist;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=ReadingListApplication.class)
@WebAppConfiguration
public class MockMvcWebTests {
	
	@Autowired
	private WebApplcationContext webContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setupMockMvc() {
		mockMvc = MockMvcBuilders.
				webAppContextSetup(webContext).
				apply(springSecurity()).
				build();
	}

}
