class CountServersthatCommunicate
 {
    public int countServers(int[][] grid) {
        int row[]=new int[grid.length];
        int col[]=new int[grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    row[i]+=1;
                }
            }
        }
        for(int i=0;i<grid[0].length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[j][i]==1){
                    col[i]+=1;
                }
            }
        }
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && (row[i]>1||col[j]>1)){
                    ans++;
                }
            }
        }
        return ans;
    }
}