package edu.leetcode.tasks.medium;

public class MirrorReflection {
    public int mirrorReflection(int p, int q) {
        int h = 0;
        int v = 0;
        int sign = 1;
        while (true) {
            v = v + sign * q;
            if (v > p) {
                v = p - (v - p);
                sign = -1;
            } else if (v < 0) {
                v = v * -1;
                sign = 1;
            }

            h = h == 0 ? p : 0;
            if (v == p) {
                if (h == p)
                    return 1;
                else
                    return 2;
            } else if (v == 0) {
                if (h == p) {
                    return 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        MirrorReflection r = new MirrorReflection();
        System.out.println(r.mirrorReflection(1, 1)); //1
        System.out.println(r.mirrorReflection(2, 1)); //2
        System.out.println(r.mirrorReflection(3, 1)); //1
        System.out.println(r.mirrorReflection(3, 2)); //0
        System.out.println(r.mirrorReflection(5, 1)); //1
        System.out.println(r.mirrorReflection(5, 4)); //0
    }
}
