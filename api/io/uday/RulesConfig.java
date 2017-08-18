package io.uday;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.deliveredtechnologies.rulebook.lang.RuleBookBuilder;
import com.deliveredtechnologies.rulebook.model.RuleBook;

import io.uday.vehicleRules.alerts.DetermineVehicleAlerts;


@Configuration
public class RulesConfig {
	
	@Bean
	public RuleBook ruleBook(){
		
		return RuleBookBuilder.create(DetermineVehicleAlerts.class).withResultType(String.class).withDefaultResult("LOW").build();
	}
}
