package ae;

import java.util.ArrayList;

public class Underscorify {

	public static String underscorifySubstring(String str, String substring) {
		ArrayList<Integer> locations = findLocations(str, substring);
		String finalStr = underscorify(str,locations);
		System.out.println("finalStr:"+finalStr);
		return finalStr;
	}

	private static String underscorify(String str, ArrayList<Integer> locations){
		int locationIdx = 0;
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<str.length();i++){
			if(locationIdx<locations.size() && i==locations.get(locationIdx)){
				builder.append("_");
				locationIdx++;
			}
			builder.append(str.charAt(i));
		}
		if(locationIdx!=locations.size())
			builder.append("_");
		return builder.toString();
	}

	private static ArrayList<Integer> findLocations(String str, String substring){
		ArrayList<Integer> locations = new ArrayList<>();
		int index = 0;
		while(index<str.length()){
			int start = str.indexOf(substring, index);
			if(start==-1)
				break;
			int end = start+substring.length();
			//first substring or start of substring is greater than prev substring end
			if(locations.isEmpty() || start > locations.get(locations.size()-1)){ 
				locations.add(start);
				locations.add(end);
			}else{ // if overlap extend the end
				locations.remove(locations.size()-1);
				locations.add(end);
			}
			index = start+1;
		}
		for(Integer location:locations)
			System.out.print(location+" ");
		return locations;
	}
}
