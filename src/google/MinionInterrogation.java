package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class MinionInterrogation {

    public static void main(String[] args) {
//        int[][] minions = {{5, 1, 5}, {10, 1, 2}};
        int[][] minions = {{390, 185, 624}, {686, 351, 947}, {276, 1023, 1024}, {199, 148, 250}};
        int[] next = answer(minions);
        String s = Arrays.toString(next);
        System.out.println(s);
    }

    private static int[] answer(int[][] minions) {
        int length = minions.length;
        int[] y = new int[length];
        for (int i = 0; i < length; i++) {
            y[i] = i;
        }
        List<int[]> permutations = Utils.findPermutations(y);
        SortedMap<Double, int[]> map = new TreeMap<>();
        for (int[] permutation : permutations) {
            double sum = minions[permutation[0]][0];
            for (int j = 1, permutationLength = permutation.length; j < permutationLength; j++) {
                int minionIndex = permutation[j];
                int time = minions[minionIndex][0];
                int i = permutation[j - 1];
                int numerator = minions[i][1];
                int denominator = minions[i][2];
                sum += time * (denominator - numerator) / (double)denominator;
            }
            map.put(sum, permutation);
        }
        return map.values().iterator().next();
    }

    public static class Utils {
        public static List<int[]> findPermutations(int[] y) {
            List<int[]> permutations = new ArrayList<>(factorial(y.length));
            for (int i = y.length - 1; i >= 0; i--) {
                perm(y, i, permutations);
            }
            Collections.sort(permutations, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    String s1 = "";
                    for (int i : o1) {
                        s1 += i;
                    }
                    String s2 = "";
                    for (int i : o2) {
                        s2 += i;
                    }
                    return -s1.compareTo(s2);
                }
            });
            return permutations;
        }

        private static void perm(int[] y, int i, Collection<int[]> permutations) {
            if (permutations.isEmpty()) {
                permutations.add(new int[]{y[i]});
            } else {
                Collection<int[]> newPerms = new ArrayList<>(factorial(y.length - i));
                for (int[] permutation : permutations) {
                    int[] newPerm = concat(y[i], permutation);
                    newPerms.add(newPerm);
                    for (int j = 0, length = newPerm.length; j < length - 1; j++) {
                        newPerm = pushRight(newPerm, j);
                        newPerms.add(newPerm);
                    }
                }
                permutations.clear();
                permutations.addAll(newPerms);
            }
        }

        private static int[] pushRight(int[] newPerm, int j) {
            return swap(Arrays.copyOf(newPerm, newPerm.length), j);
        }

        private static int[] swap(int[] copy, int j) {
            int temp = copy[j];
            copy[j] = copy[j + 1];
            copy[j + 1] = temp;
            return copy;
        }


        public static int factorial(int x) {
            if (x == 1 || x == 0) {
                return 1;
            }
            return x * factorial(x - 1);
        }


        private static int[] concat(int head, int[] arr) {
            int length = arr.length;
            int[] ints = new int[length + 1];
            ints[0] = head;
            for (int i = 1, j = 0; j < length; i++, j++) {
                ints[i] = arr[j];
            }
            return ints;
        }

    }
}
