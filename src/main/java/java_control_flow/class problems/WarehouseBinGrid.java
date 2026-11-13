
public class WarehouseBinGrid {

    static long[] warehouseSummary(int[][] grid) {

        long total = 0;
        int max = -1;
        int maxRow = -1;
        int maxCol = -1;

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                total += grid[i][j];

                if (grid[i][j] > max) {

                    max = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        return new long[]{total, maxRow, maxCol};
    }

    public static void main(String[] args) {

        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        long[] result = warehouseSummary(grid);

        System.out.println("Total: " + result[0]);

        System.out.println("Maximum Coordinate: ("
                + result[1] + ", " + result[2] + ")");
    }
}
