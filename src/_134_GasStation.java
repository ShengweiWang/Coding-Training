/**
 * Created by Shengwei_Wang on 11/4/16.
 */
public class _134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;
        int min = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; ++i) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                min = sum;
                index = i;
            }
        }
        if (min >= 0)
            return 0;
        sum = 0;
        for (int i = 0; i < gas.length; ++i) {
            index = (index + 1) % gas.length;
            sum += gas[index] - cost[index];
            if (sum < 0)
                return -1;
        }
        return (index + 1) % gas.length;
    }
}
