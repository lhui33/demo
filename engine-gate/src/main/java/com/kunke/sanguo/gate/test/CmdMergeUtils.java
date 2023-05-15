package com.kunke.sanguo.gate.test;

public class CmdMergeUtils {
    private CmdMergeUtils() {}

    public static int getCmd(int cmdMerge) {
        return cmdMerge >> 16;
    }

    /**
     * 得到子路由
     * 从 cmdMerge 中获取 [低16位] 的数值
     *
     * @param cmdMerge 合并路由 cmdMerge
     * @return [低16位] 的数值
     */
    public static int getSubCmd(int cmdMerge) {
        return cmdMerge & 0xFFFF;
    }

    /**
     * 合并两个参数,分别存放在 [高16 和 低16]
     * <pre>
     *     cmd - 高16
     *     subCmd - 低16
     *     例如 cmd = 1; subCmd = 1;
     *     mergeCmd 的结果: 65537
     *     那么 mergeCmd 对应的二进制是: [0000 0000 0000 0001] [0000 0000 0000 0001]
     * </pre>
     *
     * @param cmd    主路由存放于合并结果的高16位, 该参数不得大于 32767
     * @param subCmd 子路由存放于合并结果的低16位, 该参数不得大于 65535
     * @return 合并的结果
     */
    public static int merge(int cmd, int subCmd) {
        return (cmd << 16) + subCmd;
    }

    public static void main(String[] args) {
        System.out.println("cmdMerge：" + merge(100, 2));
        System.out.println(getCmd(6553602) + ":" + getSubCmd(6553602));
//        getStringJson();
    }
}
