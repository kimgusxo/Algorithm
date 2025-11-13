class Solution {
    
    static int zero = 0;
    static int one = 0;

    public int[] solution(int[][] arr) {

        int divide = arr.length;

        while(divide != 1) {
            for(int i = 0; i < arr.length; i += divide) {
                for(int j = 0; j < arr[0].length; j += divide) {
                    arr = comp(arr, i, j, divide);
                }
            }

            divide /= 2;
        }

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 0) {
                    zero++;
                } else if(arr[i][j] == 1) {
                    one++;
                }
            }
        }

        return new int[]{zero, one};
    }

    public static int[][] comp(int[][] arr, int i, int j, int divide) {
        int start = arr[i][j];
        for(int x = i; x < i+divide; x++) {
            for(int y = j; y < j+divide; y++) {
                if(start != arr[x][y]) {
                    return arr;
                }
            }
        }

        for(int x = i; x < i+divide; x++) {
            for(int y = j; y < j+divide; y++) {
                arr[x][y] = -1;
            }
        }

        if(start == 0) {
            zero++;
        } else if(start == 1) {
            one++;
        }


        return arr;
    }
}