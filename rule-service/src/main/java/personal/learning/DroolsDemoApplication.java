package personal.learning;

import org.jbpm.marshalling.impl.ProcessMarshallerFactoryServiceImpl;
import org.kie.api.*;
import org.kie.api.builder.*;
import org.kie.api.runtime.*;
import org.kie.internal.io.ResourceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication public class DroolsDemoApplication {
	private static final String droolFile = "rulesdemo.drl";

	public static void main(String[] args) {
		SpringApplication.run(DroolsDemoApplication.class, args);
	}

//	public static void main(String[] args) {
//		KieServices kieServices = KieServices.Factory.get();
//				KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
//				kieFileSystem.write(ResourceFactory.newClassPathResource(droolFile));
//				KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
//				kieBuilder.buildAll();
//				KieModule kieModule = kieBuilder.getKieModule();
////				return kieServices.newKieContainer(kieModule.getReleaseId());
//	}
	ProcessMarshallerFactoryServiceImpl processMarshallerFactoryService;

	@Bean
	public KieContainer kieContainer() {
		KieServices kieServices = KieServices.Factory.get();
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		kieFileSystem.write(ResourceFactory.newClassPathResource(droolFile));
		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
		kieBuilder.buildAll();
		KieModule kieModule = kieBuilder.getKieModule();
		return kieServices.newKieContainer(kieModule.getReleaseId());
	}
}
