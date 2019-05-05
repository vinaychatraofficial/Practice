package ae;

import java.util.ArrayList;

public class GetLowestCommonManager {

	public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
		return findLowestCommonManager(topManager,reportOne,reportTwo).lowestMgr;
	}

	private static ReportNode findLowestCommonManager(OrgChart mgr, OrgChart reportOne, OrgChart reportTwo) {
		int noOfReports=0;
		for(OrgChart report:mgr.directReports){
			ReportNode node = findLowestCommonManager(report, reportOne, reportTwo);
			if(node.lowestMgr!=null) 
				return node;
			noOfReports+=node.noOfReports;
		}
		if(mgr==reportOne || mgr==reportTwo)
			noOfReports++;
		if(noOfReports==2)
			return new ReportNode(mgr,2);
		return new ReportNode(null,noOfReports);
	}

	static class ReportNode{
		OrgChart lowestMgr;
		int noOfReports;

		public ReportNode(OrgChart lowestMgr, int noOfReports){
			this.lowestMgr=lowestMgr;
			this.noOfReports=noOfReports;
		}
	}

	static class OrgChart {
		public char name;
		public ArrayList<OrgChart> directReports;

		OrgChart(char name) {
			this.name = name;
			this.directReports = new ArrayList<OrgChart>();
		}

		// This method is for testing only.
		public void addDirectReports(OrgChart[] directReports) {
			for (OrgChart directReport : directReports) {
				this.directReports.add(directReport);
			}
		}
	}
}
