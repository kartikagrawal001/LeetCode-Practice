class Pair {
    int first;
    char second;
    Pair(int f, char ch) {
        first = f;
        second = ch;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> free = new HashMap<>();
        for (char ch : tasks) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            free.put(ch, 1);
        }
        Queue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.first - a.first
        );
        for (char ch : freq.keySet()) {
            pq.offer(new Pair(freq.get(ch), ch));
        }
        int spot = 1;
        while (!pq.isEmpty()) {
            List<Pair> temp = new ArrayList<>();
            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                if (free.get(p.second) <= spot) {
                    p.first--;
                    free.put(p.second, spot + n + 1);
                    if (p.first > 0) {
                        pq.offer(new Pair(p.first, p.second));
                    }
                    break;
                }
                temp.add(p);
            }
            for (Pair p : temp) {
                pq.offer(p);
            }
            spot++;
        }
        return spot - 1;
    }
}