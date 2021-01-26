package _每日一题._2021年._21年1月;

/**
 * @ClassName: _1232缀点成线
 * @Author: lerry_li
 * @CreateDate: 2021/01/26
 * @Description
 */
public class _1232缀点成线 {
    /**
     * 解法1：斜率 时间O(N) 空间O(1)
     */
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length < 2 || coordinates[0].length < 2) {
            return false;
        }

        float slope;
        if (coordinates[1][0] == coordinates[0][0]) {
            slope = Float.MAX_VALUE;
        } else {
            slope = (coordinates[1][1] - coordinates[0][1])*1.0f / (coordinates[1][0] - coordinates[0][0]);
        }


        for (int i = 2; i < coordinates.length; i++) {
            float slope_;
            if (coordinates[i][0] == coordinates[0][0]) {
                slope_ = Float.MAX_VALUE;
            } else {
                slope_ = (coordinates[i][1] - coordinates[0][1])*1.0f / (coordinates[i][0] - coordinates[0][0]);
            }

            System.out.printf("slope:%f,slope_:%f%n",slope,slope_);
            if (slope_ != slope) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        _1232缀点成线 instance = new _1232缀点成线();
        int[][] coordinates = {{0,0},{0,5},{5,0},{1337,0},{0,1337}};
        System.out.println(instance.checkStraightLine(coordinates));
    }
}
