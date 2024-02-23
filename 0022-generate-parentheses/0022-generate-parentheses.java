class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrackHelper(0, 0, n, "", result);
        return result;
    }
    public void backtrackHelper(int openN, int closedN, int n, String current, List<String> result) {
        if (openN == closedN && openN == n) {
            result.add(current);
            return;
        }
        if (openN < n) {
            backtrackHelper(openN + 1, closedN, n, current + "(", result);
        }

        if (closedN < openN) {
            backtrackHelper(openN, closedN + 1, n, current + ")", result);
        }
    }
}