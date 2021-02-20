package personal.learning.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personal.learning.model.Rules;
import personal.learning.model.RulesResponse;
import personal.learning.service.RulesExecutionService;

@RestController
public class RuleController {

	@Autowired
	private RulesExecutionService rulesExecutionService;

	@PostMapping(value = "/rules")
	public RulesResponse executeRules(@RequestBody Rules rules) {
		// TODO Validate rules first

		return rulesExecutionService.execute(rules);
	}

}
