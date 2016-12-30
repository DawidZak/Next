import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.next.dzejk.Config;
import com.next.dzejk.model.Region;
import com.next.dzejk.services.RegionService;

@ContextConfiguration(classes = { Config.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class RegionTest {

	/*
	 * Dorobic metode testujaca findByPesel 
	 * Dorobic metode ktora wyszukuje po nazwie regionu i zrobic test
	 * Dorobic metode testujaca 
	 */
	 
	 
	@Autowired
	RegionService regionService;
	
	@Test
	public void test() {
		regionService.saveRegion(new Region("Warminsko-Mazurskie"));
		System.out.println("a");
		Region region = regionService.findById(1);
		System.out.println(region.getRegionName());
	}

	

}
