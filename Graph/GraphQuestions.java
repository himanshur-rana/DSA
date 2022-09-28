package Graph;

public class GraphQuestions {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int answer = 0;
        Boolean[][] visited = new Boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    if(grid[i][j] == '1') {
                        answer++;
                        dfs(grid, visited, i, j);
                    }
                }
            }
        }
        return answer;
    }
    
    private void dfs(char[][] grid, Boolean[][] visited, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        for(int rowCounter = -1; rowCounter <= 1; rowCounter++) {
            int x = i + rowCounter;
            if(x >= 0 && x < m && !visited[x][j] && grid[x][j] == '1') {
                visited[x][j] = true;
                dfs(grid, visited, x, j);                
            }            
        }
        for(int rowCounter = -1; rowCounter <= 1; rowCounter++) {
            int y = j + rowCounter;
            if(y >= 0 && y < n && !visited[i][y] && grid[i][y] == '1') {
                visited[i][y] = true;
                dfs(grid, visited, i, y);                
            }            
        }        
    }
}