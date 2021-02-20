package personal.learning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.learning.model.Rules;
import personal.learning.model.RulesResponse;
import personal.learning.utils.DroolsUtils;

@Service
public class RulesExecutionService {

	@Autowired
	private DroolsUtils droolsUtils;

	public RulesResponse execute(Rules rules) {

		droolsUtils.evaluateQueryByRules(rules);
		return RulesResponse.builder().build();
	}

}
