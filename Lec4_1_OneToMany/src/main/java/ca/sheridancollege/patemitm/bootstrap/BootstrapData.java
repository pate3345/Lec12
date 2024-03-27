package ca.sheridancollege.patemitm.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.patemitm.beans.Account;
import ca.sheridancollege.patemitm.beans.AccountStatus;
import ca.sheridancollege.patemitm.beans.Student;
import ca.sheridancollege.patemitm.beans.Vehicle;
import ca.sheridancollege.patemitm.repository.AccountRepository;
import ca.sheridancollege.patemitm.repository.StudentRepository;
import ca.sheridancollege.patemitm.repository.VehicleRepository;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUtil;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

	private AccountRepository accountRepository ;
	private StudentRepository studentRepository;
	private VehicleRepository vehicleRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
	
		
		// TODO Auto-generated method stub
		Student student = Student.builder()
				.name("Paul McCartney")
				.vehicleList(new ArrayList<Vehicle>())
				.build();
		
		Account account = Account.builder()
				.accountNumber(Integer.valueOf(1111))
				.balance(new BigDecimal("1200000000.00"))
				.status(AccountStatus.APPROVED)
				.build();
				
		Vehicle vehicle1 = Vehicle.builder()
						.name("Lamborghini 400GT")
						.price(new BigDecimal("175000.00"))
						.build();
		
		Vehicle vehicle2 = Vehicle.builder()
				.name("Ferrari 250GT")
				.price(new BigDecimal("70000000.00"))
				.build();
		
		Vehicle vehicle3 = Vehicle.builder()
				.name("Mercedes-Benz 300 SLR")
				.price(new BigDecimal("142000000.00"))
				.build();
		

//		vehicle1 = vehicleRepository.save(vehicle1);
//		vehicle2 = vehicleRepository.save(vehicle2);
//		vehicle3 = vehicleRepository.save(vehicle3);
		
		student.getVehicleList().add(vehicle1);
		student.getVehicleList().add(vehicle2);
		student.getVehicleList().add(vehicle3);
		
		student.setAccount(account);
		account = accountRepository.save(account);
		student = studentRepository.save(student);
		
		vehicle1 = vehicleRepository.save(vehicle1);
		vehicle2 = vehicleRepository.save(vehicle2);
		vehicle3 = vehicleRepository.save(vehicle3);
		
//		studentRepository.delete(student);
		
		PersistenceUtil pu = Persistence.getPersistenceUtil();
		System.out.println(pu.isLoaded(studentRepository.findById(student.getId()), "vehicleList"));
		

	}

}
