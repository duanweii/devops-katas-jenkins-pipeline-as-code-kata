package devops.katas.adminprovider;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminproviderApplicationTests {

	@Test
	public void should_retrieve_an_admin_with_correct_names() {
		AdminService adminService = new AdminService();

		Admin admin = adminService.retrieveAdmin(4);

		BDDAssertions.then(admin.getFirstName()).isEqualTo("firstName [40]");
		BDDAssertions.then(admin.getLastName()).isEqualTo("lastName [4]");
	}
}
