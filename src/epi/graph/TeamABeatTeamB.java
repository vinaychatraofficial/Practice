package epi.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author vcpaks
 * Given a sequence of matches between teams, find if team a can beat team b
 */
public class TeamABeatTeamB {

	public static void main(String[] args) {
		List<Match> matches = new ArrayList<>();
		matches.add(new Match("A","C"));
		matches.add(new Match("A","D"));
		matches.add(new Match("C","E"));
		matches.add(new Match("E","F"));
		matches.add(new Match("E","G"));
		matches.add(new Match("G","B"));
		System.out.println(canTeamABeatTeamB(matches, "A", "B"));
	}
	
	public static class Match{
		String winningTeam;
		String losingTeam;
		
		public Match(String winningTeam, String losingTeam) {
			this.winningTeam = winningTeam;
			this.losingTeam = losingTeam;
		}
	}
	
	private static boolean canTeamABeatTeamB(List<Match> matches, String teamA, String teamB) {
		Set<String> visited = new HashSet<>();
		Map<String, Set<String>> graph = buildGraph(matches);
		return isReachableDFS(graph, teamA, teamB, visited);
	}

	private static boolean isReachableDFS(Map<String, Set<String>> graph, String curr, String dest,
			Set<String> visited) {
		if(curr.equals(dest))
			return true;
		if(visited.contains(curr) || graph.get(curr)==null)
			return false;
		visited.add(curr);
		for(String team:graph.get(curr)) {
			if(isReachableDFS(graph, team, dest, visited))
				return true;
		}
		return false;
	}

	private static Map<String, Set<String>> buildGraph(List<Match> matches) {
		Map<String, Set<String>> graph = new HashMap<>();
		for(Match match:matches) {
			Set<String> edges = graph.get(match.winningTeam);
			if(edges==null) {
				edges = new HashSet<>();
				graph.put(match.winningTeam, edges);
			}
			edges.add(match.losingTeam);
			
		}
		return graph;
	}

}
