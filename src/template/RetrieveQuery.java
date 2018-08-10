package template;

import enums.MemberQuery;

public class RetrieveQuery extends QueryTemplate{

	@Override
	void initialize() {
		map.put("sql", MemberQuery.RETRIEVE.toString());
		
	}

	@Override
	void startPlay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void endPlay() {
		// TODO Auto-generated method stub
		
	}

}
