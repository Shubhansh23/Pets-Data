package in.ashokit.rest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashokit.binding.PetRequest;

@RestController
public class PetRestController {

	
	  @PostMapping( 
			  value = "/pets", 
			  consumes = {"application/json"},
			  produces = {"application/json"}
			  )
	  public ResponseEntity<String> savePet(@RequestBody PetRequest preq) throws Exception{
	  System.out.println("Inside Post Mapping Method");
		  
	  System.out.println(preq);	 
	  
		/*
		 * ObjectMapper mapper=new ObjectMapper(); //mapper.writeValue(new
		 * File("pet.json"), preq); //System.out.println("json file created");
		 * 
		 * PetRequest readValue = mapper.readValue(new File("pet.json"),
		 * PetRequest.class); String writeValueAsString =
		 * mapper.writerWithDefaultPrettyPrinter().writeValueAsString(readValue);
		 * 
		 * System.out.println(writeValueAsString);
		 */
	  return new ResponseEntity<>("saved",HttpStatus.CREATED); 
	  }
	 

	@GetMapping(
			value = "/pets",
			produces = { "application/json" }
			)
	public List<PetRequest> getPet() throws Exception {
		// PetRequest p = new PetRequest();

		PetRequest p1 = new PetRequest(1, "Dog 1", "499.00");
		PetRequest p2 = new PetRequest(2, "Dog 2", "599.00");
		PetRequest p3 = new PetRequest(3, "Dog 3", "699.00");

		List<PetRequest> petlist = Arrays.asList(p1, p2, p3);

		return petlist;
	}

	@GetMapping(
			value = "/pets/{id}",
			produces = { "application/json" }
			)
	public ResponseEntity<PetRequest> getPetById(@PathVariable("id") Integer id) throws Exception {
		PetRequest p = new PetRequest();
		if (id == 1) {
			p.setId(1);
			p.setPetname("Dog 1");
			p.setPetprice("499.00");
		}
		else if (id == 2) {
			p.setId(2);
			p.setPetname("Dog 2");
			p.setPetprice("599.00");
		}
		else if (id == 3) {
			p.setId(3);
			p.setPetname("Dog 3");
			p.setPetprice("699.00");
		}
		
		return new ResponseEntity(p, HttpStatus.OK);

	}

}
