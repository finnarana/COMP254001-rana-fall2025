package maps;

import java.util.Random;

public class Experiment {

    public static void main(String[] args) {
        int N = 100_000;
        float[] loadFactors = {0.25f, 0.5f, 0.75f};
        Random rand = new Random();

        for (float lf : loadFactors) {
            // uses constructor (int cap, double mxLdFactor)
            ChainHashMap<Integer,Integer> map = new ChainHashMap<>(1000, lf);

            long startBuild = System.nanoTime();
            for (int i = 0; i < N; i++) {
                int key = rand.nextInt();
                map.put(key, i);
            }
            long endBuild = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                map.get(rand.nextInt());
            }

            long buildDurationMs = (endBuild - startBuild) / 1_000;

            System.out.printf(
                    "loadfactor: %.2f | build time: %d ms | size: %d%n",
                    lf, buildDurationMs, map.size()
            );
        }
    }
}
