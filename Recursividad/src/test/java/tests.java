public class tests {
    public static void main(String[] args) {
        int[] torreO = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] torreA = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] torreD = new int[]{7, 6, 5, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(getTop(torreO));
        System.out.println(getTop(torreA));
        System.out.println(getTop(torreD));
    }

    private static int getTop(int[] torre) {
        for (int i = torre.length - 1; i >= 0; i--) {
            if (torre[i] != 0) {
                return i;
            }
        }
        return 0;
    }

}
