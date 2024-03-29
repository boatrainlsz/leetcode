package com.boatrain.slidingwindow;

class ReplaceTheSubstringForBalancedString {
    public static void main(String[] args) {
        ReplaceTheSubstringForBalancedString solution = new ReplaceTheSubstringForBalancedString();
        System.out.println(solution.balancedString("QQQQQWERQWER"));
    }
    public int balancedString(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[idx(c)]++;
        }

        int partial = s.length() / 4;
        int res = s.length();

        if (check(cnt, partial)) {
            return 0;
        }
        for (int l = 0, r = 0; l < s.length(); l++) {
            while (r < s.length() && !check(cnt, partial)) {
                cnt[idx(s.charAt(r))]--;
                r++;
            }
            if (!check(cnt, partial)) {
                break;
            }
            res = Math.min(res, r - l);
            cnt[idx(s.charAt(l))]++;
        }
        return res;
    }

    public int idx(char c) {
        return c - 'A';
    }

    public boolean check(int[] cnt, int partial) {
        return cnt[idx('Q')] <= partial && cnt[idx('W')] <= partial && cnt[idx('E')] <= partial && cnt[idx('R')] <= partial;
    }
}

