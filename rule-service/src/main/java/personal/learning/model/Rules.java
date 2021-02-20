package personal.learning.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
public class Rules {

	String scope;
	List<Statement> and;
	List<Statement> or;

}
