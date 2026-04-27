import java.util.ArrayList;
import java.util.List;

//Rat In a Maze
public class qs8 {
    /*
    //Similar to Word Search not completely

    Rat can move on 1 cell and not 0 cell

D L R U

      [1, 0, 0, 0] ,
      [1, 1, 0, 1],
      [1, 1, 0, 0],
      [0, 1, 1, 1]



     */
    public static List<String> findPaths(int[][] maze) {
        List<String> result = new ArrayList<>();
        int[][] visited = new int[maze.length][maze[0].length];
        //no path
        if (maze[0][0] == 0) {
            return result;
        }
        solve("", 0, 0, result, visited, maze);
        return result;

    }

    public static void solve(String path, int i, int j, List<String> result, int[][] visited, int[][] maze) {
        //rowIndex=i
        //colIndex=j
        int n = maze.length;
        int m = maze[0].length;
        //destination reached -> at last
        if (i == n - 1 && j == m - 1) {
            result.add(path);
            return;
        }

        // Mark current cell visited
        visited[i][j] = 1;

        //down
        if (i + 1 < n && visited[i + 1][j] == 0 && maze[i + 1][j] == 1) {
            solve(path + "D", i + 1, j, result, visited, maze);
        }
        //left
        if (j - 1 >= 0 && visited[i][j - 1] == 0 && maze[i][j - 1] == 1) {
            solve(path + "L", i, j - 1, result, visited, maze);
        }
        //right
        if (j + 1 < n && visited[i][j + 1] == 0 && maze[i][j + 1] == 1) {
            solve(path + "R", i, j + 1, result, visited, maze);
        }
        //up
        if (i - 1 >= 0 && visited[i - 1][j] == 0 && maze[i - 1][j] == 1) {
            solve(path + "U", i - 1, j, result, visited, maze);
        }
        // Backtrack
        visited[i][j] = 0;

    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };
        System.out.println(findPaths(maze));
    }
}