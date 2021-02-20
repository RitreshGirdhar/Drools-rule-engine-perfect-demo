package personal.learning.model;

import lombok.*;

@Getter
@Setter
@Builder
public class Statement {

	String operator;
	String attributeName;
	Double value;

}
