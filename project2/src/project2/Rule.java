package project2;

public class Rule
{
	private final Antecedent antecedent;
	private final Consequence consequence;
	private final String ruleId;

	public Rule(String ruleId, Antecedent antecedent, Consequence consequence)
	{
		this.ruleId = ruleId;
		this.antecedent = antecedent;
		this.consequence = consequence;		
	}
	

	public boolean fire(Context context)
	{
		if (context.hasFired(ruleId))
		{
			return false;
		}
		
		if (antecedent.applies(context))
		{
			consequence.execute(context);
			context.onRuleFired(ruleId);
			return true;
		}
		
		return false;
	}
}

