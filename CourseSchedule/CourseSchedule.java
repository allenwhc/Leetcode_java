import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class CourseSchedule{
	public static boolean canFinish(int numCourses, int[][] prerequisites){
		int numPrerequisites=prerequisites.length;
		if(numPrerequisites==0 || numCourses==0) return true;
		List<Integer> getOrder=new ArrayList<Integer>();

		//Create adjacent matrix
		List<List<Integer>> adjacent_matrix=new ArrayList<List<Integer>>();
		for(int i=0; i<numCourses; i++)
			adjacent_matrix.add(new ArrayList<Integer>());
		for(int i=0; i<numPrerequisites; i++)
			adjacent_matrix.get(prerequisites[i][1]).add(prerequisites[i][0]);
		boolean[] mustTake=new boolean[numCourses];
		boolean[] hasTaken=new boolean[numCourses];
		for(int i=0; i<numCourses; i++)
			if (hasCycle(adjacent_matrix,getOrder,i,mustTake,hasTaken)) return false;
		return true;
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites){
		int numPrerequisites=prerequisites.length;
		int[] order=new int[numCourses];
		List<Integer> getOrder=new ArrayList<Integer>();
		List<List<Integer>> adjacent_matrix=new ArrayList<List<Integer>>();
		for(int i=0; i<numCourses; i++)
			adjacent_matrix.add(new ArrayList<Integer>());
		for(int i=0; i<numPrerequisites; i++)
			adjacent_matrix.get(prerequisites[i][1]).add(prerequisites[i][0]);
		boolean[] mustTake=new boolean[numCourses];
		boolean[] hasTaken=new boolean[numCourses];
		for(int i=0; i<numCourses; i++)
			if(hasCycle(adjacent_matrix,getOrder,i,mustTake,hasTaken)) return int[0];
		for(int i=0; i<numCourses; i++)
			order[i]=getOrder.get(numCourses-i-1);
		return order;
	}

	private static boolean hasCycle(List<List<Integer>> adjacent_matrix, List<Integer> getOrder, int v, boolean[] mustTake, boolean[] hasTaken){
		if(!mustTake[v]){
			mustTake[v]=hasTaken[v]=true;
			for(Integer u:adjacent_matrix.get(v)){
				if(!mustTake[u] && hasCycle(adjacent_matrix,getOrder,u,mustTake,hasTaken)) return true;
				else if(hasTaken[u]) return true;
			}
			getOrder.add(v);
		}
		hasTaken[v]=false;
		return false;
	}

	public static void main(String[] args) {
		int numCourses=4;
		int[][]	prerequisites={{1,0},{2,0},{3,1},{3,2}};
		System.out.println("# of courses: "+numCourses);
		for(int i=0; i<prerequisites.length; i++){
			System.out.println("Course "+prerequisites[i][0]+", prerequisite course: "+prerequisites[i][1]);
		}
		if(canFinish(numCourses,prerequisites))
			System.out.println("One can finish all courses.");
		else
			System.out.println("One can't finish all courses.");
		System.out.println("The order of courses taken is: "+Arrays.toString(findOrder(numCourses,prerequisites)));
	}
}