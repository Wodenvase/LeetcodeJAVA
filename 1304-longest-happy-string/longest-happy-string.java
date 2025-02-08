class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[0] - x[0]);

        if (a > 0) maxHeap.offer(new int[]{a, 'a'});
        if (b > 0) maxHeap.offer(new int[]{b, 'b'});
        if (c > 0) maxHeap.offer(new int[]{c, 'c'});

        while (!maxHeap.isEmpty()) {
            int[] first = maxHeap.poll();
            char char1 = (char) first[1];

            if (res.length() > 1 && res.charAt(res.length() - 1) == char1 && res.charAt(res.length() - 2) == char1) {
                if (maxHeap.isEmpty()) break;

                int[] second = maxHeap.poll();
                char char2 = (char) second[1];
                res.append(char2);
                second[0]--;

                if (second[0] > 0) maxHeap.offer(second);
                maxHeap.offer(first);  // Put the first character back in the heap
            } else {
                res.append(char1);
                first[0]--;
                if (first[0] > 0) maxHeap.offer(first);
            }
        }
        return res.toString();
    }
}