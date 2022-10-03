package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphQuestions {

    class graphNode {
        int rN;
        int cN;
        graphNode(int rN, int cN) {
            this.cN = cN;
            this.rN = rN;
        }
    }
    public int orangesRotting(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<graphNode> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new graphNode(i, j));
                    visited[i][j] = true;
                }
            }
        }
        queue.add(null);

        int time = 0;

        while(!queue.isEmpty()) {
            time++;
            while(queue.peek() != null) {
                graphNode gN = queue.poll();
                for(int i = -1; i <= 1; i++) {
                    int row = gN.rN + i;
                    int col = gN.cN;
                    if(row >= 0 && row < grid.length && !visited[row][col] && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        visited[row][col] = true;
                        queue.add(new graphNode(row, col));
                    }
                }
                for(int i = -1; i <= 1; i++) {
                    int row = gN.rN;
                    int col = gN.cN + i;
                    if(col >= 0 && col < grid[0].length && !visited[row][col] && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        visited[row][col] = true;
                        queue.add(new graphNode(row, col));
                    }
                }                
            }
            queue.poll();
            if(!queue.isEmpty()) {
                time++;
                queue.add(null);
            }
        }
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }        
        return time;
    }    

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        visited[sr][sc] = true;
        floodFillDFS(image, sr, sc, color, visited);
        return image;
    }   
    
    private void floodFillDFS(int[][] image, int sr, int sc, int color, boolean[][] visited) {
        int prevColor = image[sr][sc];
        image[sr][sc] = color;
        for(int i = -1; i <= 1; i++) {
            if((sr + i) >= 0 && (sr + i) < image.length && !visited[sr + i][sc] && image[sr + i][sc] == prevColor) {
                visited[sr + i][sc] = true;
                floodFillDFS(image, sr + i, sc, color, visited);
            }
        }
        for(int i = -1; i <= 1; i++) {
            if((sc + i) >= 0 && (sc + i) < image[0].length && !visited[sr][sc + i] && image[sr][sc + i] == prevColor) {
                visited[sr][sc + i] = true;
                floodFillDFS(image, sr, sc + i, color, visited);
            }
        }        
    }

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