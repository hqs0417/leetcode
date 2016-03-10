package cn.edu.pku.unicorn.leetcode.p278;

/**
 * Created by v_zhengkun on 2016/3/6.
 * 278 Version Control
 */
public class VersionControl {
    private boolean[] versions;
    public VersionControl() {
        versions = new boolean[11];
        for (int i = 0; i < versions.length; i++) {
            versions[i] = false;
            if (i >= 7) {
                versions[i] = true;
            }
        }
    }
    boolean isBadVersion(int version) {
        return versions[version];
    }
}
