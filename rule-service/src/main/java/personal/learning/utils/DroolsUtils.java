package personal.learning.utils;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.learning.model.RuleGlobalSharedResponse;
import personal.learning.model.Rules;

@Service
public class DroolsUtils {

//	@Autowired
//	private KieContainer kieContainer;

	public String evaluateQueryByRules(Rules rules){

		KieServices kieServices = KieServices.Factory.get();
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		kieFileSystem.write(ResourceFactory.newClassPathResource("rulesdemo.drl"));
		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
		kieBuilder.buildAll();
		KieModule kieModule = kieBuilder.getKieModule();
		KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());

		KieSession kieSession = kieContainer.newKieSession();
		RuleGlobalSharedResponse ruleGlobalSharedResponse = RuleGlobalSharedResponse.builder().build();
		kieSession.setGlobal("ruleGlobalSharedResponse", ruleGlobalSharedResponse);
		kieSession.insert(rules);
		kieSession.fireAllRules();
		kieSession.dispose();
		return "";
	}
}
