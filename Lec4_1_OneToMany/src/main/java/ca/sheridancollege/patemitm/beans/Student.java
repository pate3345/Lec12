package ca.sheridancollege.patemitm.beans;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToOne
//	@JoinColumn
	
	@JoinTable(name="STUDENT_ACCOUNT", joinColumns =
			@JoinColumn(name="STUDENT_ID"),
			inverseJoinColumns=@JoinColumn(name="ACCOUNT_ID"))
	private Account account;
	
//	@OneToMany //each student have many veichles
//	@OneToMany(cascade =CascadeType.ALL)
	
@JoinColumn
@OneToMany(fetch = FetchType.LAZY)
	private List<Vehicle> vehicleList;


}
