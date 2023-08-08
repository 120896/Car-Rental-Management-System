package com.met.cdac.exception.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.met.cdac.model.Register;
import com.met.cdac.model.Admin;
import com.met.cdac.model.Car;
import com.met.cdac.model.CarBookingInfo;
import com.met.cdac.model.CarType;
import com.met.cdac.model.ContactInfo;
import com.met.cdac.repository.RegisterRepository;
import com.met.cdac.repository.AdminRepository;
import com.met.cdac.repository.CarBookingRepository;
import com.met.cdac.repository.CarRepository;
import com.met.cdac.repository.CarTypeRepository;
import com.met.cdac.repository.ContactRepository;

import org.springframework.ui.Model;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins="http://localhost:3000")
public class CarRentServiceController {

	@Autowired
	public RegisterRepository registerRepository;
	
	 @Autowired
	    private CarRepository carRepository;
	 
	 @Autowired
	 private AdminRepository adminrepository;
	 
	 
	 @Autowired
	 private CarBookingRepository carBookingRepository;
	 
	 @Autowired
	 private ContactRepository contactRepository;
	 
	 @Autowired
	 private CarTypeRepository carTypeRepository;

	    @PostMapping("car")
	    Car addCar(@RequestBody Car newCar){
	    	
	    	System.out.println(newCar);
	        return carRepository.save(newCar);
	    }

	    
	    
	    @GetMapping("/cars1/{id}")
     Optional<Car> getCar(@PathVariable("id") long id) {
         
	         return carRepository.findById(id);
	    }
	    
	    @DeleteMapping("/{id}")
	    String deleteCar(@PathVariable("id") long id) {
	    	
	    	carRepository.deleteById(id);
	    	
	        return "deleted";
	    }
	    
	    @PutMapping("/cars")
	    Car updatecar(@RequestBody Car car) {
	    	
	    	
	    	
	        return carRepository.save(car);
	    }

    //private RegisterService registerService;
	//get all register 
	
	@GetMapping(value="/registeruser",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Register> getAllRegisterUser(){
		return registerRepository.findAll();
		
	}
	
	//create add user
	 @GetMapping("register")
	    public String showRegistrationForm(Model model){
		 Register user = new Register();
	        System.out.println("showRegistrationForm");
	        model.addAttribute("user", user);
	        System.out.println("model"+model);
	        return "register";
	    }
	
//	  @PostMapping("/register") 
//	  public boolean createRegisterUser(@RequestBody Register register) { 
//		  
//	        System.out.println("register   :: "+register.getEmail());
//	        Register existing = registerRepository.findByEmail(register.getEmail());
//	        if (existing != null) {
//	            //result.rejectValue("email", null, "There is already an account registered with that email");
//	        	System.out.println("There is already an account registered with that email");
//	        	return false;
//	        }
//	        registerRepository.save(register); 
//	        System.out.println("Added register   :: "+register.getEmail());
//
//		  return true;
//		  
//	  }

	  @PostMapping("/register") 
	  public ResponseEntity<Register> createRegisterUser(@RequestBody Register register) { 
		  
	        System.out.println("register   :: "+register.getEmail());
	        Register existing = registerRepository.findByEmail(register.getEmail());
	        if (existing != null) {
	            //result.rejectValue("email", null, "There is already an account registered with that email");
	        	System.out.println("There is already an account registered with that email");
	        	return new ResponseEntity<Register>(register,HttpStatus.NO_CONTENT);
	        }
	        registerRepository.save(register); 
	        System.out.println("Added register   :: "+register.getEmail());

		  return new ResponseEntity<Register>(register, HttpStatus.OK);
		  
	  }
	 
	  @RequestMapping(value="/login",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE) 
	  public ResponseEntity<Register> loginUser(@RequestBody Register register) { 
		  
		  System.out.println("register getEmail  :: "+register.getEmail());
		  System.out.println("register  getPassword :: "+register.getPassword());
	   
		  Register data = registerRepository.findByEmail(register.getEmail());
		  System.out.println("register getEmail  :: "+data);
		
		  

			
			  if (data != null  &&  (data.getEmail().equals(register.getEmail()) &&
			  (data.getPassword().equals(register.getPassword())))) { 
				 
				  
				  return new ResponseEntity<Register>(register, HttpStatus.OK);
			  
			  }
			
			 			 
			  return new ResponseEntity<Register>(register, HttpStatus.NO_CONTENT);		  
	  }
	  
	  @RequestMapping(value="/adminlogin",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE) 
	  public ResponseEntity<Admin> adminUser(@RequestBody Admin admin) { 
		  
		  System.out.println("adminlogin getusername  :: "+admin.getUsername());
		  System.out.println("adminlogin  getPassword :: "+admin.getPassword());
	   
		  Admin data = adminrepository.findByUsername(admin.getUsername());
		  System.out.println("adminlogin getusername :: "+data);
		
		  

			
			  if (data != null  &&  (data.getUsername().equals(admin.getUsername()) &&
			  (data.getPassword().equals(admin.getPassword())))) { 
				 
				  
				  return new ResponseEntity<Admin>(admin, HttpStatus.OK);
			  
			  }
			
			 			 
			  return new ResponseEntity<Admin>(admin, HttpStatus.NO_CONTENT);		  
	  }
	  @PostMapping("/book_details") 
	  public ResponseEntity<CarBookingInfo>  createBookingDetails(@RequestBody CarBookingInfo bookDetails) { 
		  
	        System.out.println("bookDetails email   :: "+bookDetails.getEmail());
	        System.out.println("bookDetails email   :: "+bookDetails.getFromAddress());
	      
	        Register checkEmail = registerRepository.findByEmail(bookDetails.getEmail());
	        System.out.println("checkEmail"+checkEmail);
	      
	        	   System.out.println("checkEmail email   :: "+checkEmail);
	        	if( checkEmail != null && checkEmail.getEmail().equals(bookDetails.getEmail()))
	        	{
	        		carBookingRepository.save(bookDetails);
	        	System.out.println("Payment Info");
	        	return new ResponseEntity<CarBookingInfo>(bookDetails,HttpStatus.OK);
	        		
	        	}
	        	else {
			        System.out.println("Login Page");
		        	return new ResponseEntity<CarBookingInfo>(bookDetails,HttpStatus.NO_CONTENT);
			       }
	        	
	        
	  }
	 
	  @PostMapping("/contact") 
	  public ResponseEntity<ContactInfo>  createContactDetails(@RequestBody ContactInfo contactDetails) { 
		  
	        System.out.println("contactDetails    :: "+contactDetails);
	        contactRepository.save(contactDetails);
	      	return new ResponseEntity<ContactInfo>(contactDetails,HttpStatus.OK);
	      	
	    }
	  
	 
	  
	  @GetMapping("/customer/{email}")

	  public ResponseEntity<List<CarBookingInfo>> findByEmail(@PathVariable String email){

	  List<CarBookingInfo> bookDetails = carBookingRepository.findByEmail(email);

	  if( bookDetails != null)

	  {

	  System.out.println("Records are present");

	  return new ResponseEntity(bookDetails,HttpStatus.OK);

	  }

	  else {

	  System.out.println("Records are not present");

	  return new ResponseEntity(bookDetails,HttpStatus.NO_CONTENT);

	  }

	  }
	  
	  @GetMapping("/customer")
	    List<CarBookingInfo> getAllBookingDetails() {
	        return carBookingRepository.findAll();
	    }

	    @GetMapping("/cartype")
	    List<CarType> getAllCarsType() {
	        return (List<CarType>) carTypeRepository.findAll();
	    }
	    @GetMapping("/cars")
	    List<Car> getAllCars() {
	        return (List<Car>) carRepository.findAll();
	    }
	    
	    @GetMapping("/book_details/{invoiceRefNo}")
		public ResponseEntity<CarBookingInfo>  findByInvoiceRefNo(@PathVariable String invoiceRefNo){
		  CarBookingInfo reg = carBookingRepository.findByInvoiceRefNo(invoiceRefNo);
		  Long carprice= findByCarName(reg.getCarName());
	    	System.out.println(" carprice:"+carprice);
	    	System.out.println(" reg:"+reg);

		  Long cartypeprice= findByCarType(reg.getCarType());
	    	System.out.println("findByCarName cartypeprice:"+cartypeprice);

	    	// parsing the string date into LocalDate objects.
			LocalDate localDate1 = LocalDate.parse(reg.getJourneyDate());
			LocalDate localDate2 = LocalDate.parse(reg.getReturnDate());

			LocalDate date = LocalDate.now();
			System.out.println("totalPrice reg:"+date.toString());
			
			// java 8 way - 1
			// Fetching the diff using between() method
			long noOfDaysDifference = ChronoUnit.DAYS.between(localDate1, localDate2);

			// print diff in days
			System.out.println("Java 8 way 1 between() - No of days diff is : " + noOfDaysDifference);
			BigDecimal gst_tax=new BigDecimal(12);
			BigDecimal totalPrice= (new BigDecimal(carprice).add(new BigDecimal(cartypeprice))
					.multiply(new BigDecimal(noOfDaysDifference)));
					//((carprice + cartypeprice) * noOfDaysDifference);
	    	System.out.println("totalPrice reg:"+totalPrice);
	    	BigDecimal gstPrice=totalPrice.multiply(new BigDecimal(1.12));
	    	System.out.println("gstPrice reg:"+gstPrice);
	    	gstPrice=gstPrice.setScale(2, BigDecimal.ROUND_UP);

			carBookingRepository.updateBooking_details(carprice,cartypeprice,totalPrice,date.toString(),noOfDaysDifference,gst_tax,gstPrice,invoiceRefNo);
			
			reg.setCarPricePerDay(totalPrice);
			reg.setCarTypePrice(cartypeprice);
			reg.setCarNamePrice(carprice);
			reg.setOrderDate(date.toString());
			reg.setDays(noOfDaysDifference);
			reg.setGstTax(gst_tax);
			reg.setTotalPrice(gstPrice);

	    	System.out.println("findByInvoiceRefNo reg:"+reg);

		  return ResponseEntity.ok(reg);
		}
	    @GetMapping("/cars/{name}")
		public Long  findByCarName(@PathVariable String name){
	    	Long price = carRepository.findByCarName(name);
	    	System.out.println("findByCarName price:"+price);
		  return price;
		}
	    @GetMapping("/cartype/{name}")
		public Long  findByCarType(@PathVariable String name){
	    	Long price = carTypeRepository.findByCarName(name);
  	System.out.println("findByCarType price:"+price);	
  	
  	return price;
	}
  
}
