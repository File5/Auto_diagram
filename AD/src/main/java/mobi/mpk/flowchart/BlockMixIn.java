package mobi.mpk.flowchart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(  
	use = JsonTypeInfo.Id.NAME,  
	include = JsonTypeInfo.As.PROPERTY,  
	property = "type"
)  
@JsonSubTypes({  
    @Type(value = BreakLine.class, name = "BreakLine"),  
    @Type(value = Case.class, name = "Case"),
    @Type(value = Comment.class, name = "Comment"),
    @Type(value = ContinueLine.class, name = "ContinueLine"),
    @Type(value = DoWhileCycle.class, name = "DoWhileCycle"),
    @Type(value = EmptyBlock.class, name = "EmptyBlock"),
    @Type(value = ForCycle.class, name = "ForCycle"),
    @Type(value = Function.class, name = "Function"),
    @Type(value = FunctionCall.class, name = "FunctionCall"),
    @Type(value = IOBlock.class, name = "IOBlock"),
    @Type(value = ReturnStatement.class, name = "ReturnStatement"),
    @Type(value = SelectorBlock.class, name = "SelectorBlock"),
    @Type(value = Statement.class, name = "Statement"),
    @Type(value = WhileCycle.class, name = "WhileCycle")
})
@JsonIgnoreProperties(value = {
	"HALFOFNORMALLENGHT",
	"HALFOFNORMALHIGHT",
	"THEBIGGESTLENGHT",
	"thereABreakInElseBody",
	"thereAReturnInBody",
	"thereAReturnInElseBody",
	"thereABreakInBody",
	"thereAContinueInBody",
	"thereAContinueInElseBody",
	"ret"
})
public abstract class BlockMixIn {

}
