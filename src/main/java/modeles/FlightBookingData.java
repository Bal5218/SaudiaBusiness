package modeles;

public class FlightBookingData {
	
	private final String TestCaseId;

	private final String TripType;
	private final String From;
	private final String To;
	private final String Departuredate;
	private final String Returndate;
	private final String TravellerType;
	private final String Employeedetails;
	
	private final String TripCategory;
	private final String MultiCityTo2;
	private final String MultiCityDepartureDate2;
	private final String Adults;
	private final String Children;
	private final String Infant;
	
	private final String Adult1Title;
	private final String Adult1FirstName;
	private final String Adult1LastName;
	private final String Adult1DOB;
	private final String Adult1Nationality;
	private final String Adult1PassportNumber;
	private final String Adult1PassportExpiry;
	private final String Adult1Issuingcountry;
	
	
	private final String Adult2Title;
	private final String Adult2FirstName;
	private final String Adult2LastName;
	private final String Adult2DOB;
	private final String Adult2Nationality;
	private final String Adult2PassportNumber;
	private final String Adult2PassportExpiry;
	private final String Adult2Issuingcountry;
	private final String paymentMethod;
	private final String CardNumber;
	
	private final String CardHolderName;
	
	private final String SecurityCode;
	private final String Expirymonth;
	private final String ExpiryYear;
	
	private final String OTP;
	
	
	
	
	
	
	public FlightBookingData(
			
			String TestCaseId,
			
			String TripType,
			String From,
			String To,
			String Departuredate,
			String Returndate,
			String TravellerType,
			String TripCategory,
			String Employeedetails,
		
			String MultiCityTo2,
			String MultiCityDepartureDate2,
			String Adults,
			String Children,
			String Infant,
			
			String Adult1Title,  
			String Adult1FirstName,
			String Adult1LastName,
			String Adult1DOB,
			String Adult1Nationality,
			String Adult1PassportNumber,
			String Adult1PassportExpiry,
			String Adult1Issuingcountry,
			
			
			
			String Adult2Title,
			String Adult2FirstName,
			String Adult2LastName,
			String Adult2DOB,
			String Adult2Nationality,
			String Adult2PassportNumber,
			String Adult2PassportExpiry,
			String Adult2Issuingcountry,
			String paymentMethod,
			String CardNumber,
			String CardHolderName,
			String SecurityCode,
			String Expirymonth,
			String ExpiryYear,
			String OTP
			
			
			
			) {
			
		
		this.TestCaseId=TestCaseId;
	
		this.TripType=TripType;
		this.From=From;
		this.To=To;
		this.Departuredate=Departuredate;
		this.Returndate=Returndate;
		this.TravellerType=TravellerType;
		this.TripCategory=TripCategory;
		this.Employeedetails=Employeedetails; 
		
		this.MultiCityTo2=MultiCityTo2;
		this.MultiCityDepartureDate2=MultiCityDepartureDate2;
		
		this.Adults=Adults;
		this.Children=Children;
		this.Infant=Infant;
		
		this.Adult1Title=Adult1Title;
		this.Adult1FirstName=Adult1FirstName;
		this.Adult1LastName=Adult1LastName;
		this.Adult1DOB=Adult1DOB;
		this.Adult1Nationality=Adult1Nationality;
		this.Adult1PassportNumber=Adult1PassportNumber;
		this.Adult1PassportExpiry=Adult1PassportExpiry;
		this.Adult1Issuingcountry=Adult1Issuingcountry;
		
		this.Adult2Title=Adult2Title;
		this.Adult2FirstName=Adult2FirstName;
		this.Adult2LastName=Adult2LastName;
		this.Adult2DOB=Adult2DOB;
		this.Adult2Nationality=Adult2Nationality;
		this.Adult2PassportNumber=Adult2PassportNumber;
		this.Adult2PassportExpiry=Adult2PassportExpiry;
		this.Adult2Issuingcountry=Adult2Issuingcountry;
		this.paymentMethod=paymentMethod;
		this.CardNumber=CardNumber;
		this.CardHolderName=CardHolderName;
		this. SecurityCode= SecurityCode;
		this.Expirymonth=Expirymonth;
		this.ExpiryYear=ExpiryYear;
		this.OTP=OTP;
		
		
		
		
	}
	 public String getTestCaseId() {
	        return TestCaseId;
	    }
	    
	    
	    
	
	    public String getTripType() {
	        return TripType;
	    }
	
	    public String getFrom() {
	        return From;
	    }
	
	    public String getTo() {
	        return To;
	    }
	    public String getDeparturedate() {
	        return Departuredate;
	    }
	    public String getReturndate() {
	        return Returndate;
	    }
	    public String getTravellerType() {
	        return TravellerType;
	    }
	    public String getTripCategory() {
	        return TripCategory;
	    }
	    public String getEmployeedetails() {
	        return Employeedetails;
	    }
	    public String getMultiCityTo2() {
	        return MultiCityTo2;
	    }
		
	    public String getMultiCityDepartureDate2() {
	        return MultiCityDepartureDate2;
	    }
	    public String getAdults() {
	        return Adults;
	    }
			
			
	    public String getChildren() {
	        return Children;
	    }
	    
	    public String getInfant() {
	        return Infant;
	    }
		
	    public String getAdult1Title() {
	        return Adult1Title;
	    }
	    
	    public String getAdult1FirstName() {
	        return Adult1FirstName;
	    }
	    public String getAdult1LastName() {
	        return Adult1LastName;
	    }
	    public String getAdult1DOB() {
	        return Adult1DOB;
	    }
	    
	    public String getAdult1Nationality() {
	        return Adult1Nationality;
	    }
	    public String getAdult1PassportNumber() {
	        return Adult1PassportNumber;
	    }
		
			
	    public String getAdult1PassportExpiry() {
	        return Adult1PassportExpiry;
	    }
			
			
	    public String getAdult1Issuingcountry() {
	        return Adult1Issuingcountry;
	    }
			
		
	    public String getAdult2Title() {
	        return Adult2Title;
	    }
	    
	    public String getAdult2FirstName() {
	        return Adult2FirstName;
	    }
	    public String getAdult2LastName() {
	        return Adult2LastName;
	    }
	    public String getAdult2DOB() {
	        return Adult2DOB;
	    }
	    public String getAdult2Nationality() {
	        return Adult2Nationality;
	    }
	    public String getAdult2PassportNumber() {
	        return Adult2PassportNumber;
	    }
		
			
	    public String getAdult2PassportExpiry() {
	        return Adult2PassportExpiry;
	    }
			
			
	    public String getAdult2Issuingcountry() {
	        return Adult2Issuingcountry;
	    }
			
	    public String getPaymentMethod() {
	        return paymentMethod;
	    }
			
	    public String getCardNumber() {
	        return CardNumber;
	    }
			
	    public String getCardHolderName() {
	        return CardHolderName;
	    }
			
	    public String getSecurityCode() {
	        return SecurityCode;
	    }
			
	    
	    public String getExpirymonth() {
	        return Expirymonth;
	    }
			
	    public String getExpiryYear() {
	        return ExpiryYear;
	    }
			
		
	    public String getOTP() {
	        return OTP;
	    }
			
			
			
				
			
			
			

	

}
