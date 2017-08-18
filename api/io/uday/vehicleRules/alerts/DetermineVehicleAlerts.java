package io.uday.vehicleRules.alerts;

import com.deliveredtechnologies.rulebook.lang.RuleBuilder;
import com.deliveredtechnologies.rulebook.model.rulechain.cor.CoRRuleBook;

public class DetermineVehicleAlerts extends CoRRuleBook<String> {
	
	@Override
	public void defineRules(){
		//System.out.println("inside define rules");
		
		//Rule: engineRpm > readlineRpm, Priority: HIGH
	    addRule(RuleBuilder.create()
	      .when(facts -> facts.getIntVal("engineRpm") > facts.getIntVal("readLineRpm"))
	      .then((facts, result) -> result.setValue("HIGH")).stop().build());
	    
	    //Rule: fuelVolume < 10% of maxFuelVolume, Priority: MEDIUM
	    addRule(RuleBuilder.create().withResultType(String.class)
	      .when(facts -> facts.getDblVal("fuelVolume") < (facts.getDblVal("maxFuelVolume")/10))
	      .then((facts, result) -> result.setValue("MEDIUM")).stop().build());
	    
	    //Rule: tire pressure of any tire < 32psi || > 36psi , Priority: LOW
	    addRule(RuleBuilder.create().withResultType(String.class)
	      .when(facts -> isBetween(facts.getIntVal("frontLeft")) ||
	    		  		 isBetween(facts.getIntVal("frontRight")) ||
	    		         isBetween(facts.getIntVal("rearLeft")) ||
	    		         isBetween(facts.getIntVal("rearRight")))
	      .then((facts, result) -> result.setValue("LOW")).stop().build());
	    
	  //Rule: engineCoolantLow = true || checkEngineLightOn = true, Priority: LOW
	    addRule(RuleBuilder.create().withResultType(String.class)
	      .when(facts -> facts.getBoolVal("engineCoolantLow") || facts.getBoolVal("checkEngineLightOn"))
	      .then((facts, result) -> result.setValue("LOW")).build());	    
		
	}
	
	public static boolean isBetween(int value)
	{
	  return((value < 32) || (value > 36));
	}

}
