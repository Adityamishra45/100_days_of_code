// Flipping an Image

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] arr = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            for (int j = image[i].length-1,k = 0; j >= 0; j--,k++) 
            {
                arr[i][k] = 1 - image[i][j];
            }
        }
        return arr;
    }
}
