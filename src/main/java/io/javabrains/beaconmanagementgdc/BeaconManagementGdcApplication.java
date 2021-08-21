package io.javabrains.beaconmanagementgdc;

import org.sid.dao.BaliseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan("org.sid.entities")
@EnableJpaRepositories("org.sid.dao")
@SpringBootApplication(scanBasePackages={"org.sid", "org.sid.metier"})
public class BeaconManagementGdcApplication {
	@Autowired
	private BaliseRepository baliseRepository;
	public static void main(String[] args) {
		SpringApplication.run(BeaconManagementGdcApplication.class, args);
	}

	/*public void run(String... args) throws Exception {
		baliseRepository.save(new Balise('','DGD-01406',359983002269623,'Douala','FL02 DOUALA PAD','p_8923702140938661849-2.03\r\n','DISPONIBLE'));
	}*/
}
